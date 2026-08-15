# Rescue Animal Dashboard, made by Stephen DaSilva
# Enhancements to make functional outside of Jupyter Notebook
# and to integrate an admin database management UI

# Setup Dash
from dash import Dash

# Configure the necessary Python module imports for dashboard components
import dash_leaflet as dl
from dash import dcc, html
import plotly.express as px
from dash import dash_table, no_update
from dash.dependencies import Input, Output, State
import base64
import io

# Configure OS routines
import os

# Configure the plotting routines
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# Modules for database management
from datetime import datetime

# imports CRUD module
from CRUD_Python_Module import AnimalShelter

# CRUD Module instantiated separately

#########################
# Dashboard Layout / View
#########################
app = Dash(__name__)

# Loads Grazioso Salvare's Logo
image_filename = 'Grazioso Salvare Logo.png'
encoded_image = base64.b64encode(open(image_filename, 'rb').read())

app.layout = html.Div([
html.Div(
    style={ # centers image and identifier
        'display': 'flex',
        'alignItems': 'center', 
        'justifyContent': 'center',
        'gap': '20px',
        'marginBottom': '20px'
    },
    children=[
        html.A( # Adds logo with anchor url tag
            href="https://www.snhu.edu",
            target="_blank",
            children=[
                html.Img(
                    src='data:image/png;base64,{}'.format(encoded_image.decode()), # inserts image
                    style={'height': '80px'} # makes image relatively small
                )
            ]
        ),
        html.H1("Grazioso Salvare Dashboard") # Identifier
    ]
),
    html.Hr(),
    html.Div(className='buttonRow', # Adds filtering options
            style={'display': 'flex', 'justifyContent': 'center'},
            children=[
                dcc.RadioItems(
                    id='filter-type',
                    options=[
                        {'label': 'Water Rescue', 'value': 'Water'},
                        {'label': 'Mountain Rescue', 'value': 'Mountain'},
                        {'label': 'Disaster Rescue', 'value': 'Disaster'},
                        {'label': 'Reset', 'value': 'Reset'}
                    ],
                    inline=True, # makes them appear in a row
                    inputStyle={'margin-right': '6px', 'margin-left': '12px'}
            )
        ]
    ),

    html.Hr(),
    dash_table.DataTable(
        id='datatable-id',
        columns=[],
        data=[],
        # added user-friendly features, text-based filter, sorting, and pagination
        editable=False,
        filter_action="native",
        sort_action="native",
        sort_mode="multi",
        column_selectable=False,
        row_selectable="single", # necessary for callback to function
        row_deletable=False,
        selected_columns=[],
        selected_rows=[0], # to prevent issues
        page_action="native",
        page_current=0,
        page_size=10,
        # table size changed to fit window without horizontal scrolling
        style_table={
        'maxHeight': '500px',
        'overflowY': 'auto',
        'overflowX': 'auto'
        }
    ),
    html.Br(),
    html.Hr(),
    #This sets up the dashboard so that the chart and geolocation chart are side-by-side
    html.Div(className='row',
         style={'display' : 'flex'},
             children=[
        html.Div(
            id='graph-id',
            className='col s12 m6',

            ),
        html.Div(
            id='map-id',
            className='col s12 m6',
            )
        ]),
    
    html.Hr(),
    dcc.Store(id="refresh-signal"), # used to trigger dashboard refreshes
    dcc.Store(id="db-connection"), # stores connection info/credentials

    #########################
    # Database Connection Layout / View
    #########################
    html.Div(
        id="db-connect-panel",
        style={
            "backgroundColor": "white",
            "padding": "25px",
            "borderRadius": "10px",
            "marginBottom": "30px",
            "boxShadow": "0 2px 8px rgba(0,0,0,0.15)",
            "maxWidth": "600px",
            "marginLeft": "auto",
            "marginRight": "auto"
        },
        children=[
            html.H3("Database Connection", style={"textAlign": "center"}),

            html.Div(
                style={
                    "display": "grid",
                    "gridTemplateColumns": "1fr 1fr",
                    "gap": "10px",
                    "marginBottom": "15px"
                },
                children=[
                    dcc.Input(id="db-username", placeholder="Username", type="text"),
                    dcc.Input(id="db-password", placeholder="Password", type="password"),
                    dcc.Input(id="db-host", placeholder="Host (e.g., localhost)", type="text"),
                    dcc.Input(id="db-port", placeholder="Port (e.g., 27017)", type="number"),
                    dcc.Input(id="db-name", placeholder="Database Name", type="text"),
                    dcc.Input(id="db-collection", placeholder="Collection Name", type="text"),
                ]
            ),

            html.Div(
                style={"display": "flex", "justifyContent": "center"},
                children=[
                    html.Button(
                        "Connect",
                        id="db-connect-button",
                        style={
                            "backgroundColor": "#4CAF50",
                            "color": "white",
                            "padding": "10px 18px",
                            "border": "none",
                            "borderRadius": "6px",
                            "cursor": "pointer"
                        }
                    )
                ]
            ),

            html.Div(id="db-connect-status", style={"textAlign": "center", "marginTop": "10px"})
        ]
    ),

    #########################
    # Database Management Layout / View
    #########################

    html.Div(
        id="management-panel",
        style={
            "backgroundColor": "#f7f7f7",
            "padding": "25px",
            "borderRadius": "10px",
            "marginTop": "40px",
            "boxShadow": "0 2px 8px rgba(0,0,0,0.15)"
        },
        children=[
            html.H2("Database Management", style={"textAlign": "center", "marginBottom": "15px"}),

            # Add Animal
            html.Div(
                style={
                    "backgroundColor": "white",
                    "padding": "25px",
                    "borderRadius": "10px",
                    "marginBottom": "30px",
                    "boxShadow": "0 2px 8px rgba(0,0,0,0.15)",
                    "width": "80%",
                    "marginLeft": "auto",
                    "marginRight": "auto"
                },
                children=[
                    html.H3(
                        "Add Animal",
                        style={"textAlign": "center", "marginBottom": "20px"}
                    ),
                    html.Div(
                        style={
                            "display": "grid",
                            "gridTemplateColumns": "1fr 1fr",
                            "gap": "12px",
                            "marginBottom": "15px"
                        },
                        children=[
                            dcc.Input(id="input-animal-id", placeholder="Animal ID", type="text"),
                            dcc.Input(id="input-name", placeholder="Name", type="text"),
                            dcc.Input(id="input-type", placeholder="Animal Type", type="text"),
                            dcc.Input(id="input-breed", placeholder="Breed", type="text"),
                            dcc.Input(id="input-color", placeholder="Color", type="text"),
                            dcc.Input(id="input-sex", placeholder="Sex Upon Outcome", type="text"),
                            dcc.Input(id="input-age", placeholder="Age Upon Outcome (e.g., '2 years')", type="text"),
                            dcc.Input(id="input-age-weeks", placeholder="Age in Weeks", type="number"),
                            dcc.Input(id="input-dob", placeholder="Date of Birth (MM/DD/YYYY)", type="text"),
                            dcc.Input(id="input-datetime", placeholder="Outcome Datetime (YYYY-MM-DD HH:MM:SS)", type="text"),
                            dcc.Input(id="input-outcome", placeholder="Outcome Type", type="text"),
                            dcc.Input(id="input-lat", placeholder="Latitude", type="number"),
                            dcc.Input(id="input-long", placeholder="Longitude", type="number"),
                        ]),
                        html.Div(
                            style={"display": "flex", "justifyContent": "center", "marginTop": "10px"},
                            children=[
                                html.Button(
                                    "Add Animal",
                                    id="input-add-button",
                                    style={
                                        "backgroundColor": "#4CAF50",
                                        "color": "white",
                                        "padding": "10px 18px",
                                        "border": "none",
                                        "borderRadius": "6px",
                                        "cursor": "pointer"
                                    })
                            ]),
                        html.Div(id="input-add-status", style={"textAlign": "center", "marginBottom": "20px"}),
                    ]),

            # Update Animal
            html.Div(
                style={
                    "backgroundColor": "white",
                    "padding": "15px",
                    "borderRadius": "8px",
                    "marginBottom": "30px",
                    "width": "70%",
                    "marginLeft": "auto",
                    "marginRight": "auto",
                    "boxShadow": "0 1px 4px rgba(0,0,0,0.1)"
                },
                children=[
                    html.H3("Update Animal", style={"textAlign": "center", "marginBottom": "15px"}),

                    html.Div(
                        style={"display": "flex", "gap": "10px", "marginBottom": "10px"},
                        children=[
                            dcc.Dropdown(id="update-field", placeholder="Select field to update", style={"flex": "1"}),
                            dcc.Input(id="update-value", placeholder="New Value", style={"flex": "1"})
                        ]
                    ),

                    html.Div(
                        style={"display": "flex", "justifyContent": "center", "marginTop": "10px"},
                        children=[
                            html.Button(
                                "Update Selected Row",
                                id="update-button",
                                style={
                                    "backgroundColor": "#2196F3",
                                    "color": "white",
                                    "padding": "10px 18px",
                                    "border": "none",
                                    "borderRadius": "6px",
                                    "cursor": "pointer"
                                }
                            ),

                            html.Div(id="input-update-status", style={"textAlign": "center", "marginBottom": "20px"}),
                        ])
                    ]),
           
            # Delete Animal
            html.Div(
                style={
                    "backgroundColor": "white",
                    "padding": "15px",
                    "borderRadius": "8px",
                    "marginBottom": "30px",
                    "width": "70%",
                    "marginLeft": "auto",
                    "marginRight": "auto",
                    "boxShadow": "0 1px 4px rgba(0,0,0,0.1)"
                },
                children=[
                    html.H3("Delete Animal", style={"textAlign": "center", "marginBottom": "15px"}),

                html.Div(
                    style={"display": "flex", "justifyContent": "center", "marginTop": "10px"},
                    children=[
                        html.Button(
                            "Delete Selected Row",
                            id="delete-button",
                            style={
                                "backgroundColor": "#F44336",
                                "color": "white",
                                "padding": "10px 18px",
                                "border": "none",
                                "borderRadius": "6px",
                                "cursor": "pointer"
                            }),
                        
                        html.Div(id="input-delete-status", style={"textAlign": "center", "marginBottom": "20px"}),
                    ])
                ]),

            
            # Bulk CSV Upload Tool
            html.Div(
                style={
                    "backgroundColor": "white",
                    "padding": "15px",
                    "borderRadius": "8px",
                    "marginBottom": "30px",
                    "width": "70%",
                    "marginLeft": "auto",
                    "marginRight": "auto",
                    "boxShadow": "0 1px 4px rgba(0,0,0,0.1)"
                },
                children=[
                    html.H3("Bulk CSV Upload", style={"textAlign": "center", "marginBottom": "15px"}),

                    dcc.Upload(
                        id="csv-upload",
                        children=html.Div([
                            "Drag and Drop or ",
                            html.A("Select a CSV File", style={"color": "#2196F3"})
                        ]),
                        style={
                            "width": "100%",
                            "height": "60px",
                            "lineHeight": "60px",
                            "borderWidth": "2px",
                            "borderStyle": "dashed",
                            "borderRadius": "8px",
                            "borderColor": "#2196F3",
                            "textAlign": "center",
                            "marginBottom": "15px",
                            "backgroundColor": "#fafafa"
                        },
                        multiple=False
                    ),

                    html.Div(id="csv-upload-status", style={"textAlign": "center", "marginBottom": "20px"}),
                ])
    ])
])


#############################################
# Interaction Between Components / Controller (Database)
#############################################
# Helper functions for callbacks
def get_shelter(conn):
    """Gets an AnimalShelter object based on the connection credentials

    Args:
        conn (db-connection): Database credentials

    Returns:
        AnimalShelter: the AnimalShelter object based on stored credentials
    """    
    return AnimalShelter(
        conn["username"],
        conn["password"],
        conn["host"],
        int(conn["port"]),
        conn["db"],
        conn["col"]
    )

FIELD_TYPES = { # Used for sanitize_value()
    "age_upon_outcome": "str",
    "age_upon_outcome_in_weeks": "float",
    "animal_id": "str",
    "animal_type": "str",
    "breed": "str",
    "color": "str",
    "date_of_birth": "date",
    "datetime": "str",
    "monthyear": "str",
    "name": "str",
    "outcome_subtype": "str",
    "outcome_type": "str",
    "sex_upon_outcome": "str",
    "location_lat": "float",
    "location_long": "float"
}

def sanitize_value(field, value):
    """Sanitizes a given input based on the field.

    Args:
        field (str): The field the value is being put in for
        value (any): The input value for the animal document

    Raises:
        ValueError: If input is invalid for the given field

    Returns:
        any:The sanitized value based on the input and field
    """    
    if value is None:
        raise ValueError("Value cannot be empty.")

    value = str(value).strip()
    expected = FIELD_TYPES.get(field, "str") # Gets expected data type, defaults to str in the event one is not found

    # Float/number fields
    if expected == "float":
        try:
            return float(value)
        except:
            raise ValueError(f"{field} must be a number.")

    # Date fields
    if expected == "date":
        try:
            # Convert MM/DD/YYYY → Python datetime
            dt = datetime.strptime(value, "%m/%d/%Y")
            return dt
        except:
            raise ValueError(f"{field} must be MM/DD/YYYY.")

    # String fields
    if expected == "str":
        if value == "":
            raise ValueError(f"{field} cannot be empty.")
        return value

    return value

def get_next_record_number(shelter):
    """Gets the next record number for the current database
    
    Args:
        shelter (AnimalShelter): the database object

    Returns:
        int: The latest record number based on the database
    """    
    last = shelter.collection.find().sort("1", -1).limit(1)
    last = list(last)
    if last:
        return int(last[0].get("1", 0)) + 1
    return 1

## Database callbacks
# Callback used to connect to database
@app.callback(
    Output("db-connection", "data"),
    Output("db-connect-status", "children"),
    Input("db-connect-button", "n_clicks"),
    State("db-username", "value"),
    State("db-password", "value"),
    State("db-host", "value"),
    State("db-port", "value"),
    State("db-name", "value"),
    State("db-collection", "value"),
    prevent_initial_call=True
)
def connect_to_database(n_clicks, username, password, host, port, db, col):
    try:
        shelter = AnimalShelter(username, password, host, int(port), db, col)
        shelter.read({})  # test connection

        return {
            "username": username,
            "password": password,
            "host": host,
            "port": port,
            "db": db,
            "col": col
        }, "Connected successfully."

    except Exception as e:
        return no_update, f"Connection failed: {str(e)}"

# Callback greys out database management UI until connection is completed
@app.callback(
    Output("management-panel", "style"),
    Input("db-connection", "data")
)
def enable_management_panel(conn):
    if conn is None:
        return {
            "opacity": "0.4",
            "pointerEvents": "none",
            "backgroundColor": "#f7f7f7",
            "padding": "25px",
            "borderRadius": "10px",
            "marginTop": "40px",
            "boxShadow": "0 2px 8px rgba(0,0,0,0.15)"
        }
    return {
        "opacity": "1.0",
        "pointerEvents": "auto",
        "backgroundColor": "#f7f7f7",
        "padding": "25px",
        "borderRadius": "10px",
        "marginTop": "40px",
        "boxShadow": "0 2px 8px rgba(0,0,0,0.15)"
    }

# Callback used to dynamically get list of fields to populate
# for the Update Animal menu
@app.callback(
    Output("update-field", "options"),
    Input("datatable-id", "derived_virtual_data")
)
def populate_update_fields(viewData):
    if not viewData:
        return []
    # Use the first row to get all column names
    columns = list(viewData[0].keys())
    return [{"label": col, "value": col} for col in columns]

# Callback used when the "Add Animal" form is submitted
# in the database management section.
# Takes the input values, builds a document with sanitization
# and uses the CRUD module to add it to database
@app.callback(
    [Output("refresh-signal", "data", allow_duplicate=True),
     Output("input-add-status", "children", allow_duplicate=True)],
    Input("input-add-button", "n_clicks"),
    State("input-animal-id", "value"),
    State("input-name", "value"),
    State("input-type", "value"),
    State("input-breed", "value"),
    State("input-color", "value"),
    State("input-sex", "value"),
    State("input-age", "value"),
    State("input-age-weeks", "value"),
    State("input-dob", "value"),
    State("input-datetime", "value"),
    State("input-outcome", "value"),
    State("input-lat", "value"),
    State("input-long", "value"),
    State("db-connection", "data"),
    prevent_initial_call=True
)
def add_animal(n_clicks, animal_id, name, animal_type, breed, color,
                    sex, age, age_weeks, dob, dt, outcome, lat, long, conn):

    if conn is None:
        return no_update, "Not connected to a database."
    
    shelter = get_shelter(conn)
    
    if not n_clicks:
        return no_update, ""

    try:
        # Builds animal document
        # sanitize_value() used with each field's value
        doc = {
            "1": get_next_record_number(shelter), # uses helper to get the correct number
            "animal_id": sanitize_value("animal_id", animal_id),
            "name": sanitize_value("name", name),
            "animal_type": sanitize_value("animal_type", animal_type),
            "breed": sanitize_value("breed", breed),
            "color": sanitize_value("color", color),
            "sex_upon_outcome": sanitize_value("sex_upon_outcome", sex),
            "age_upon_outcome": sanitize_value("age_upon_outcome", age),
            "age_upon_outcome_in_weeks": sanitize_value("age_upon_outcome_in_weeks", age_weeks),
            "date_of_birth": sanitize_value("date_of_birth", dob),
            "datetime": sanitize_value("datetime", dt),
            "monthyear": sanitize_value("monthyear", dt), # uses same value
            "outcome_type": sanitize_value("outcome_type", outcome),
            "location_lat": sanitize_value("location_lat", lat),
            "location_long": sanitize_value("location_long", long)
        }

        shelter.create(doc) # Adds document

        return {"refresh": True}, "Animal successfully added."

    except Exception as e: # Occurs if it failed, either due to the sanitization failing or some other reason
        return no_update, f"Error: {str(e)}"

# Callback used when "Update Animal" is selected
# Replaces the value of the selected row's selected field
# with the new input value, after sanitization
@app.callback(
    [Output("refresh-signal", "data", allow_duplicate=True),
     Output("input-update-status", "children", allow_duplicate=True)],
    Input("update-button", "n_clicks"),
    State("update-field", "value"),
    State("update-value", "value"),
    State("datatable-id", "derived_virtual_selected_rows"),
    State("datatable-id", "derived_virtual_data"),
    State("db-connection", "data"),
    prevent_initial_call=True
)
def update_animal(n_clicks, field, value, selected_rows, table, conn):

    if conn is None:
        return no_update, "Not connected to a database."

    shelter = get_shelter(conn)

    if not n_clicks or not selected_rows:
        return no_update, ""

    try:
        # Validate field selection
        if field is None:
            raise ValueError("You must select a field to update.")

        # Validate + sanitize value
        clean_value = sanitize_value(field, value)

        # Identify selected row
        row = selected_rows[0]
        dff = pd.DataFrame(table)
        animal_id = dff.loc[row, "animal_id"]

        # Perform update
        shelter.update({"animal_id": animal_id}, {field: clean_value})

        return {"refresh": True}, f"Successfully updated {field}."

    except Exception as e: # If sanitization failed, or some other error
        return no_update, f"Error: {str(e)}"

# Callback used when the Delete Animal option is selected
# deletes the animal from the database
# based on the selected row, using the animal_id
@app.callback(
    [Output("refresh-signal", "data", allow_duplicate=True),
     Output("input-delete-status", "children", allow_duplicate=True)],
    Input("delete-button", "n_clicks"),
    State("datatable-id", "derived_virtual_selected_rows"),
    State("datatable-id", "derived_virtual_data"),
    State("db-connection", "data"),
    prevent_initial_call=True
)
def delete_animal(n_clicks, selected_rows, table, conn):

    if conn is None:
        return no_update, "Not connected to a database."

    shelter = get_shelter(conn)

    try:
        if not n_clicks or not selected_rows:
            return no_update

        row = selected_rows[0]
        dff = pd.DataFrame(table)

        animal_id = dff.loc[row, "animal_id"]

        shelter.delete({"animal_id": animal_id})
        
        return {"refresh": True}, f"Successfully deleted animal: ID {animal_id}"
    except Exception as e:
        return no_update, f"Error: {str(e)}"

# Callback used when uploading a CSV
# can be very sensitive, included CSV files were used for testing
@app.callback(
    [Output("refresh-signal", "data", allow_duplicate=True),
     Output("csv-upload-status", "children")],
    Input("csv-upload", "contents"),
    State("csv-upload", "filename"),
    State("db-connection", "data"),
    prevent_initial_call=True
)
def bulk_upload(contents, filename, conn):

    if conn is None:
        return no_update, "Not connected to a database."

    shelter = get_shelter(conn)

    if contents is None: # In the event there is nothing
        return no_update, ""

    try:
        # Decode uploaded file
        content_type, content_string = contents.split(",")
        decoded = base64.b64decode(content_string)
        df = pd.read_csv(io.StringIO(decoded.decode("utf-8")))

        inserted = 0 # Counter for how many documents were added

        for _, row in df.iterrows(): # For loop over each row, getting input based on the column names

            # Build document using sanitize_value() for every field
            doc = {
                "1": get_next_record_number(shelter),
                "animal_id": sanitize_value("animal_id", row["animal_id"]),
                "name": sanitize_value("name", row.get("name", "")), # supports when there's no name, like in the original csv
                "animal_type": sanitize_value("animal_type", row["animal_type"]),
                "breed": sanitize_value("breed", row["breed"]),
                "color": sanitize_value("color", row["color"]),
                "sex_upon_outcome": sanitize_value("sex_upon_outcome", row["sex_upon_outcome"]),
                "age_upon_outcome": sanitize_value("age_upon_outcome", row["age_upon_outcome"]),
                "age_upon_outcome_in_weeks": sanitize_value("age_upon_outcome_in_weeks", row["age_upon_outcome_in_weeks"]),
                "date_of_birth": sanitize_value("date_of_birth", row["date_of_birth"]),
                "datetime": sanitize_value("datetime", row["datetime"]),
                "monthyear": sanitize_value("monthyear", row["monthyear"]),
                "outcome_type": sanitize_value("outcome_type", row["outcome_type"]),
                "location_lat": sanitize_value("location_lat", row["location_lat"]),
                "location_long": sanitize_value("location_long", row["location_long"])
            }

            shelter.create(doc)
            inserted += 1

        return {"refresh": True}, f"Successfully uploaded {inserted} records from {filename}."

    except Exception as e: # Error if something is wrong with the file or its contents
        return no_update, f"Error processing file: {str(e)}"

#############################################
# Interaction Between Components / Controller
#############################################
# Callback used both when selecting a new filter query
# and when dashboard is reloaded for some other reason
@app.callback(
    [Output('datatable-id','data'),
     Output('datatable-id','selected_rows'),
     Output('datatable-id','columns')],
    [Input('filter-type', 'value'),
     Input('refresh-signal', 'data'),
     Input('db-connection', 'data')]
)
def update_dashboard(filter_type, refresh_signal, conn):
    if conn is None:
        return [], [], []

    shelter = get_shelter(conn)

    query = {}

    # Apply filter based on radio selection
    # Query is based on the requirements
    if filter_type == 'Water':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "Labrador Retriever Mix",
                    "Chesa Bay Retr", # Chesapeake Bay Retriever does not seem to be in dataset, only mix with this shortened name
                    "Chesapeake Bay Retriever", # incase it is added under this name in the future
                    "Newfoundland"
                ]
            },
            "sex_upon_outcome": "Intact Female",
            "age_upon_outcome_in_weeks": {"$gte": 26, "$lte": 156}
        }

    elif filter_type == 'Mountain':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "German Shepherd",
                    "Alaskan Malamute",
                    "Old English Sheepdog",
                    "Siberian Husky",
                    "Rottweiler"
                ]
            },
            "sex_upon_outcome": "Intact Male",
            "age_upon_outcome_in_weeks": {"$gte": 26, "$lte": 156}
        }

    elif filter_type == 'Disaster':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "Doberman Pinsch", # This is what the Doberman Pinschers are called in the dataset
                    "Doberman Pinscher", # incase it is added under this name in the future
                    "German Shepherd",
                    "Golden Retriever",
                    "Bloodhound",
                    "Rottweiler"
                ]
            },
            "sex_upon_outcome": "Intact Male",
            "age_upon_outcome_in_weeks": {"$gte": 20, "$lte": 300}
        }
    # If filter_type is 'Reset' or not present, the base query is used
    
    df = pd.DataFrame.from_records(shelter.read(query))

    if '_id' in df.columns:
        df.drop(columns=['_id'], inplace=True)
        
    # Build columns dynamically
    columns = [{"name": i, "id": i} for i in df.columns]

    return df.to_dict('records'), [0], columns

"""
@app.callback( [Output('datatable-id','data'),
                Output('datatable-id','selected_rows')],
               [Input('filter-type', 'value'),
                Input('refresh-signal', 'data')] )
def update_dashboard(filter_type, refresh_signal):
    # Base query (Reset)
    query = {}

    # Apply filter based on radio selection
    # Query is based on the requirements
    if filter_type == 'Water':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "Labrador Retriever Mix",
                    "Chesa Bay Retr", # Chesapeake Bay Retriever does not seem to be in dataset, only mix with this shortened name
                    "Chesapeake Bay Retriever", # incase it is added under this name in the future
                    "Newfoundland"
                ]
            },
            "sex_upon_outcome": "Intact Female",
            "age_upon_outcome_in_weeks": {"$gte": 26, "$lte": 156}
        }

    elif filter_type == 'Mountain':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "German Shepherd",
                    "Alaskan Malamute",
                    "Old English Sheepdog",
                    "Siberian Husky",
                    "Rottweiler"
                ]
            },
            "sex_upon_outcome": "Intact Male",
            "age_upon_outcome_in_weeks": {"$gte": 26, "$lte": 156}
        }

    elif filter_type == 'Disaster':
        query = {
            "animal_type": "Dog",
            "breed": {
                "$in": [
                    "Doberman Pinsch", # This is what the Doberman Pinschers are called in the dataset
                    "Doberman Pinscher", # incase it is added under this name in the future
                    "German Shepherd",
                    "Golden Retriever",
                    "Bloodhound",
                    "Rottweiler"
                ]
            },
            "sex_upon_outcome": "Intact Male",
            "age_upon_outcome_in_weeks": {"$gte": 20, "$lte": 300}
        }
    # If filter_type is 'Reset' or not present, the base query is used

    # Read from MongoDB using query
    df = pd.DataFrame.from_records(shelter.read(query))

    # Clean up MongoDB _id field
    if '_id' in df.columns:
        df.drop(columns=['_id'], inplace=True)

    return df.to_dict('records'), [0] # Sends new set of records and sets selected row back to the first one
"""
# Display the breeds of animal based on quantity represented in
# the data table
@app.callback(
    Output('graph-id', "children"),
    [Input('datatable-id', "derived_virtual_data")]
)
def update_graphs(viewData):

    if not viewData: # Should only happen when program first starts
        return [html.Div("Please wait for data to load!")]

    dff = pd.DataFrame(viewData)
    
    # The below is specifically to highlight the top breeds and put the rest into a single category, or else the pie chart becomes bloated
    # Count breeds
    counts = dff['breed'].value_counts()

    # Keep top breeds
    top_n = 10
    top_breeds = counts.head(top_n)

    # Group the rest into "Other". While this loses some specific data, it makes it so the pie chart is more understandable
    other_total = counts.iloc[top_n:].sum() # Puts the number of everything else together
    if other_total > 0:
        top_breeds["Other Breeds"] = other_total

    # Builds a DataFrame for Plotly
    pie_df = pd.DataFrame({
        "Breed": top_breeds.index,
        "Amount": top_breeds.values
    })

    # Builds pie chart
    fig = px.pie(
        pie_df,
        names="Breed",
        values="Amount",
        title="Breeds",
        color_discrete_sequence=px.colors.sequential.Turbo # alternate color
    )

    return [dcc.Graph(figure=fig)]
    
#This callback will highlight a cell on the data table when the user selects it
@app.callback(
    Output('datatable-id', 'style_data_conditional'),
    [Input('datatable-id', 'selected_columns')]
)
def update_styles(selected_columns):
    return [{
        'if': { 'column_id': i },
        'background_color': '#D2F3FF'
    } for i in selected_columns]


# Callback updates geo-location chart
# derived_virtual_data is set of data available from the datatable in the form of 
# a dictionary.
# derived_virtual_selected_rows will be the selected row(s) in the table in the form of
# a list.
# The iloc method allows for a row, column notation to pull data from the datatable
@app.callback(
    Output('map-id', "children"),
    [Input('datatable-id', "derived_virtual_data"),
     Input('datatable-id', "derived_virtual_selected_rows")])
def update_map(viewData, index): # geolocation chart code

    dff = pd.DataFrame.from_dict(viewData)
    
    # Fixes certain errors (error at start-up)
    if not index:
        return no_update

    # List is converted into row index
    if index is None or index[0] >= len(dff):
        row = 0
    else: 
        row = index[0]

    # Getting specific columns that define coordinates
    lat = float(dff.loc[row, "location_lat"])
    lon = float(dff.loc[row, "location_long"])
    
    name = dff.loc[row, "name"]
    breed = dff.loc[row, "breed"]
    
    if name is None or str(name).strip() == "": # Sometimes the animal has no name attached
        name = "Unknown Name"
    return [
    dl.Map(style={'width': '1000px', 'height': '500px'},
       center=[lat, lon], zoom=10, children=[ # Made it so it centers on the actual marker/position
       dl.TileLayer(
            id="base-layer-id",
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", # Using open-source map
            maxZoom=18,
            attribution="© OpenStreetMap contributors" # Appropriate attribution for OpenStreetMap
        ),
       # Marker with tool tip and popup
       dl.Marker(position=[lat,lon],
          children=[
          dl.Tooltip(breed),
          dl.Popup([
            html.P(name) ## Shows animal name when clicking
         ])
      ])
   ])
]


if __name__ == "__main__":
    app.run(debug=True)
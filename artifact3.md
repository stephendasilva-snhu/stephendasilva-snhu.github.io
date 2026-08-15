---
layout: default
title: Artifact 3
---

# Artifact 3: Databases
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%203)

## Enhancement Narrative

For my third artifact, I picked the Rescue Animal Data Dashboard made for CS 340: Client/Server Development. It outputs data from a MongoDB database through a data table and other visualizations. This data is for rescue animals, and their documents contain attributes such as their breed, sex, and location. There are ways to sort through the table based on each attribute and specific filter options for animals most suited for particular tasks. Visualizations include a pie chart of all the breeds in the current set of records (can be altered with the filters) and a map that centers on a marker of the location for a selected animal, based on the latitude and longitude. It uses a basic CRUD Python module to interface with the database, and hard-coded credentials for the purposes of prototyping.

I chose this program to represent my skill in the “Databases” category since this already works with an existing MongoDB database, showing some of my proficiency already, and can be iterated on to make it more user-friendly, as was the original intention. The general goals for the enhancement was to implement another UI integrated with the dashboard to manage the database, so a non-technical user can do so without using another software such as MongoDB Compass or the terminal. This was accomplished by creating an additional set of HTML code underneath the existing dashboard that the user can use to manage the database, being directly integrated with the dashboard by using the person’s selection of an animal for what will be updated or deleted and supporting the ability to add animals or add them through a csv file. I also had to add a new set of callbacks and Python functions to make that functional, and other changes were made in moving the program out of the original Jupyter Notebook environment to be a standalone Python program. Additionally, I created a new UI to connect to the database with input credentials, removing the reliance on hard-coded credentials.

Before discussing the process of developing this, I’ll explain that I did meet the planned course outcomes with this enhancement. I developed more maintainable code that was closer to what was expected for stakeholders in terms of user-friendly features. Also, by moving the program out of Jupyter Notebook and by adding that new interface for database integration, I designed new computing solutions for my given problem while managing the trade-offs. Additionally, I used well-founded techniques and tools to create this database management UI, also creating more robust code with that. Finally, I successfully developed a security mindset by implementing input validation and sanitization for all inputs in the program, with the possibility of also implementing authentication in the future for access to the management interface by making its functions and HTML separate from the main dashboard. Future developments on this prototype can evolve further with these course outcomes as well, but no change is needed in my plans to fulfill these.

The process of doing these enhancements was the most challenging out of my enhancements overall. Firstly, as I was simply moving it out of Jupyter Notebook, there were various changes I needed to make with my new local environment. The most problematic of them was that the map was now non-functional. I had to work with an open-source map and rewrite that part of the program in how it lined up the latitude and longitude with it, but it was successful and I did improve my skills from that. With the main enhancement though, since the UI had to be implemented with HTML, I further developed my proficiency in using HTML beyond what I already did for the original code. This similarly goes for the callbacks, as while before the callbacks were from pre-made code that I was able to leverage, I now had to use my experience with it to make brand new callbacks for each part of the database management interface. The process gave me more experience with Dash, and generally improved my skills in developing web applications, infusing it with Python functionality. I did face challenges in implementing the desired functionality for each part (adding, updating, deleting, and doing a bulk upload through CSV), but did iterative testing to ensure each were implemented successfully. While the actual UI is not very aesthetically appealing, this can be revised later, but the core functionality is intact. Similarly, the code is tested specifically for the original csv from the project and ones based directly on it. While I did implement some features that should work dynamically, others such as the input sanitization are more directly hard coded for the specified fields of the original project, with a basic default being implemented to maintain some compatibility with alternatives. The function to add animals is also coded to specifically be compatible with the original fields. However, the example CSV included provides the template that should be followed. The current enhancement is a functional prototype, offering more user-friendly features with a full new UI integrated with the dashboard for database management.

<h2 style="text-align:center;">Fulfilled Course Outcomes</h2>

<p style="text-align:center;">
The specific fulfillments are described above, but the main course outcomes fulfilled in this enhancement were:
</p>

<p style="text-align:center;">
I. Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science<br>
IV. Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals<br>
V. Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources
</p>

<div style="text-align:center;" markdown="1">
  
## Screenshots from Enhanced Programm
### Main Dashboard (From Original Code)
<img width="1227" height="568" alt="Main Dashboard" src="https://github.com/user-attachments/assets/7f1de56c-4f0c-4d39-9332-7537a9da464b" />

### Filtered Dashboard (From Original Code)
<img width="1216" height="566" alt="Filtered Dashboard" src="https://github.com/user-attachments/assets/834b30b2-8f78-4974-883d-950d01624bfc" />

### Data Visualizations (From Original Code)
<img width="1216" height="539" alt="Data Visualizations" src="https://github.com/user-attachments/assets/a056c764-7cf6-4b22-a58d-16a9aed5cd27" />

### Database Connection (From New Code)
<img width="410" height="199" alt="Database Connection UI" src="https://github.com/user-attachments/assets/ea99f92e-d60b-4679-bdad-028ef5554a40" />

### Database Management UI (From new Code)
<img width="992" height="534" alt="Database Management UI" src="https://github.com/user-attachments/assets/01073908-096d-4c87-9a4f-7bcf5da2b78f" />

</div>


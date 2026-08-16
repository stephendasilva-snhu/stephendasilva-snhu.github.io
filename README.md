# Stephen DaSilva's CS-499 ePortfolio

The intended view for this portfolio is here: https://stephendasilva-snhu.github.io/

## Self-Assessment
[Click here to access self-assessment docx directly](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/blob/main/CS-499%20Narratives%20and%20Assessment/CS%20499%20Self-Assessment.docx)

As I enter the computer science field as a professional, the strengths, skills, and values that I have developed throughout the SNHU computer science program are important to highlight. Some of these will be showcased in this portfolio as enhanced versions of my works, but there are also other works I will mention that are not included yet central to my growth. Professionally, though I have a long road ahead, I desire to become a software engineer. This is a goal shaped from my experiences at SNHU and the variety of fields that I have worked through. Even though I have improved greatly at SNHU, I will also continue to gain experience and do work after the program so I can continue working towards these goals, and the skills developed already are worth reflecting on.

A key skill that the program refined is my abilities in collaborating in a team environment. Though most coursework was done alone, I gained experience with the software development life cycle, Agile, Kanban, and Scrum, such as through being part of a simulated team during CS-250: Software Development Lifecycle. Working in these scenarios, revising existing code, and writing documentation are part of what has prepared me to collaborate in a professional team setting. This is supported in my portfolio through several artifacts, such as my code review, and from sufficient documentation found in my new code files, particularly in my first artifact.

Paired with this, I have also strengthened my ability to communicate with stakeholders. Beyond what is in this portfolio, I have written thorough papers exploring concepts, READMEs, and documentation for programs. Also, I have done oral presentation videos, specifically for game development work in GAM-207: Info Tech and Digital Games. These experiences reinforced effective communication with stakeholders and improved my understanding of how we interact in the SDLC. This is supported by this self-assessment, my code review, and my artifact enhancement narratives all showing different means of communicating my work and experiences to others.

This portfolio specifically highlights work with data structures and algorithms, but they too were also worked with outside those artifacts. During the program, I used pseudocode, flowcharts, and diagrams to give better insight into data flows and code efficiency. That work also connects to testing different algorithms in C++, such as a binary search tree and hash table algorithm, giving perspective on the different use-cases for them in CS-300: DSA: Analysis and Design. Programming and designing solutions to logic problems using different algorithms is a skill I continue to improve at and is represented in the artifacts. This is especially supported by my second artifact, which was iterated on to improve its choice of algorithms and changing its data structure to something more tailored to the project.

Using and understanding well-founded and innovative skills and tools was also done, highlighting my software engineering capabilities. Following the software development life cycle, even within the bounds of assignments, and learning more on industry-standard software designs and processes helped increase the quality of my work. For industry-standard techniques, iterative testing, use of architectural patterns such as MVC, and in-depth requirements analysis helped produce higher quality work and to create accurate production timelines. I also gained experience with databases, such as MongoDB, and used other tools and libraries alongside that to support my work, which was highlighted from my work in CS-465: Full Stack Development I. These tools and techniques allowed me to build reliable and maintainable software. My third artifact, originally made for CS-340: Client/Server Development, was enhanced to further support this with refinement of existing database integration and implementing new means of interacting with the database.

Maintaining a secure mindset and using secure coding practices was also consistent. I would be creating automated tests, error handling, and implementing input validation and sanitization. During iterative testing, finding and resolving bugs and unintended behavior was a frequent necessity. In addition, I’ve had to conduct vulnerability analysis such as checking for dependencies and testing invalid inputs. Implementing input sanitization and encapsulating code to limit harm on the program were some ways of handling this. Also, keeping code well documented and maintainable by people in the future is essential. This was part of many courses but was especially done in CS-320: Software Test, Automation QA. All three artifacts support my secure mindset by both maintaining and further enhancing their security with a focus on validating inputs for my first two artifacts and sanitizing them in the second and third artifacts. These basic skills discussed have all been refined during my time at SNHU and are translatable into a professional setting.

For this portfolio, I have focused on three specific artifacts of code that show my skill in different areas, enhanced with more robust code. In addition to this self-assessment, I also created a code review prior to enhancing the artifacts, showing my proficiency in reviewing code and communicating that. Each code artifact in this portfolio is also paired with a narrative that further describes my process, thinking, and how I fulfilled key learning outcomes. These artifacts, together, highlight the diverse growth I went through in my journey through the SNHU program.

To briefly go over the artifacts, my first artifact is a terminal program to manage different types of support animals and their attributes. It was created for one of my earliest courses, IT-145, and was enhanced to show software engineering skills. It was translated from Java to Python, additionally overhauled to both follow Python’s different practices and refactored to be generally better coded, with more robust and efficient code while preserving the original functionality. My second artifact is a series of services for managing appointments, contacts, and task classes, along with a driver program. This was made for CS-320 and has been enhanced to show skills with data structures and algorithms by rewriting the service classes to use HashMaps instead of basic lists, using HashMap algorithms to create more efficient code, and implementing the driver program to display time spent. Finally, the last artifact will be a web dashboard to display rescue animals from a MongoDB database, created for CS-340. It includes a user-friendly dashboard along with filters and visualizations for animal locations and percentages of animal breeds, out of what’s selected. This was enhanced to show capabilities with databases by adding an additional user-friendly panel to manage the database directly from the web application as an alternative to interacting with MongoDB through other means. These are the artifacts that will be presented directly in the portfolio, but all the skills and course outcomes discussed will be shown in every part of my work.
  
### Fulfilled Course Outcomes from Self-Assessment

I. Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science

II. Design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts

(As mentioned, all course outcomes are fulfilled overall from everything present on the portfolio, this is just specifically for the self-assessment)

## Code Review Video

Click here to view: https://www.youtube.com/watch?v=_A6u6pVaEHs

### Fulfilled Course Outcomes from Code Review

I. Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science

II. Design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts

# Artifact 1: Software Design and Engineering
	
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%201)

## Enhancement Narrative
[Click here to access narrative docx directly](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/blob/main/CS-499%20Narratives%20and%20Assessment/CS%20499%20Artifact%201%20Narrative.docx)

For my first artifact, I picked the Grazioso Salvare Rescue Animal terminal that I made for IT 145: Foundations in Application Development. It was one of my first projects at SNHU, where I implemented multiple functions to interact with lists of entities, and implemented some input validation. Effectively, the application is a command-line program where you interface with lists to add and print details from entities (dogs and monkeys), and you can “reserve” an animal if its status indicates it is in service. I wanted to enhance this for my ePortfolio to show evidence of my skills in software design and engineering by porting it into Python. While the original version did show my ability to fulfill requirements with clear, concise code, there were shortcomings I caught in my code review that could be rectified during the process in moving it to Python. Overall, proficiency in both Java and Python was exhibited in the process of understanding and re-writing code across languages, which was the main enhancement, but I had other changes that also illustrate software development skills.

A specific part of the enhancement that showed my skills was the introduction of more modularized code. Though the original was completely functional, it had a lot of repetitive code and that would only worsen if I were to add additional types of animals as options. Apart from the change in language, my biggest change was restructuring the code to allow for this adaptability. A good example of this is that I changed the main menu, which was originally just a single menu looping in the main function, into multiple functions that I could also use for sub-menus. I set up the options for each menu into their own nested dictionaries, where the option key (number or character) was the key, and the value was another dictionary consisting of the option text and the corresponding function. Another way of reducing repetitive code was condensing functions that were previously made for each type of animal (such as separate methods for intaking a new dog compared to a monkey) into a single function which an argument that would let it know which inputs would be done. I sought to apply this mentality throughout this re-write and believe it shows my abilities well. As already stated, the improvement amounted to a better made program that still does the same or similar functions but is more refined and suited for expansion in the future.

I did meet the course outcomes I originally planned, as the enhancements led to more efficient, modularized code with better documentation that would be more understandable by others. This employed strategies to build a collaborative environment, evaluated computing solutions that successfully managed trade-offs with benefits of different concepts, showed a secure mindset through the use of input validation, and used well-founded techniques and skills that I learned during my time at SNHU. Back when I first created the original artifact, it helped improve my skills in working with classes and entities, and I did early work with input validation. However, I have honed my skills overall more since then, and this new experience of enhancing that artifact has helped push me further. Not only did it test my abilities to make better reusable code, but it also pushed my Python and programming skills further. I became more familiar with proper code documentation and, in particular, docstrings. Also, I made use of type hints in Python, which while not required can be useful in future cases. Additionally, I got better experience with concepts such as format strings when working out how to combine animal-specific functions, and nested dictionaries in multiple instances. Though I could have accomplished the main enhancement, porting the existing program into Python, with less effort, I took the opportunity to refine and show my abilities more. Even though the result remains a very similar, simple command-line program, it was rebuilt into Python with the experience and knowledge I now have, aligning with best practices.
	
## Fulfilled Course Outcomes

I. Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science

III. Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices

IV. Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals

V. Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources

## Screenshots from Enhanced Program

### Intaking Monkey
<img width="245" height="536" alt="Intaking Monkey" src="https://github.com/user-attachments/assets/e5240dfb-2bea-4ae8-9568-b6a39833137d" />

### Printing Animal List
<img width="313" height="251" alt="Printing Animal List" src="https://github.com/user-attachments/assets/04c4f9f2-4644-4f91-a957-5983c2543499" />

### Training Animal
<img width="309" height="488" alt="Training Animal" src="https://github.com/user-attachments/assets/65ac46cc-0236-4847-b38f-9ce8182d0098" />

### Reserving Animal
<img width="473" height="538" alt="Reserving Animal" src="https://github.com/user-attachments/assets/1d9c0cf1-4610-4b60-a606-5d096105fc5f" />

# Artifact 2: Algorithms and Data Structures
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%202)

## Enhancement Narrative
[Click here to access narrative docx directly](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/blob/main/CS-499%20Narratives%20and%20Assessment/CS%20499%20Artifact%202%20Narrative.docx)

For my second artifact, I picked the contact, task, and appointment entities and services made for CS 320: Software Test, Automation QA. It is three pairs of entity classes and services to interface with them, featuring use of input validation and normalization based on predetermined restrictions, such as number of characters or formatting. The entities contain different information based on their purpose, such as the contact needing a full name and phone number, or an appointment needing a date, and they had different restrictions based on that. The original intent was to exhibit skills with JUnit testing, to have full test coverage over each class that showed evidence of the input validation and normalization working. But I chose this artifact for a reason separate from that, as it was easily mendable to show my skills with “Algorithms and Data Structures”. Since the original intent was not concerned with the efficiency of the code, the services would store the entities into separate lists, and the entity’s functions were not made to keep repetitive code low, since it made testing clearer and simpler. But this did not align with best practices. I also kept in mind that the majority of functionality for these services was related to getting a specific entity using an ID, and handling the full list is only something I added in the enhancement itself, so my decisions were made with the original functionality more in mind.

The main changes made as part of the enhancements were integrating HashMaps into each service to store the entities more efficiently, refactoring the entity code to be more concise and professional, and creating a driver program to manually interact with the three services and see the time spent on actions. The use of HashMaps greatly increased the efficiency of actions tied to getting an entity from an ID, since previously it would loop through the entire list until the ID lined up. Also, the driver program effectively showcases that efficiency, giving the time spent in milliseconds, with some actions taking under a millisecond that aren’t reliant on printing information. These enhancements, while on a smaller scale than the other artifacts’ enhancements, clearly show knowledge in how to appropriately use data structures and algorithms to better a program.

The expected course outcomes were met, as all planned enhancements were successfully implemented, all aligning with best practices while maintaining the original functionality of the services. Specifically, the course outcomes were fulfilled through exhibiting knowledge of algorithmic principles to develop a successful computing solution and by implementing this solution in a way that delivers value, since robust well-developed code is being created using the original well-tested but less efficient code as its foundation. Additionally, maintaining the input validation requirements and further iterating on them showed a secure mindset. In the process of enhancing this artifact, I improved at my skills in working with the HashMap data structure and its different functions. Also, I became better equipped at programming in Java in general, after doing a lot of recent coding in C++ or Python and developing the driver program was beneficial in maintaining good fundamentals. I did have some challenges, namely in retaining the original input restrictions while also refactoring the code to be more concise and efficient, but I was able to work through them and now have invalid inputs be rejected more gracefully. Even though this was overall a smaller change in functionality compared to the enhancements for artifacts 1 and 3, it was effective in highlighting my abilities in writing better code and using more efficient data structures and algorithms for the given situation.

## Fulfilled Course Outcomes

The specific fulfillments are described above, but the main course outcomes fulfilled in this enhancement were:

III. Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices

IV. Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals

V. Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources
  
## Screenshots from Driver Program

### Adding Contact
<img width="263" height="320" alt="Adding Contact w/ Time" src="https://github.com/user-attachments/assets/474bfcb3-1bc1-4ec3-8510-b7b934bee748" />

### Getting Contact
<img width="263" height="270" alt="Getting Contact w/ Time" src="https://github.com/user-attachments/assets/ee04e975-bf82-44f3-ab82-07848b57dcef" />

### Deleting Appointment
<img width="317" height="181" alt="Deleting Appointment w/ Time" src="https://github.com/user-attachments/assets/f6b41e1f-4d03-4145-b875-8fc7c4c6e2fe" />

### Invalid Appointment Date, Input Rejected
<img width="354" height="199" alt="Invalid Appointment Date Rejected" src="https://github.com/user-attachments/assets/8faf572b-218e-4359-b910-76d731904958" />

# Artifact 3: Databases
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%203)

## Enhancement Narrative
[Click here to access narrative docx directly](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/blob/main/CS-499%20Narratives%20and%20Assessment/CS%20499%20Artifact%203%20Narrative.docx)

For my third artifact, I picked the Rescue Animal Data Dashboard made for CS 340: Client/Server Development. It outputs data from a MongoDB database through a data table and other visualizations. This data is for rescue animals, and their documents contain attributes such as their breed, sex, and location. There are ways to sort through the table based on each attribute and specific filter options for animals most suited for particular tasks. Visualizations include a pie chart of all the breeds in the current set of records (can be altered with the filters) and a map that centers on a marker of the location for a selected animal, based on the latitude and longitude. It uses a basic CRUD Python module to interface with the database, and hard-coded credentials for the purposes of prototyping.

I chose this program to represent my skill in the “Databases” category since this already works with an existing MongoDB database, showing some of my proficiency already, and can be iterated on to make it more user-friendly, as was the original intention. The general goals for the enhancement were to implement another UI integrated with the dashboard to manage the database, so a non-technical user can do so without using another software such as MongoDB Compass or the terminal. This was accomplished by creating an additional set of HTML code underneath the existing dashboard that the user can use to manage the database, being directly integrated with the dashboard by using the person’s selection of an animal for what will be updated or deleted and supporting the ability to add animals or add them through a csv file. I also had to add a new set of callbacks and Python functions to make that functional, and other changes were made in moving the program out of the original Jupyter Notebook environment to be a standalone Python program. Additionally, I created a new UI to connect to the database with input credentials, removing the reliance on hard-coded credentials.

Before discussing the process of developing this, I’ll explain that I did meet the planned course outcomes with this enhancement. I developed more maintainable code that was closer to what was expected for stakeholders in terms of user-friendly features. Also, by moving the program out of Jupyter Notebook and by adding that new interface for database integration, I designed new computing solutions for my given problem while managing the trade-offs. Additionally, I used well-founded techniques and tools to create this database management UI, also creating more robust code with that. Finally, I successfully developed a security mindset by implementing input validation and sanitization for all inputs in the program. Also, the previous hard-coded credentials were eliminated from the program and replaced with a new UI to input one's own credentials for their database, making the connection process simpler and more secure.

The process of doing these enhancements was the most challenging out of my enhancements overall. Firstly, as I was simply moving it out of Jupyter Notebook, there were various changes I needed to make with my new local environment. The most problematic of them was that the map was now non-functional. I had to work with an open-source map and rewrite that part of the program in how it lined up the latitude and longitude with it, but it was successful and I did improve my skills from that. With the main enhancement though, since the UI had to be implemented with HTML, I further developed my proficiency in using HTML beyond what I already did for the original code. This similarly goes for the callbacks, as though before the callbacks were from pre-made code that I was able to leverage, I now had to use my experience with it to make brand new callbacks for each part of the database management interface. The process gave me more experience with Dash, and generally improved my skills in developing web applications, infusing it with Python functionality. I did face challenges in implementing the desired functionality for each part (adding, updating, deleting, and doing a bulk upload through CSV), but did iterative testing to ensure each were implemented successfully. It was also revised later to implement a more aesthetically appealing UI, making it a more cohesive program. In addition, the code is tested specifically for the original csv from the project and ones based directly on it. While I did implement some features that should work dynamically, others such as the input sanitization are more directly hard coded for the specified fields of the original project, with a basic default being implemented to maintain some compatibility with alternatives. The function to add animals is also coded to specifically be compatible with the original fields. However, the example CSV included provides the template that should be followed. The current enhancement is a functional prototype, offering more user-friendly features with a full new UI integrated with the dashboard for database management.

## Fulfilled Course Outcomes

The specific fulfillments are described above, but the main course outcomes fulfilled in this enhancement were:

I. Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science

IV. Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals

V. Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources
  
## Screenshots from Enhanced Program
### Main Dashboard
<img width="1227" height="568" alt="Main Dashboard" src="https://github.com/user-attachments/assets/7f1de56c-4f0c-4d39-9332-7537a9da464b" />

### Filtered Dashboard
<img width="1216" height="566" alt="Filtered Dashboard" src="https://github.com/user-attachments/assets/834b30b2-8f78-4974-883d-950d01624bfc" />

### Data Visualizations
<img width="1216" height="539" alt="Data Visualizations" src="https://github.com/user-attachments/assets/a056c764-7cf6-4b22-a58d-16a9aed5cd27" />

### Database Connection UI
<img width="410" height="199" alt="Database Connection UI" src="https://github.com/user-attachments/assets/ea99f92e-d60b-4679-bdad-028ef5554a40" />

### Database Management UI
<img width="992" height="534" alt="Database Management UI" src="https://github.com/user-attachments/assets/01073908-096d-4c87-9a4f-7bcf5da2b78f" />

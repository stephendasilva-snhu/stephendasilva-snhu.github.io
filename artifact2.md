---
layout: default
title: Artifact 2
---

<div style="text-align:center;" markdown="1">
  
# Artifact 2: Algorithms and Data Structures
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%202)

## Enhancement Narrative
[Click here to access narrative docx directly](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/blob/main/CS-499%20Narratives%20and%20Assessment/CS%20499%20Artifact%202%20Narrative.docx)

</div>

For my second artifact, I picked the contact, task, and appointment entities and services made for CS 320: Software Test, Automation QA. It is three pairs of entity classes and services to interface with them, featuring use of input validation and normalization based on predetermined restrictions, such as number of characters or formatting. The entities contain different information based on their purpose, such as the contact needing a full name and phone number, or an appointment needing a date, and they had different restrictions based on that. The original intent was to exhibit skills with JUnit testing, to have full test coverage over each class that showed evidence of the input validation and normalization working. But I chose this artifact for a reason separate from that, as it was easily mendable to show my skills with “Algorithms and Data Structures”. Since the original intent was not concerned with the efficiency of the code, the services would store the entities into separate lists, and the entity’s functions were not made to keep repetitive code low, since it made testing clearer and simpler. But this did not align with best practices. I also kept in mind that the majority of functionality for these services was related to getting a specific entity using an ID, and handling the full list is only something I added in the enhancement itself, so my decisions were made with the original functionality more in mind.

The main changes made as part of the enhancements were integrating HashMaps into each service to store the entities more efficiently, refactoring the entity code to be more concise and professional, and creating a driver program to manually interact with the three services and see the time spent on actions. The use of HashMaps greatly increased the efficiency of actions tied to getting an entity from an ID, since previously it would loop through the entire list until the ID lined up. Also, the driver program effectively showcases that efficiency, giving the time spent in milliseconds, with some actions taking under a millisecond that aren’t reliant on printing information. These enhancements, while on a smaller scale than the other artifacts’ enhancements, clearly show knowledge in how to appropriately use data structures and algorithms to better a program.

The expected course outcomes were met, as all planned enhancements were successfully implemented, all aligning with best practices while maintaining the original functionality of the services. Specifically, the course outcomes were fulfilled through exhibiting knowledge of algorithmic principles to develop a successful computing solution and by implementing this solution in a way that delivers value, since robust well-developed code is being created using the original well-tested but less efficient code as its foundation. Additionally, maintaining the input validation requirements and further iterating on them showed a secure mindset. In the process of enhancing this artifact, I improved at my skills in working with the HashMap data structure and its different functions. Also, I became better equipped at programming in Java in general, after doing a lot of recent coding in C++ or Python and developing the driver program was beneficial in maintaining good fundamentals. I did have some challenges, namely in retaining the original input restrictions while also refactoring the code to be more concise and efficient, but I was able to work through them and now have invalid inputs be rejected more gracefully. Even though this was overall a smaller change in functionality compared to the enhancements for artifacts 1 and 3, it was effective in highlighting my abilities in writing better code and using more efficient data structures and algorithms for the given situation.

<div style="text-align:center;" markdown="1">
  
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
</div>

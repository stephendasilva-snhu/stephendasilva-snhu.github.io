# Stephen DaSilva's CS-499 ePortfolio

## A Self-Assessment of Myself and My Work

## Code Review Video
<iframe width="600" height="338" src="https://www.youtube.com/embed/_A6u6pVaEHs" title="CS 499 Code Review" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

## Artifact 1: Software Design and Engineering
[Click here to access the files directly, both new and old](https://github.com/stephendasilva-snhu/stephendasilva-snhu.github.io/tree/main/CS-499%20Artifact%201)

<details>
<Summary>My narrative for the enhancements</Summary>
For my first artifact, I picked the Grazioso Salvare Rescue Animal terminal that I made for IT 145: Foundations in Application Development. It was one of my first projects at SNHU, where I implemented multiple functions to interact with lists of entities, and implemented some input validation. Effectively, the application is a command-line program where you interface with lists to add and print details from entities (dogs and monkeys), and you can “reserve” an animal if its status indicates it is in service. I wanted to enhance this for my ePortfolio to show evidence of my skills in software design and engineering by porting it into Python. While the original version did show my ability to fulfill requirements with clear, concise code, there were shortcomings I caught in my code review that could be rectified during the process in moving it to Python. Overall, proficiency in both Java and Python was exhibited in the process of understanding and re-writing code across languages, which was the main enhancement, but I had other changes that also illustrate software development skills.

	
A specific part of the enhancement that showed my skills was the introduction of more modularized code. Though the original was completely functional, it had a lot of repetitive code and that would only worsen if I were to add additional types of animals as options. Apart from the change in language, my biggest change was restructuring the code to allow for this adaptability. A good example of this is that I changed the main menu, which was originally just a single menu looping in the main function, into multiple functions that I could also use for sub-menus. I set up the options for each menu into their own nested dictionaries, where the option key (number or character) was the key, and the value was another dictionary consisting of the option text and the corresponding function. Another way of reducing repetitive code was condensing functions that were previously made for each type of animal (such as separate methods for intaking a new dog compared to a monkey) into a single function which an argument that would let it know which inputs would be done. I sought to apply this mentality throughout this re-write and believe it shows my abilities well. As already stated, the improvement amounted to a better made program that still does the same or similar functions, but is more refined and suited for expansion in the future.

I did meet the course outcomes I originally planned, as the enhancements led to more efficient, modularized code with better documentation that would be more understandable by others. This employed strategies to build a collaborative environment, evaluated computing solutions that successfully managed trade-offs with benefits of different concepts, and used well-founded techniques and skills that I learned during my time at SNHU. Since the enhancements ended up going as expected, there are no changes to my plans, and I will continue to fulfill any other outcomes and reinforce the completed course outcomes through the remaining 2 artifacts. Back when I first created the original artifact, it helped improve my skills in working with classes and entities, and I did early work with input validation. However, I have honed my skills overall more since then, and this new experience of enhancing that artifact has helped push me further. Not only did it test my abilities to make better reusable code, but it also pushed my Python and programming skills further. I became more familiar with proper code documentation and, in particular, docstrings. Also, I made use of type hints in Python, which while not required can be useful in future cases. Additionally, I got better experience with concepts such as format strings when working out how to combine animal-specific functions, and nested dictionaries in multiple instances. Though I could have accomplished the main enhancement, porting the existing program into Python, with less effort, I took the opportunity to refine and show my abilities more. Even though the result remains a very similar, simple command-line program, it was rebuilt into Python with the experience and knowledge I now have.
</details>

<details>
  <Summary>Screenshots from my enhanced program</Summary>
	<img width="245" height="536" alt="Intaking Monkey" src="https://github.com/user-attachments/assets/e5240dfb-2bea-4ae8-9568-b6a39833137d" />
	<img width="313" height="251" alt="Printing Animal List" src="https://github.com/user-attachments/assets/04c4f9f2-4644-4f91-a957-5983c2543499" />
	<img width="309" height="488" alt="Training Animal" src="https://github.com/user-attachments/assets/65ac46cc-0236-4847-b38f-9ce8182d0098" />
	<img width="473" height="538" alt="Reserving Animal" src="https://github.com/user-attachments/assets/1d9c0cf1-4610-4b60-a606-5d096105fc5f" />
</details>

## Artifact 2: Algorithms and Data Structures

## Artifact 3: Databases

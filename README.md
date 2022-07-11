# Sleep_Habit
firs upload

1	OVERVIEW
The Sleep Habit have a server side and android side. For loading or updating data from server android needs to connect to the server and retrieve data.
1.1	Service Description
The main idea of the app is to improve sleep quality.
1.2	Data Model
All the data relationships are provided throw the MySQL database.
Database tables are users, role, tags and tipsDescription.
Users contains user’s registration info such as username, email and passwords.
Role contains user’s role such as admin or client.
Tags contain tag name and id.
TipsDiscriprion (from now on will be called TD) contains Discription and id.

Between Tags and Users there is many to many relationships, which each user can have more than one tag to specify what kind of suggestion should be loaded for the clint; therefore, there is one to many relations between Tags and TD, thus each tag have several TDs.

1.3	Technology
Technologies used in this app are: 

	Spring Boot framework: this framework covers the server-side application and provide a faster and safer connection through the internet. 
Spring boot plugins used in this project are:  

o	Spring Web: Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

o	Spring Data JPA: Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

o	Spring Security: Highly customizable authentication and access-control framework for Spring applications.

o	Lombok: Project Lombok is a Java library tool that generates code for minimizing boilerplate code. The library replaces boilerplate code with easy-to-use annotations

	Android studio: development environment for Google's Android operating system. Serveries used from android studio:

o	Android SDK 29

o	Material Design: Material is an adaptable system of guidelines, components, and tools that support the best practices of user interface design.

o	Retrofit: retrofit is a plugin for connection throw network.

o	Converter-gson: Converter is a plugin for retrieving data from server through json or vice versa.

 
1.4	Development Tools
Development Tools used in this project:
•	 IDEs that used in this project are android studio and VScode (Visual Studio Code).
•	 Source control used in project is git. 


1.5	Interfaces and services
•	All functionalities through the sever are handled by an APIs: 
o	Login and register
o	Retrieving data from server
o	CRUD for Users, Tags and TD


1.6	Access, Authentication and Authorisation
•	How to access the application
o	Android base application
•	Details how authentication works: each user’s needs to register before benefits from the app.
•	Details how authorisation works: to retriever data clints needs to login to their accounts.
•	No links except login and register are public, therefore any requests to the server will be dined unless the user is logged in.


1.7	Delivery
The application would be accessible through a downloadable link, website or google play store.

1.8	GitHub 
For more details check out the project GitHub link: 
Sleep Habit Server side
Sleep Habit Android side

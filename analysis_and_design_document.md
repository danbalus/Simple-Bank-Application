# Analysis and Design Document

# Requirement analysis

## Assignment Specification
Use JAVA/C# API to design and implement an application for the front desk employees of a bank. The application should have two types of users (a regular user represented by the front desk employee and an administrator user) which have to provide a username and a password in order to use the application.

The regular user can perform the following operations:
- Add/update/view client information (name, identity card number, personal numerical code, address, etc.).
- Create/update/delete/view client account (account information: identification number, type, amount of money, date of creation).
- Transfer money between accounts.
- Process utilities bills.

The administrator user can perform the following operations:
- CRUD on employees’ information.
- Generate reports for a particular period containing the activities performed by an employee.
## Function requirements
The data will be stored in a database. Use the Layers architectural pattern to organize your application.

• All the inputs of the application will be validated against invalid data before submitting the data and saving it in the database.

## Non-functional Requirements
_Availability_: This is a desktop application and it’s always available even if computer is running on low resources.

_Efficiency_: this application uses only a few resources, estimative it’s enough 1 gb  RAM and at leas a CPU with dual core.

_Extensibility_:  the addition of new features will be easy to implement because the Layer Pattern was used and the information is well structured because of it.

_Maintainability_: this application it’s easy to maintain because is well structured and components are easy to access.

_Platform compatibility_: the application runs on every computer that has a internet connection and a Java Runtime Environment installed.

_Portability_: this application is portable on every computer that has a JRE installed.

_Security: Application_ uses a log in mode, system's ability to resist unauthorized usage, only employees can acces the DB server.

_Testability_: Users can provide test cases like CRUD an account or client and then displaying all to see if the change was made.


# Use-Case Model

## Use case 1

    * Use case: CRUD client
    * Level: user-goal level
    * Primary actor: employee
    * Main success scenario:
    - CRUD the client by his unique id in the text box 
    - fill the fields and press the ok button.
    * Extensions:  if the code is wrong or don't exists then can't CRUD and won't be shown any information

## Use case 2

    * Use case: generate reports
    * Level: one of:  user-goal level
    * Primary actor:administrator
    * Main success scenario: 
    - fill the id field with employee's unique id 
    - press the ok button
    * Extensions:  if the code is wrong or don't exists activities from employe and won't be shown any information

## Use case 3

    * Use case:CRUD employee
    * Level: one of: user-goal level
    * Primary actor: administrator
    * Main success scenario:
    - CRUD the employee by his unique id in the text box
    - fill the fields and press the ok button.
    * Extensions: if the code is wrong or employee don't exists then can't CRUD and won't be shown any information
![diagram](adminbank.png)

![diagram](employeebank.png)
# System Architectural Design

## Architectural Pattern Description
Components within the _layered architecture pattern_ are organized into horizontal layers, each layer performing a specific role within the application. Communication between layers is explicit and loosely coupled. 
The layers of isolation concept means that changes made in one layer of the architecture generally don’t impact or affect components in other layers

## Diagrams

Package, component and deployment diagrams

![diagram](pachet.png)



![diagram](deployment.png)



![diagram](component.png)


# UML Sequence Diagrams
Sequence diagram for employee  log in scenario.

![diagram](seq.png)

# Class Design

## Design Patterns Description
Describe briefly the used design patterns.

## UML Class Diagram
Classes are structured in three layers, one is PL that contains the log in windows and some panels for the two accessing modes, administrator and employee. Second layer, BL contains business logic: BLL classes and validators classes. Third layer contains data access(AccountDAO, ClienttDAO,etc) that contains the SQL queries and DBConnect class that make the connection to database.

![diagram](class.png)
# Data Model
![diagram](datam.png)

# System Testing
The system has been tested with specific input data and a comparison of the result obtained with the expected result.

# Bibliography
https://www.safaribooksonline.com/library/view/software-architecture-patterns/9781491971437/ch01.html

https://www.wikipedia.org/

https://www.youtube.com/

https://stackoverflow.com/

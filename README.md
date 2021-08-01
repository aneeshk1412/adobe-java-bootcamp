# Adobe Java Bootcamp

## Object Oriented Programming Paradigm

Every Object can be imagined as a collection of:
* States
* Methods

To create objects, blueprints are required.
C++ and Java use **classes** while Javascript uses **functions**.


## SOLID Design Principles

S -> Single Responsibility
* Each method is responsible for a single task.
* How is a single task defined? Unclear borders.
* Any subpart that can be re-usable can be defined as a single task.

O -> Open Close Principle
* One a method is created, it is:
	* Closed for change (preserves backward compatibility)
	* Open for extension (allows new abilities)

L -> Liskov Substitution Principle \[Generalization and Specialization\]

I -> Interface Segregation
* Many Client-specific Interfaces are better than one General Purpose Interface
	* Why? Because, if the application is complicated, the general purpose code might also become too complicated

D -> Dependency Injection / Inversion

PS: Missing Zen of Python :(


## Java

Java is a Platform and a set of APIs to execute Bytecode.
Different Programming Languages can implement Java:
* Kotlin
* Groovy
* Java

Java Bytecodes are not self-contained. They need an interpreter to run.


## Class Types based on Functionality in a Project Structure

1. Entity Class / Model Class / Domain Class / Document Class
	* Represent Business Data -> Persistent
	* These are mostly directly mapped to an entity as defined in an RDBMS

2. Data Access Object Classes (DAO)
	* These implement CRUD Operations \[Create, READ, UPDATE, DELETE\]
	* Data Acsess Objects define an interface
	* One can implement Data Access from different persistent data storages
	* Thus, these are fine grained operations

3. Service

4. Data Transfer Objects Classes (DTO)

5. Utility  Classes

6. UI Classes

7. Exception Classes


## Spring Boot 

Metadata Methods:
* Annotations
* XML/YML

Metadata keeps dependency tracking of all the beans in the Spring Container.
Wiring (Dependency Graph) between beans (Objects) is managed by the Spring Container.
So, we can pull an object easily.
Spring Container does an inversion of control. (Injects the Dependency into the Object that needs it).
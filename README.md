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
	* These implement CRUD Operations \[CREATE, READ, UPDATE, DELETE\]
	* Also possible implementations may have \[INSERT, DELETE, UPDATE, SELECT (wit or without condition)\], like in SQL
	* Data Acsess Objects define an interface
	* One can implement Data Access from different persistent data storages
	* Thus, these are fine grained operations

3. Service Classes

4. Data Transfer Objects Classes (DTO)

5. Utility  Classes

6. UI Classes

7. Exception Classes

Each such category of classes is logically grouped in a different package.
E.g.: "com.adobe.prj"."classtype"


## Object Oriented Programming Rules

### Inheritence in Java

* Utilizes the ```extends``` keyword.
* Java does not support multiple inheritance (good job)
* A superclass reference can dynamically bind to a subclass object, and call the subclass methods. The type of the reference is determined at compile time.

### Overriding Rules

* since ```private``` is not visible, it cannot be overriden.
* overriding cannot decrease visibility, i.e. cannot override ```public``` function to ```private```
* Visibility order : ```private``` -> ```default``` -> ```protected``` -> ```public```
* Method name and Arguments should be same, return type can be same or a subclass.
* Variables and static methods are not overriden, but shadowed.


## Types of Comments in Java

1. Developer Comments
	* Single Line ```\\```
	* Multi Line ```\*    *\```
2. Documentation Comments  ```\** *\```
	* They support annotations with highlighting and stuff which makes a good documentation (similar to markdown)
	* Documentation comments can be exported to HTML


## Commenting Style to follow

* **Variables and Methods** : camelCase, first letter small
* **Classes and Interfaces** : CamelCase, first letter capital
* **Constants** (keyword ```final```) : SNAKE_CASE, all capital
* **XML / YML / HTML** : spine-case


## Abstract Classes

Abstract Classes are used to define abstract entities. 
These are entities which are not tangible but are an abstraction over multiple entities.
E.g., Product is an Abstract Entity, TV, Laptop, Smartphone, etc. are derived entities from it.

Such classes are marked ```abstract```.
* If a class is marked ```abstract```, then all the ```abstract``` methods in the class have to be implemented by the class that is derived from it.
* If a class has even one ```abstract``` method, then the class has to be declared ```abstract```.
* An ```abstract``` class may or may not have ```abstract``` methods.


## Interfaces

(Realization Relationship)

An Interface is a design contract. It describes certain things that a particular implementation of that interface will do.

It consists of only method signatures and constants (```static``` and ```final```)

Why use interfaces?
1. Design
2. Implementation
3. Testing
4. Integration
5. Loose Coupling

A class can implement multiple interfaces. Keyword is ```implements```.
If a class does not implement all the methods in the interface, it has to be abstract.

An interface:
* declares only method headers and public constants.
* cannot be instantiated.
* can be implemented by a class.
* cannot extend a class.
* can extend several other interfaces.

```java
interface Swim { void swim(); }

interface Dance { void dance(); }

interface Fight { void fight(); }

class Actor implements Dance { 
	public void dance() { /* logic */ } 
}

class Hero extends Actor implements Swim, Fight { 
	public void fight() { /* logic */ } 
	public void swim() { /* logic */ } 
}
```

Anonymous Class

![TODO]


## Data Structures in Java


## Common Higher Order Functions in Java


## Exception Handling in Java

**Exception** : Abnormality in a code or in its execution.
Types of Exceptions:
* Compile Time Exceptions (Checked Exceptions)
	* Compiler forces to handle using try-catch
	* Happens due to reasons outside JRE
* Run Time Exceptions (Unchecked Exceptions)
	* Compiler doesn't force to handle these
	* Happens due to reasons within JRE
* Error (Something to not recover from)
	* Logical
	* Compilation
	* Runtime

## Spring Boot 

Metadata Methods:
* Annotations
* XML/YML

Metadata keeps dependency tracking of all the beans in the Spring Container.
Wiring (Dependency Graph) between beans (Objects) is managed by the Spring Container.
So, we can pull an object easily.
Spring Container does an inversion of control. (Injects the Dependency into the Object that needs it).
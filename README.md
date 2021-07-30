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

D -> Dependency Injection

PS: Missing Zen of Python :(



## Spring Boot 

Metadata Methods:
* Annotations
* XML/YML

Metadata keeps dependency tracking of all the beans in the Spring Container.
Wiring (Dependency Graph) between beans (Objects) is managed by the Spring Container.
So, we can pull an object easily.
Spring Container does an inversion of control. (Injects the Dependency into the Object that needs it).
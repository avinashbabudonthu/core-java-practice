# Core Java Notes
## Basics
* JDK: JRE + Development Kit (tools like compilers(javac) and debuggers (JDB))
* JRE - `Java Runtime Environment`: JVM + Library classes
* Javac: Java Compiler. Generates byte code by converting .java file to .class file
* JVM
	* Virtual machine for Java. Generates machine level language (native language) by converting .class(byte code) to machine level language
	* Software module that provides same execution environment for all java applications and takes care of translation to the underlying layers with regrads to execution instructions and resource management

## Types of Naming Conventions 
* Camel case: If word has more than one word then first letter in first word is small, first letter of sub-sequent words are capital
```
groupId
```
* Spinal case: Each sub word in actual word seperated by hyphon(-)
```
group-id
```
* Upper case: If word has more than one word then first letter in first word is capital, first letter of sub-sequent words are capital 
```
GroupId
```
* All caps: All letters are upper case
```
GROUPID
```

## Naming conventions used in Java
* Upper case
	* Class names
	* Interface names
	* Enum names
* Camel case
	* Variable names
	* Object reference names
	* Method names
	* Arguments
	* Parameters
* All caps
	* Enum values
	* Constants
* All small seperated with dot
	* package names
	
## OOPS concepts
* Encapsulation
* Inheritance
* Polymorphism
### Polymorphism
* process of defining multiple functionalities with the same name with in the same class or sub class
* Types
	* Static polymorphism
	* Dynamic polymorphism
* Static Polymorphism
	* Overloading
* Dynamic Polymorphism
	* Overriding
	
## Access specifiers
* public: accessible every where
* private: accessible with in the class
* protected: public with in the same package. Accessible to sub class via inheritance outside the package
* default: accessible with in the same package

## Access modifiers
### Class modifiers
* abstract
	* Declared on class, method
	* Declared on class - Object cannot be created
	* Declared on method - to write method without implementation
* final
	* Declared on class, method, variable
	* Declared on class - restricts a class from being inherited
	* Declared on method - cannot override method
	* Declared on values - cannot be reassigned
* strictfp
	* it is related to the checking of floating point values irrespective of OS
* static: 
	* Declared on class, method, variable
	* Declared on method, variable - no object creation required to access
	* non static members can access static members
	* static members cannot access non static members
* transient
	* Declared on variable
	* it is not serialized
* volatile
	* the values are liable for change. More in multi threading

## Class
### Definitions
* Fully implemented Structure
* User defined data type
* Blue print for creating an object
* Prototype for creating an object
* Definition
	* Fully implemented user defined data-structure which acts as a blue print for creating an object
### Declare class
* Allowed access specifiers for class
	* public
	* nothing means default
```
public class Student{
	private int id;
	private String name;
	private double grade;
}
```
```
class Employee{
	private long id;
	private String name;
	private Date joiningDate;
}
```
### Final class
* Class with `final` access modifier
```
public final class Student{

}
```

## Object
* `Instance`: Any dynamic memory allocation
* `Object`: instance of a class
* Create object using `new` keyword
* `new`
	* Loads the class to JVM
	* Executes static initializers
	* Initialize static fields declared in class (remember static final fields will be initialized at compile time)
	* Allocates memory for non static members of the class
	* Loads non static members of the class. Initializes non static members of the class
	* Executes constructor
* Create object
```
Student studentReference = new Student();
```
* In the above declaration
	* `new Student()` : object
	* `studentReference`: reference variable
	* `Student`: reference type

## Constructor
* Functionality which gets executed automatically by jvm at the time of creating an object
* No return type
* Same name as class
### Zero argument constructor
* Default constructor
* Zero argument constructor provided by java compiler at the time of compilation if class does not define any constructor
* Class with zero argument `public` constructor
```
public class Student{
	
	public Student(){
		// logic
	}
}
```
* Class with zero argument `private` constructor
	* Cannot create object out side of class 
```
public class Student{
	
	private Student(){
		// logic
	}
}
```
### Argumented constructor
* Class with more than one arguments in constructor
```
public class Student{

	private String name;
	private String course;
	
	public Student(){
		// logic
	}
	
	public Student(String studentName){
		this.name = studentName;
	}
	
	public Student(String studentName, String studentCourse){
		this.name = studentName;
		this.course = studentCourse;
	}

}
```

## Variables
### Instance variables
* Variables declared inside class
* non static members of class
* Not declared as static
```
public class Student{
	
	// instance variables
	private String name;
	private String course;
	
}
```
### Static variables
* static members of class
* Variables declared inside class with `static` access modifier
* Also called class variables
```
public class Student{
	private static int MIN_AGE = 5;
}
```

## Methods
* Method will have
	* Access specifier
	* Return type
	* Method name
	* Arguments
* Declared inside class
```
public class Student{
	
	public String getName(String name){
		return name;
	}
 
}
```

## Nested class
* Static nested classes
* non-static nested classes (or) inner classes
### Inner classes
* Local Inner classes (Local classes)
	* classes declared with in a method
	* classes declared with in a block
* Anonymous inner classes
	* classes declared with in a method without a name.
	* we can declare static final variables in anonymous inner classes.
	* we cannot declare static variables/methods in anonymous inner classes.

### Abstract class
* Class with `abstract` access modifier
* Cannot create object of class
* class can be declared as abstract though class does not have abstract method (method without implementation)
* If class have abstract method it must be declared abstract
```
public abstract class Person{
	public String getName(){
		return "Jack";
	}
}
```
```
public abstract class Person{
	
	public abstract String getDesignation();
	
	public abstract double getGrade();
	
}
```
* class extends abstract class must implement all abstract methods else it also must be declared abstract
	* Don't declare `abstract` access modifier to method while writing implementation
```
public class Student extends Person{
	
	public String getDesignation(){
		return null;
	}
	
	public double getGrade(){
		return 3.45;
	}
}
```

## Interface
### Definition
* fully unimplemented structure

## Type Casting
* process of converting the value of one data type to its equivalent value of another data type
* Types of type casting
	* Implicit type casting
	* Explicit type casting
* Implicit type casting
	* if jvm do the type casting automatically
* Explicit type casting
	* if jvm do the type casting with our specification
	
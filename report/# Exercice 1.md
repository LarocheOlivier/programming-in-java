# Lab01 - Olivier Laroche



## Exercice 1.1 
Encapsulation is a concept in object-oriented programming (OOP) that involves bundling data and methods that work on that data within one unit, such as a class or object.
An object is encapsulate whe all this attributs are private 

## Exercice 1.2

The setter method is for set a private attribut, that we allow to modify this method after that.
Setter will define the variable private with "this"

The getter method is for return after the setter the variable. 
The both methods are very usefull to control the access of the data 

## Exercice 1.3 

In Java, "super" and "this" are keywords used to refer to members of a class, such as variables and methods, and to resolve ambiguities when two members have the same name. Here's a more detailed explanation of each of these keywords:

"This":

Reference to the current instance: The keyword "this" is used to refer to the current instance of the class in which it is used. It is commonly used to distinguish class members from parameters or local variables with the same name.

"Super":

Reference to the parent class: The keyword "super" is used to refer to members (variables or methods) of the parent class of an inherited class. It is primarily used in the context of inheritance.

## Exercice 1.4 

"Inheritance":

In Java, inheritance is a mechanism of object-oriented programming (OOP) that allows a class (called a "subclass" or "child class") to inherit the properties and behaviors of another class (called a "superclass" or "parent class"). This means that the subclass can use the fields (variables) and methods of the superclass and can also add its own fields and methods or override the behavior of inherited methods.
```java

class Animal {
    String name;
    
    public void eat() {
        System.out.println(name + " is eating food.");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking.");
    }
}

```
## Exercice 1.5 

"Polymorphism"

Polymorphism is a concept in object-oriented programming that allows objects from different classes to be treated interchangeably using a common interface, thereby facilitating code reusability and flexibility in handling objects of various types.

**There are three main forms of polymorphism: compile-time polymorphism (also known as method overloading), runtime polymorphism (also known as method overriding), and parametric polymorphism (also known as generics)** 

"Method Overloading" 

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}
```

"Method Overriding" 

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

"Generics" 

Parametric polymorphism allows you to write code that can work with different data types without knowing the specific types at compile time.

```java
class Box<T> {
    private T item;
    
    public T getItem() {
        return item;
    }
    
    public void setItem(T item) {
        this.item = item;
    }
}
```

## Exercice 1.6

Inheritance defines the hierarchical relationship between classes, where subclasses inherit attributes and behaviors from superclasses.
Subtype polymorphism allows you to write code that operates on the superclass but can work with objects of subclasses without modification.
Subtype polymorphism is achieved through method overriding, where a subclass provides its own implementation of a method defined in its superclass.


Exemple : 

```java
class Shape {
    double calculateArea() {
        return 0.0;
    }
}

class Circle extends Shape {
    double radius;

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    @Override
    double calculateArea() {
        return width * height;
    }
}
```

### Test lst01_01

```java
package agh.ii.prinjava.lab01.lst01_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloEncapsulationTest {
    private HelloEncapsulation helloEncapsulation;

    @BeforeEach
    public void setUp() {
        // Create a new HelloEncapsulation object before each test
        helloEncapsulation = new HelloEncapsulation(42); // Initialize with a value
    }

    @Test
    public void testGetPropVal() {
        assertEquals(42, helloEncapsulation.getPropVal());
    }

    @Test
    public void testSetPropVal() {
        helloEncapsulation.setPropVal(123);
        assertEquals(123, helloEncapsulation.getPropVal());
    }

    @Test
    public void testIsEncapsulated() {
        assertTrue(helloEncapsulation.isEncapsulated());
    }
}
```



### Test lst01_03 

```java
package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area() {
        Circle C = new Circle(3);
        assertEquals(3*3*Math.PI,C.area(),0.001);
    }

    @Test
    void perimeter() {
        Circle C = new Circle(3);
        assertEquals(2*Math.PI*3,C.perimeter());
    }
}


class RectangleTest {

    @Test
    void area() {
        Rectangle R = new Rectangle(3,2);
        assertEquals(3*2,R.area());
    }

    @Test
    void perimeter() {
        Rectangle R = new Rectangle(3,2);
        assertEquals((3+2)*2,R.perimeter());
    }
}
s
```


## Exercice 2


### Static Variable (Field/Class Member):

A static variable, also known as a class member or field, belongs to the class itself rather than to a specific instance of the class.
It is shared among all instances of the class, meaning that if one instance modifies the static variable, the change is reflected in all other instances.
Static variables are declared using the static keyword and are typically used for values or data that are common to all objects of the class.

### Static Constant:

A static constant is a static variable that holds a value that should not be changed during the execution of the program. In Java, static constants are often declared with the final modifier to indicate that their values are constant and cannot be modified.
These constants are typically used for values that are constant across all instances of a class or have some global significance within the program.

### Static Method:

A static method is a method that belongs to the class rather than to a specific instance of the class.
Static methods are declared with the static keyword and can be called on the class itself, rather than on an instance of the class.
They are often used for utility functions that don't require access to instance-specific data or behavior.

### Why Static Constants Often Have Public Visibility:

Static constants are often declared with public visibility because they are meant to be accessible from outside the class. Public visibility allows other classes and code modules to access these constants easily without having to create an instance of the class. 

```java extract of lst01_04

static void staticMethod(HelloStatic hs) {
        // (1) Non-static field 'instanceVar' cannot be referenced from a static context
        // System.out.println("instanceVar = " + instanceVar);

        // Non-static method 'instanceMethod2()' cannot be referenced from a static context
        // instanceMethod2();

        // But since 'hs' is the method parameter, the following is possible
        System.out.println("hs.instanceVar = " + hs.instanceVar);
        hs.instanceMethod2();
    }

```

## Exercice 3.1

The initialisation process start to an encapsulation of the variable then, we will overload the variable, and init a default value 

## Exercice 3.2

B1 -> D1 -> D9 
B2 -> private 
B3 -> D4 
   -> D6
   -> D7 
B4 -> D8


## Exercice 3.4s

The Singleton pattern is a design pattern that restricts the instantiation of a class to only one instance and provides a global point of access to that instance. It is useful in various scenarios where you want to ensure a single point of control or coordination. Here are two common applications of the Singleton pattern:

### Database Connection Pooling:
In a multi-threaded environment, managing database connections efficiently is crucial to avoid performance bottlenecks and resource wastage. The Singleton pattern can be used to create a database connection pool with a single, shared instance. This ensures that all parts of the application use the same pool of database connections, reducing overhead and improving performance. The Singleton instance can manage the creation, allocation, and release of connections, making it a central point for efficient database access.

### Logging and Tracing:
Singleton is often used in logging and tracing systems. A single logger instance can be responsible for handling and routing log messages from various parts of an application to different outputs (e.g., console, files, databases) or for performing other actions like error handling and notifications. This ensures that log messages are centralized and managed consistently throughout the application, making it easier to maintain and analyze logs.



# Strategy for Defining Immutable Objects:
## To define immutable objects in Java:

Make the class final.
Make fields private and final.
Provide no setter methods.
Ensure deep immutability.
Avoid sharing mutable objects.
## Comparison of Immutable Object and Immutable Class:
Immutable Object: An instance that cannot be modified.
Immutable Class: A class that produces immutable objects.
## Advantages of Immutable Objects:
Thread safety.
Simplified maintenance.
Caching.
Predictable behavior.
Safe for use as keys.
## Uses of Java Records:
Data Transfer Objects (DTOs)

Representing Immutable Data.


# Exercice 4.5 

## HelloImutable 

```java

package agh.ii.prinjava.lab01.lst01_09;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloImmutableTest {

    @Test
    public void testGetI1() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals(42, immutableObj.getI1());
    }

    @Test
    public void testGetS1() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals("Test", immutableObj.getS1());
    }

    @Test
    public void testToString() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals("HelloImmutable{i1=42, s1='Test'}", immutableObj.toString());
    }

    @Test
    public void testEquals() {
        HelloImmutable obj1 = new HelloImmutable(42, "Test");
        HelloImmutable obj2 = new HelloImmutable(42, "Test");
        assertTrue(obj1.equals(obj2));
    }

    @Test
    public void testHashCode() {
        HelloImmutable obj1 = new HelloImmutable(42, "Test");
        HelloImmutable obj2 = new HelloImmutable(42, "Test");
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testStaticMethod() {
        assertDoesNotThrow(() -> HelloImmutable.sm1());
    }
}
```


## HelloJavaRecord

```java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloJavaRecordTest {

    @Test
    public void testRecordConstruction() {
        HelloJavaRecord record = new HelloJavaRecord(42, "Test");
        assertEquals(42, record.i1());
        assertEquals("Test", record.s1());
    }

    @Test
    public void testRecordToString() {
        HelloJavaRecord record = new HelloJavaRecord(42, "Test");
        assertEquals("HelloJavaRecord[i1=42, s1=Test]", record.toString());
    }

    @Test
    public void testRecordEquals() {
        HelloJavaRecord record1 = new HelloJavaRecord(42, "Test");
        HelloJavaRecord record2 = new HelloJavaRecord(42, "Test");
        assertEquals(record1, record2);
    }

    @Test
    public void testStaticMethod() {
        assertDoesNotThrow(() -> HelloJavaRecord.sm1());
    }
}

```


## Exercice 5


- == compares values for primitive types and memory addresses (references) for objects.

- equals compares the content of objects when overridden properly (by default, it behaves like == for reference types, comparing memory addresses). It's used to provide meaningful comparisons for objects.


The formula o1.equals(o2) => hashCode(o1) == hashCode(o2) expresses an important principle in Java known as the "equals-hashCode contract." This contract ensures that when two objects are considered equal (according to the equals method), their hash codes must be equal as well.

## hashCode Method:

### Consistency:
The hashCode method should consistently return the same value for an object as long as its relevant state does not change.

### Equal Objects: 
If two objects are equal according to the equals method, their hashCode values must be equal.

## equals Method:
Reflexivity: An object should be equal to itself (x.equals(x) should return true).

### Symmetry: 
If x.equals(y) returns true, then y.equals(x) should also return true.

### Transitivity: 
If x.equals(y) and y.equals(z) both return true, then x.equals(z) should return true.

### Consistency: 
Repeated calls to x.equals(y) should consistently return the same result if neither x nor y is modified.

### Comparison with Null: 
x.equals(null) should return false for any non-null reference x.

### Type Check: 
equals should return false when comparing objects of different types.
# Lab02 - Olivier Laroche


### Constants are used in programming to represent fixed, unchanging values. Here are some benefits of using constants in your code:

1. Readability: Constants make your code more readable and self-explanatory. Instead of using "magic numbers" or hardcoded values, you use descriptive names for constants. This improves the code's clarity and helps other developers understand the purpose of these values.

2. Maintainability: If you need to change a value that is used throughout your code, you only need to update it in one place (the constant definition). This reduces the risk of introducing bugs during maintenance.

3. Type Safety: Constants are usually strongly typed, which means the compiler can catch type-related errors early. This prevents unintentional type conversions and ensures that the constants are used correctly.

4. Debugging: Debugging becomes easier when you use constants. You can print or log the constant's value to track the flow of your program or check whether the expected value is being used.

5. Avoiding Duplication: Constants prevent the duplication of literal values. Instead of using the same value multiple times in your code, you define it once as a constant, reducing redundancy.

6. Improving Code Maintenance: Constants help document your code by providing meaningful names for values. This documentation can assist future developers who work on your codebase.

7. Enforcing Constraints: Constants can be used to enforce constraints or limits in your code. For example, you can define a constant to represent the maximum allowed number of items in a list.

### Now, let's address the meaning of the keyword "final" when used in different contexts:

1. Local Variables: When a local variable is declared as "final," it means that its value cannot be changed once it is assigned. This makes the variable effectively constant within the scope where it's defined.

2. Instance Variables: When an instance variable (also known as a field) is declared as "final," it means that each instance of the class will have a final value for that variable. This value can only be set during object creation or within a constructor.

3. Static Constants: When a static variable (class variable) is declared as "final," it means that it is a constant that is shared among all instances of the class. It can be initialized at the time of declaration or within a static initializer block.

4. Methods: When a method is declared as "final," it means that it cannot be overridden by subclasses. Subclasses can still inherit the method but cannot provide their own implementation.

5. Classes: When a class is declared as "final," it means that it cannot be extended (subclassed). No other class can inherit from it.

### If a class contains only private data fields and no setter methods, is the class immutable?

Not necessarily. While having private data fields and no setter methods is a step towards immutability, the class is only considered immutable if its state (the values of its fields) cannot be changed after object creation. You need to ensure that no public methods or other mechanisms allow modification of the private data fields.

### #If all the data fields in a class are private and of primitive types, and the class does not contain any setter methods, is the class immutable?

Yes, in this case, the class is likely immutable, provided there are no public methods or other means to modify its private fields. Primitive types themselves are immutable, and if they are not exposed or modified externally, the class can be considered immutable.


### Explain why the following class is not immutable:

```java
public class C {
   private int[] values;

   public int[] getValues() {
      return values;
   }
}
```

This class is not immutable because it has a public getter method getValues() that returns a reference to the internal array values. Since the array reference can be obtained from outside the class, external code can modify the contents of the array, effectively changing the class's state. To make the class immutable, you should return a copy of the array in the getter method or use an immutable data structure.

Regarding refactoring to a one file-one class structure, you would typically place each class in its own separate .java file with a filename matching the class name. This is a common convention in Java, but the decision to refactor depends on your project's organization and coding standards.

```java
public class C {
   private int[] values;

   public int[] getValues() {
      return values;
   }

   public void setValues(int[] values) {
      this.values = values;
   }
}
```
# Enumeration classes (enums)



Singleton Pattern Implementation:

The code defines a single instance of the EnumBasedSingleton enum called INSTANCE. This single instance represents the singleton object. In Java, enums ensure that there is only one instance for each enum constant, making it a natural choice for implementing the Singleton pattern.

State and Methods:

The EnumBasedSingleton enum has an instance variable int value and two methods:

getValue(): Returns the current value of the value field.
setValue(int value): Sets the value of the value field.

Thread Safety:

The implementation is inherently thread-safe. Here's why:

Enum instances in Java are created once during class loading, and there is no way to create additional instances of the enum. This ensures that only one instance of EnumBasedSingleton (i.e., INSTANCE) exists in the JVM, making it thread-safe by design.

The value field, while not explicitly synchronized, is accessed through the public methods getValue() and setValue(int value). Since there is only one instance of the enum, and these methods do not expose the reference to the INSTANCE, concurrent access to the value field is synchronized implicitly. In other words, only one thread can access these methods at a time, ensuring thread safety.

Overall Assessment:
This implementation is correct, and it is thread-safe. It effectively leverages the features of Java enums to create a singleton instance without the need for complex synchronization mechanisms.


4. Refactor 

```java
// EnumBasedSingleton.java
public enum EnumBasedSingleton {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

```

# Nested classes 


In Java, there are four main types of nested classes: inner classes, static nested classes, local classes, and anonymous classes. Let's discuss the main differences between these types and then answer your specific questions:

## Inner Classes (Non-static Nested Classes):

Inner classes are defined within another class (outer class).
They have access to the outer class's members, including private members.
An instance of an inner class can only exist within an instance of the outer class. Therefore, they are tightly bound to the outer class and cannot be used independently.
Inner classes can have all access modifiers (public, protected, private, package-private) and can also be declared as static or non-static (instance-specific).

## Static Nested Classes:

Static nested classes are defined within another class but marked as static.
They do not have access to the outer class's instance members (non-static members), only to its static members.
They can be used independently without creating an instance of the outer class.
Static nested classes can have all access modifiers (public, protected, private, package-private).

## Local Classes:

Local classes are defined within a method or a block of code (such as a loop or an if statement).
They have access to the local variables of the enclosing method or block but must be final or effectively final if they access them.
They cannot have access modifiers like public, protected, or private.
Local classes are only accessible within the block in which they are defined.

## Anonymous Classes:

Anonymous classes are defined without a name directly at the point of use.
They are often used for implementing interfaces or extending classes in a concise way.
They cannot have explicit constructors.
They are inherently local and cannot have access modifiers.
Now, let's answer your specific questions:

### Can an inner class be used in a class other than the class in which it nests?

No, an inner class is tightly bound to the class in which it nests. You cannot create an instance of an inner class without first creating an instance of the outer class. Inner classes are used within the context of the outer class and typically access the outer class's members.

### Can the modifiers public, protected, private, and static be used for inner classes?

Yes, inner classes can have the following modifiers:

public: Inner classes can be marked as public to allow access from any class.
protected: Inner classes can be marked as protected to allow access from subclasses.
private: Inner classes can be marked as private to restrict access only to the outer class.
static: Inner classes can be marked as static to make them static nested classes, which can be used independently of the outer class. However, static nested classes do not have access to non-static members of the outer class.

# Exercice 4 : 

## Abstract Classes:

An abstract class can have instance variables (fields).
It can have constructors, including parameterized constructors.
Abstract classes can have both abstract (unimplemented) and concrete (implemented) methods.
A class can extend only one abstract class.

## Interfaces:

Interfaces can only declare constants (public static final fields) and method signatures (public abstract methods).
Interfaces do not have constructors.
All methods in an interface are implicitly public and abstract (no need to use the public and abstract modifiers).
A class can implement multiple interfaces.

```java

"""Abstract Methods
These are methods declared in the interface without a method body (no implementation). Implementing classes are required to provide concrete implementations for these methods.
"""

public interface MyInterface {
    void abstractMethod();
}


"""Default Methods
Introduced in Java 8, default methods are methods with a default implementation in the interface itself. They provide a default behavior that can be overridden by implementing classes.
"""
public interface MyInterface {
    void abstractMethod();

    default void defaultMethod() {
        // Default implementation
    }
}

"""Static Methods
Static methods can also be defined in Java interfaces. They are invoked using the interface name and cannot be overridden in implementing classes.
"""
public interface MyInterface {
    static void staticMethod() {
        // Static method implementation
    }
}
"""Constants (Static Final Fields)
Interfaces can have constant fields, which are implicitly public, static, and final. These fields must be assigned a value when declared and can be accessed using the interface name.
"""
public interface MyInterface {
    int MY_CONSTANT = 42;
}

```

## 4.4/4.5 : 

```java

abstract class E { abstract void m1(); }


""""""

interface D { void m1(); }

```

## 4.6 

```java
interface A {}
class C {}
class D extends C {}
class B extends D implements A {}

public class Main {
   public static void main(String[] args) {
      B b = new B();
      if (b instanceof A)
         System.out.println("b is an instance of A");
      if (b instanceof C)
         System.out.println("b is an instance of C");
   }
} 
```
- interface A {}: You define an empty interface A.
- class C {}: You define an empty class C.
- class D extends C {}: You define a class D that extends class C. So, D is a subclass of C.
- class B extends D implements A {}: You define a class B that extends class D and implements interface A. So, B is a subclass of D and also implements the A interface.


Now, in the main method:

- B b = new B();: You create an instance of class B.
- if (b instanceof A): You check if the instance b is an instance of class A or any of its subtypes. Since B implements A, this condition is true, and it prints "b is an instance of A".
- if (b instanceof C): You check if the instance b is an instance of class C or any of its subtypes. B is not directly related to C, but because D is a subclass of C, and B is a subclass of D, this condition is also true, and it prints "b is an instance of C".

## Output 

- b is an instance of A
- b is an instance of C



# Exercice 5 : 

## Lambda Expressions:

Lambda expressions allow you to express instances of single-method interfaces (functional interfaces) in a concise and more readable way.
They provide a way to define a block of code that can be passed around as an object.
Lambda expressions enable the use of functional programming concepts in Java, making it easier to work with functions as first-class citizens.

## Functional Interfaces:

Functional interfaces are interfaces that contain exactly one abstract method. They can have multiple default or static methods.
Functional interfaces are also known as SAM (Single Abstract Method) interfaces.
Java provides a set of predefined functional interfaces in the java.util.function package, such as Predicate, Consumer, Function, etc., to represent common function types.
You can also create your own custom functional interfaces.


```java 

@FunctionalInterface
interface VoidToIntFunction {
    int apply();
}
VoidToIntFunction anonymous = new VoidToIntFunction() {
    @Override
    public int apply() {
        // Your implementation here
        return 42; // Example return value
    }
};
VoidToIntFunction lambda = () -> {
    // Your implementation here
    return 42; // Example return value
};
@FunctionalInterface
interface IntToVoidFunction {
    void apply(int value);
}
IntToVoidFunction anonymous = new IntToVoidFunction() {
    @Override
    public void apply(int value) {
        // Your implementation here
        System.out.println("Value is: " + value); // Example action
    }
};
IntToVoidFunction lambda = (value) -> {
    // Your implementation here
    System.out.println("Value is: " + value); // Example action
};
@FunctionalInterface
interface IntToIntFunction {
    int apply(int value);
}
IntToIntFunction anonymous = new IntToIntFunction() {
    @Override
    public int apply(int value) {
        // Your implementation here
        return value * 2; // Example transformation
    }
};
IntToIntFunction lambda = (value) -> {
    // Your implementation here
    return value * 2; // Example transformation
};
@FunctionalInterface
interface IntIntToVoidFunction {
    void apply(int value1, int value2);
}
IntIntToVoidFunction anonymous = new IntIntToVoidFunction() {
    @Override
    public void apply(int value1, int value2) {
        // Your implementation here
        System.out.println("Values: " + value1 + ", " + value2); // Example action
    }
};
IntIntToVoidFunction lambda = (value1, value2) -> {
    // Your implementation here
    System.out.println("Values: " + value1 + ", " + value2); // Example action
};

```


# Exercice 6 : 



## Mini projet : 

Array 

```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class ArrayBasedImpl implements StackOfInts {
    public int[] List = new int[0];
    @Override
    public int pop() {
        int[] newList = new int[--numOfElems];
        System.arraycopy(List, 0, newList, 0, List.length - 1);
        int elem = List[numOfElems];
        List = newListss;
        return elem;
    }


    @Override
    public void push(int x) {
        int [] newList = new int[++numOfElems];
        System.arraycopy(List,0,newList,0,List.length);
        newList[numOfElems -1 ] = x;
        List = newList;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        return List[numOfElems -1];
    }

    private int numOfElems = 0;
}

```

LinkedList 

```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    @Override
    public int pop() {
        int object = first.elem;
        first = first.next;
        numOfElems--;
        return object;

    }

    @Override
    public void push(int x) {
       first = new Node(x,first);
       numOfElems++;

    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;
}

```


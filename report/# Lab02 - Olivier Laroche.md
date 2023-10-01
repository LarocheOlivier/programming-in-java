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

[toc]

# 1 Language Basics

## 1.1 Variables

**Kinds**
- Instance Variables(Non-Static Fields)
- Class Variables(Static Fields)
- Local Variables
- Parameters 

**Name**
- If the name you choose consists of only one word, spell that word in all lowercase letters. 
- If it consists of more than one word, capitalize the first letter of each subsequent word. The names gearRatio and currentGear are prime examples of this convention. 
- If your variable stores a constant value, such as static final int NUM_GEARS = 6, the convention changes slightly, capitalizing every letter and separating subsequent words with the underscore character. 
- By convention, the underscore character is never used elsewhere.

### 1.1.1 Primitive Data Type

- byte 8bit
- short 16bit
- int 32bit
- long 64bit
- float 32bit IEEE 754
- double 64bit
- boolean
- char 16bit Unicode \u0000~\uffff

**Character and String Literals**

- The Java programming language also supports a few special escape sequences for char and String literals: \b (backspace), \t (tab), \n (line feed), \f (form feed), \r (carriage return), \" (double quote), \' (single quote), and \\ (backslash).

**Using Underscore Characters**
> In Java SE 7 and later
```java
long creditCardNumber = 1234_5678_9012_3456L;
float pi =  3.14_15F;
long maxLong = 0x7fff_ffff_ffff_ffffL;
byte nybbles = 0b0010_0101;
long bytes = 0b11010010_01101001_10010100_10010010;
```

#### 1.1.2 Arrays
**Copying Arrays**
```java
public static void arraycopy(Object src, int srcPos,
                             Object dest, int destPos, int length)
```
**Some useful operations**
- binarySearch method
- equals method
- fill method
- sort or parallelSort method

## 1.2 Operators

**Type Comparison Operator**
```java
instanceof      Compares an object to 
                a specified type 
```
**Bitwise and Bit shift Operators**
```java
~       Unary bitwise complement
<<      Signed left shift
>>      Signed right shift
>>>     Unsigned right shift
&       Bitwise AND
^       Bitwise exclusive OR
|       Bitwise inclusive OR
```
## 1.3 Control Flow Statements
- if-then(-else)
- switch
- while, do-while
- for
- branching

### 1.3.1 switch
**Works on**
- byte, short, char and int
- String class

### 1.3.2 The for Statement
**Enhanced for**
```java
    int[] numbers = 
        {1,2,3,4,5,6,7,8,9,10};
    for (int item : numbers) {
        System.out.println("Count is: " + item);
    }
```

# 2 Numbers and Strings


## 2.1 Numbers
### 2.1.1 The Numbers Classes
- Number
  - Byte, Integer, Double, Short, Float, Long
  - BigDecimal, BigInteger
  - AtomicInteger, AtomicLong
- Usage
  - As an argument of a method that expects an object (often used when manipulating collections of numbers).
  - To use constants defined by the class, such as MIN_VALUE and MAX_VALUE, that provide the upper and lower bounds of the data type.
  - To use class methods for converting values to and from other primitive types, for converting to and from strings, and for converting between number systems (decimal, octal, hexadecimal, binary).

### 2.1.2 Formatting Numeric Print Output
```java
public PrintStream format(String format, Object... args)
```
**Example**
```java
System.out.format("The value of " + "the float variable is " +
     "%f, while the value of the " + "integer variable is %d, " +
     "and the string is %s", floatVar, intVar, stringVar); 
```

**Converters and Flags**
- Converters
  - d A decimal integer
  - f A float
  - n A new line (%n recommended)
- Flags
  - 08 Eight characters in width
  
  - \+ Includes sign
  
  - , Includes locale-specific grouping characters
  
- \- Left-justified
  
  - .3 Three places after decimal point
  
  - 10.3 Ten characters in width, right justified, with three places after dicimal point
  
    

**The DecimalFormat Class**

```java
    static public void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    static public void main(String[] args) {
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);  
   }
```
### 2.1.3 Beyond Basic Arithmetic
- The Math class
  - Math.E, Math.PI
  - abs
  - ceil, floor, round
  - min, max
  - exp, log, pow, sqrt
  - sin, cos, tan, asin, acos, atan
- Random numbers

## 2.2 Strings
The String class is **immutable**

### 2.2.1 Useful Methods
- Converting to Numbers
  - parseXXXX() method
- Converting Numbers to Strings**
  - String.valueof()
  - toString()
- charAt
- substring
- trim, toLowerCase, toUpperCase
- indexOf, lastIndexOf, contains
- replace, replaceAll, replaceFirst

### 2.2.2 The StringBuilder Class
Can be modified
- methods
  - append, delete, deleteCharAt, insert
  - replace, setCharAt, reverse
  - toString

## 2.3 Autoboxing and Unboxing
> Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.

| Primitive type | Wrapper class |
| -------------- | ------------- |
| boolean | Boolean |
| char | Character |
| float | Float |
| int | Integer |
| long | Long |
| short | Short |
| double | Double |

**autoboxing**
```java
Character ch = 'a';
```

**unboxing**
```java
import java.util.ArrayList;
import java.util.List;

public class Unboxing {

    public static void main(String[] args) {
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // Π is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}
```

# 3 Classes and Objects
## 3.1 Classes
### 3.1.1 Member Variables
- Member variables in a class—these are called **fields**.
- Variables in a method or block of code—these are called **local variables**.
- Variables in method declarations—these are called **parameters**.
### 3.1.2 Constructor
#### Parameter Types
You can use any data type for a parameter of a method or a constructor. This includes primitive data types, such as doubles, floats, and integers, as you saw in the computePayment method, and reference data types, such as objects and arrays.
#### Arbitrary Number of Arguments
>You can use a construct called varargs to pass an arbitrary number of values to a method. You use varargs when you don't know how many of a particular type of argument will be passed to the method. It's a shortcut to creating an array manually (the previous method could have used varargs rather than an array).
```java
public Polygon polygonFrom(Point... corners) {
    int numberOfSides = corners.length;
    double squareOfSide1, lengthOfSide1;
    squareOfSide1 = (corners[1].x - corners[0].x)
                     * (corners[1].x - corners[0].x) 
                     + (corners[1].y - corners[0].y)
                     * (corners[1].y - corners[0].y);
    lengthOfSide1 = Math.sqrt(squareOfSide1);

    // more method body code follows that creates and returns a 
    // polygon connecting the Points
}
```
#### Passing Reference Data Type Arguments
Reference data type parameters, such as objects, are also passed into methods by value. This means that when the method returns, the passed-in reference still references the same object as before. However, the values of the object's fields can be changed in the method, if they have the proper access level.
## 3.2 Objects
### 3.2.1 Creating Objects
1. **Declaration**: The code set in bold are all variable declarations that associate a variable name with an object type.
2. **Instantiation**: The new keyword is a Java operator that creates the object.
3. **Initialization**: The new operator is followed by a call to a constructor, which initializes the new object.

### 3.2.1 Using Objects

**Referencing an object’s fields**
- Use a simple name for a field within its own class
- Code outside: objectReference.fieldName
- Calling an object’s methods

**Garbage collector**
- An object is eligible for garbage collection when there are no more references to that object
- System.gc()
- The finalize() method

## 3.3 More on Classes

### 3.3.1 Using the this Keyword

The most common reason for using the this keyword is because a field is shadowed by a method or constructor parameter

#### Using this with a Field
```java
public class Point {
    public int x = 0;
    public int y = 0;
        
    //constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

#### Using this with a Constructor
>From within a constructor, you can also use the this keyword to call another constructor in the same class. Doing so is called an explicit constructor invocation. 

```java
public class Rectangle {
    private int x, y;
    private int width, height;
        
    public Rectangle() {
        this(0, 0, 1, 1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    ...
}
```

### 3.3.3 Access Control

**At the top level**
- public, or package-private
  

**At the member level**

| Modifier | Class | Package | Subclass | World |
| -------- | ----- | ------- | -------- | ----- |
| public | Y | Y | Y | Y |
| protected | Y | Y | Y | N |
| no modifier | Y | Y | N | N |
| private | Y | N | N | N |

### 3.3.4 Class Members

**Class Members**

- The `static` modifier
- referenced or invoked by the class name
- Constants with `final` modifier
- Singleton

### 3.3.5 Initializing Fields

- initial value
- in constructors
- static initialization blocks
- private static method

## 3.4 Nested Classes

- stiatic nested classes
- inner classes
- A nested class is a member of its enclosing class
  - have access to other members of the enclosing class even if they are declared private

**Reasons**

- logically grouping classes that are only used in one place
- increasing encapsulation
- readable and maintainable code

**Static Nested Classes**

- cannot refer directly to instance variables or methods
- are accessed using the enclosing class name

```java
OuterClass.StaticNestedClass
```

**Inner Classes**

- Associated with an instance of enclosing class
- Cannot define any static members

```java
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```

**Shadowing**

```java
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
```

### 3.4.1 Anonymous Classes

- Anonymous classes make code more concise
  - Declare and instantiate a class at the same time
  - They do not have a name: use them if you need to use a local class only once

**e.g**

```java
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        }
```

- The anonymous class expression consists of the following:
  - The new operator
  - The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface HelloWorld.
  - Parentheses that contain the arguments to a constructor. Note: When you implement an interface, there is no constructor, so you use an empty pair of parentheses.
  - A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.

### 3.4.2 Lambda Expressions and Stream

#### Introduction

#### Lambda Expressions

- `(type parameters) -> {statements;}`
- Treat functionality as method argument, or code as data
- Some parts are optional if possible
  - Parameter types
  - Parentheses
  - Braces
  - return
- Variable scope
  - The same scope as its enclosing scope
  - access local variables and parameters of the enclosing scope that are final of effectively final
- Standard functional interfaces

#### Stream
- Aggregate operation: computing a single value from a collection of values
  - Results may be primitive value, void or an object
- A stream is a sequence of data elements supporting sequential and parallel aggregate operations

**Creating streams**
- From values: `Stream.of(T...)`
- Empty streams: `Stream.empty()`
- From arrays: `Arrays.stream(T[] array)`
- From collections: `Collection.stream()`

**Immediate operations**

- filter()
- map()
- sorted()
- limit()

**Terminal operations**

- min()
- max()
- count()
- findAny()
- toArray()
- collect()

#### Best Practice
- Prefer lambdas to anonymous classes
- Prefer method references to lambdas
- Favor the use of standard functional interfaces
  - Declare a new interface only necessary
- Prefer Collection to Stream as a return type
- Be careful when making streams parallel

## 3.5 Enum Types

- a special data type
  - All enums implicitly extend java.lang.Enum
  - The enum class body can inblude methods and other fields
  - The contructor for an enum type must be package-private or private

```java

public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}

public class EnumTest {
    Day day;
    
    public EnumTest(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
```

# 4 Interfaces and Inheritance

## 4.1 Interfaces

- Generally speaking, interfaces are contracts
- A reference type, that can contain only constants, method signatures, default methods, static methods, and nested types
- Interfaces cannot be instantiated
  - They can only be implemented by classes or extended by other interfaces
- Interfaces as APIs

### 4.1.1 Defining an Interface
> An interface declaration consists of modifiers, the keyword interface, the interface name, a comma-separated list of parent interfaces (if any), and the interface body. For example:

```java
public interface GroupedInterface extends Interface1, Interface2, Interface3 {

    // constant declarations
    
    // base of natural logarithms
    double E = 2.718282;
 
    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);
}
```
**Interface Body**

- The interface body can contain abstract methods, default methods, and static methods. All abstract, default, and static methods in an interface are implicitly public, so you can omit the public modifier.
- In addition, an interface can contain constant declarations. All constant values defined in an interface are implicitly public, static, and final. Once again, you can omit these modifiers.

### 4.1.2 Implementing an Interface
- Include an implements clause in the class declaration
- Your class can implement more than one interface
**e.g**
```java
public interface Relatable {
        
    // this (object calling isLargerThan)
    // and other must be instances of 
    // the same class returns 1, 0, -1 
    // if this is greater than, 
    // equal to, or less than other
    public int isLargerThan(Relatable other);
}

public class RectanglePlus 
    implements Relatable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    ...

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }
    
    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect 
            = (RectanglePlus)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;               
    }
}
```
### 4.1.3 Using an Interface as a Type
> When you define a new interface, you are defining a new reference data type. You can use interface names anywhere you can use any other data type name. If you define a reference variable whose type is an interface, any object you assign to it must be an instance of a class that implements the interface.
```java
public Object findLargest(Object object1, Object object2) {
   Relatable obj1 = (Relatable)object1;
   Relatable obj2 = (Relatable)object2;
   if ((obj1).isLargerThan(obj2) > 0)
      return object1;
   else 
      return object2;
}
```

### 4.1.4 Evolving Interfaces

- You can create an interface that extends an existing interface
```java
public interface DoIt {
   void doSomething(int i, double x);
   int doSomethingElse(String s);
}
public interface DoItPlus extends DoIt {

   boolean didItWork(int i, double x, String s);
   
}
```
### 4.1.5 Default methods
- Enabling you to add new functionality and ensure binary compatibility with code written for older versions of those interfaces
- When you extend an interface that contains a default method, you can
  - Not mention the default method at all
  - Redeclare the default method, which makes it abstract
  - Redefine the default method, which overrides it
#### Static methods
- In addition to default methods, you can define static methods in interfaces.
- you can keep static methods specific to an interface in the same interface rather than in a separate class.

## 4.2 Inheritance

- Class can be derived from other classes, inheriting fields and methods
- Deinitions
  - Subclass
  - Superclass
- Every class has one and only one direct superclass (single inheritance)
- A sub class inherits all the members
  - Constructors are not members

**What You Can Do in a Subclass**

- The inherited fields can be used directly, just like any other fields.
- You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
- You can declare new fields in the subclass that are not in the superclass.
- The inherited methods can be used directly as they are.
- You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it.
- You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
- You can declare new methods in the subclass that are not in the superclass.
- You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.

**Private Members in a Superclass**

- A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.
- A nested class has access to all the private members of its enclosing class—both fields and methods. Therefore, a public or protected nested class inherited by a subclass has indirect access to all of the private members of the superclass.

**Casting Objects**

- Implicit casting
```java
Object obj = new MountainBike();
```

- Explicit casting

```java
MountainBike myBike = (MountainBike)obj;
```

- The instanceof operator
  
```java
if (obj instanceof MountainBike) {
    MountainBike myBike = (MountainBike)obj;
}
```

### 4.2.1 Multiple Inheritance
- state
- implementation
  - Multiple inheritance of implementation is the ability to inherit method definitions from multiple classes.
- type
  - the ability of a class to implement more than one interface. An object can have multiple types: the type of its own class and the types of all the interfaces that the class implements. 

### 4.2.2 Overriding and Hiding Methods
- Instance methods
  - The same signature and return type
  - An overriding method can also return a subtype
- Static methods
  - The same signature

#### Distinction between hiding a static methood and overriding
- e.g
```java
public class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
```
Output:
The static method in Animal
The instance method in Cat

#### Modifiers
- The access specifier for an overriding method can allow more, but not less, access than
the overridden method

### 4.2.3 Polymorphism
>The Java virtual machine (JVM) calls the appropriate method for the object that is referred to in each variable. It does not call the method that is defined by the variable's type. This behavior is referred to as virtual method invocation and demonstrates an aspect of the important polymorphism features in the Java language.

### 4.2.4 Use the Keyword super

#### Accessing Superclass Members

>If your method overrides one of its superclass's methods, you can invoke the overridden method through the use of the keyword super. You can also use super to refer to a hidden field (although hiding fields is discouraged). Consider this class, Superclass:
```java
public class Subclass extends Superclass {

    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass");
    }
    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();    
    }
}
```

#### Subclass Constructors

```java
public MountainBike(int startHeight, 
                    int startCadence,
                    int startSpeed,
                    int startGear) {
    super(startCadence, startSpeed, startGear);
    seatHeight = startHeight;
}   
```

### 4.2.5 Object as a Superclass
```java
protected Object clone() throws CloneNotSupportedException
    //Creates and returns a copy of this object.
public boolean equals(Object obj)
    //Indicates whether some other object is "equal to" this one.
protected void finalize() throws Throwable
    //Called by the garbage collector on an object when garbage
    //collection determines that there are no more references to the object
public final Class getClass()
    //Returns the runtime class of an object.
public int hashCode()
    //Returns a hash code value for the object.
public String toString()
    //Returns a string representation of the object.
```

### 4.2.6 Final Methods/Classes
- You can declare some or all of a class's methods final. You use the `final` keyword in a method declaration to indicate that the method cannot be overridden by subclasses. The `Object` class does this—a number of its methods are `final`.
- You might wish to make a method final if it has an implementation that should not be changed and it is critical to the consistent state of the object.

### 4.2.7 Abstract Methods and Classes
- An abstract class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.
```java
abstract void moveTo(double deltaX, double deltaY);
```

- An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon)
```java
public abstract class GraphicObject {
   // declare fields
   // declare nonabstract methods
   abstract void draw();
}
```

#### Abstract Classes Compared to Interfaces
>Abstract classes are similar to interfaces. You cannot instantiate them, and they may contain a mix of methods declared with or without an implementation. However, with abstract classes, you can declare fields that are not static and final, and define public, protected, and private concrete methods. With interfaces, all fields are automatically public, static, and final, and all methods that you declare or define (as default methods) are public. In addition, you can extend only one class, whether or not it is abstract, whereas you can implement any number of interfaces.

- Consider using abstract classes if any of these statements apply to your situation:
  - You want to share code among several closely related classes.
  - You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
  - You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.
- Consider using interfaces if any of these statements apply to your situation:
  - You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
  - You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
  - You want to take advantage of multiple inheritance of type.

# 5 Exceptions

> An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.
> When an error occurs within a method, the method creates an object and hands it off to the runtime system. The object, called an exception object, contains information about the error, including its type and the state of the program when the error occurred. Creating an exception object and handing it to the runtime system is called throwing an exception.

## 5.1 The Catch or Specify Requirement

- Code that might throw certain exceptions must be enclosed by either of the following
  - A try statement that catches the exception
    - Providing a handler for the exception
  - A method that specifies that it can throw the exception
    - Providing a throws clause that lists the exception
- Not all exceptions are subject to the Catch or Specify Requirement

**Three KInds of Exception**
- Checked exception: exceptional conditions that a well-written application should anticipate and recover from
  - Example: java.io.FileNotFoundException
  - Subject to the Catch or Specify Requirement
- Error: exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from
  - Example: java.io.IOError
- Runtime exception: exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from
  - Example: NullPointerException
- Errors and runtime exceptions are known as unchecked exceptions

## 5.2 Catching and Handling Exceptions

**e.g**
```java
public void writeList() {
    PrintWriter out = null;

    try {
        System.out.println("Entering" + " try statement");

        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    } catch (IndexOutOfBoundsException e) {
        System.err.println("Caught IndexOutOfBoundsException: "
                           +  e.getMessage());
                                 
    } catch (IOException e) {
        System.err.println("Caught IOException: " +  e.getMessage());
                                 
    } finally {
        if (out != null) {
            System.out.println("Closing PrintWriter");
            out.close();
        } 
        else {
            System.out.println("PrintWriter not open");
        }
    }
}
```
- The try block
- The catch blocks
  - The argument type must be the name of a class that inherits from the Throwable class
  - The runtime system invokes the exception handler when the handler is the first one in the call stack whose ExceptionType matches the type of the exception thrown
  - A single catch block can handle more than one type of exception
- The finally block

## 5.3 Specifying the Exceptions Thrown by a Method
- In some cases, it is better to let a method further up the call
stack handle the exception
- The throws clause comprises the throws keyword followed by a comma-separated list of all the exceptions thrown by that method

**e.g**
```java
public void writeList() throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    for (int i = 0; i < SIZE; i++) {
        out.println("Value at: " + i + " = " + list.get(i));
    }
    out.close();
}
```

## 5.4 Throwing Exceptions

**The throw Statement**

```java
public Object pop() {
    Object obj;

    if (size == 0) {
        throw new EmptyStackException();
    }

    obj = objectAt(size - 1);
    setObjectAt(size - 1, null);
    size--;
    return obj;
}
```

**Throwable Class and Its Subclass**
>The objects that inherit from the `Throwable` class include direct descendants (objects that inherit directly from the `Throwable` class) and indirect descendants (objects that inherit from children or grandchildren of the `Throwable` class). The figure below illustrates the class hierarchy of the `Throwable` class and its most significant subclasses. As you can see, `Throwable` has two direct descendants: `Error` and `Exception`.

### 5.4.1 Chained Exceptions
An application often responds to an exception by throwing another exception
```java

Throwable getCause()
Throwable initCause(Throwable)
Throwable(String, Throwable)
Throwable(Throwable)

try {

} catch (IOException e) {
    throw new SampleException("Other IOException", e);
}
```

### 5.4.2 Creating Exception Classes
- When faced with choosing the type of exception to throw, you can either use one written by someone else — the Java platform provides a lot of exception classes you can use — or you can write one of your own. You should write your own exception classes if you answer yes to any of the following questions; otherwise, you can probably use someone else's.

  - Do you need an exception type that isn't represented by those in the Java platform?
  - Would it help users if they could differentiate your exceptions from those thrown by classes written by other vendors?
  - Does your code throw more than one related exception?
  - If you use someone else's exceptions, will users have access to those exceptions? A similar question is, should your package be independent and self-contained?

## 5.5 Advantages of Exceptions

- Separating error-handling code from regular code
- Propagating errors up the call stack
- Grouping and differentiating error types


# 6 Generics

- Generics: enabling types (classes, interfaces) to be parameters
  - Stronger type checks at compile time
  - Elimination of casting
  - Enabling us to implement generic algorithms

## 6.1 Generic Types

- A generic class or interface that is parameterized over types
- Defined with the following format

```java 
class ClassName<T1, T2, …, Tn> {…}
```

- A type variable can be any non-primitive type
- Invoking and instantiating easily

```java
ClassName<Type> instance = new ClassName<Type>();
```

- Diamond: compiler infers type arguments from context

```java
List<String> myList = new ArrayList<>();
```

**Type Parameter Naming Conventions**

The most commonly used type parameter names are:
- E - Element (used extensively by the Java Collections Framework)
- K - Key
- N - Number
- T - Type
- V - Value
- S,U,V etc. - 2nd, 3rd, 4th types

## 6.2 Generics Methods

- Methods that introduce their own type parameters
- Both static and non-static methods are allowed
- Syntax: a list of type parameters, inside angle brackets, which appears before the method’s return type
- For static generic methods, the type parameter section must appear before the method’s return type

```java
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}
```

## 6.3 Generics, Inheritance, and Subtypes
- Arrays are covariant
  - `T[]` may contain elements of `T` or any subtype of `T`
  - `S[]` is a subtype of `T[]` if `S` is a subtype of `T`
- Java generics are invariant
  - `MyClass<S>` has no relationship to `MyClass<T>`
  - Subtype a generic class or interface by extending or implementing it

## 6.4 Wildcards
- Bounded type parameters
  - Restrict the types that can be used as type arguments
  - List the type parameter's name, followed by extends
  - Multiple bounds are supported, using “&”
- Wildcard: “?” representing an unknown type
  - Used as the type of a parameter, field, local variable or return type
  - List<?>, Box<?>, Map<?, ?>…
  - Upper bounded, lower bounded, and even unbounded
- Unbounded wildcards
  - A list of unknown type, List<?>, Box<?>
  - Using functionality provided in the Object class
  - Using methods in the generic class that do not depend on the type parameter
- Upper bounded wildcards
  - Restriction on the variable: ? extends
  - Restricting the unknown type to be a specific type or a subtype of that type: List<? extends Number>, Box<? extends Integer>…
- Lower bounded wildcards
  - ? super A
  - Restricting the unknown type to be a specific type or a super type of that type: List<? super Integer>…
- Wildcards and subtyping
  - A relationship now exists between intList and numList

## 6.5 Type Erasure
- The compiler erases all type parameters, ensuring that no new classes are created for parameterized types
  - Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded
  - Insert type casts if necessary to preserve type safety
- Incurring no runtime overhead
  - Only raw types during runtime

## 6.6 Best Practice
- Do not use raw types
  - Except for class literals: List.class, String[].class (List<String>.class is illegal in java)
- Prefer lists to arrays
- Use bounded wildcards to increase API flexibility
  - public void pushAll(Iterable<E> src) (x)
  - public void pushAll(Iterable<? extends E> src) (√)

# 7 Annotations

Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.
Annotations have a number of uses, among them:
- Information for the compiler
- Compile-time and deployment-time processing — Software tools can process annotation information to generate code, XML files, and so forth.
- Runtime processing

## 7.1 Annotations Basics

**Format**

- Format
- @Entity

```java
@Override
void mySuperMethod() { ... }
```
- Can include elements, named or unnamed, with values

```java
@SuppressWarnings(value = "unchecked")
void myMethod() { ... }
```

- Can be applied to declarations of classes, fields, methods, and other program elements
- Each annotation often appears on its own line by convention
- Multiple and repeating annotations on the same declaration are supported

## 7.2 Predefined Annotation

- @Deprecated: indicating that the marked element is deprecated and should no longer be used
- @Override: informing the compiler that the element is meant
to override an element declared in a superclass
- @SuppressWarnings: telling the compiler to suppress specific
warnings that it would otherwise generate
- @FunctionalInterface

**e.g**

```java
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}
```

## 7.3 Best Practice
- Prefer annotations to naming patterns
- Consistently use the @Override annotation
- Use marker interfaces to define types

# 8 Reflection

- A feature in Java, allowing an executing Java program to examine or “introspect” upon itself, and manipulate internal properties of the program
  - Examining properties of a class, setting and getting field values, invoking methods, ...
- Powerful, and has no equivalent in many other languages

## 8.1 Entry Point for All reflection APIs

- JVM instantiates an immutable instance of java.lang.Class for every type of object
  - Providing methods to examine the runtime properties of the object including its members and type information
  - Providing the ability to create new classes and objects
- Retrieving class objects
  - Object.getClass()
  - .class
  - Class.forName()
  - Class.getSuperclass()
  - Class.getClasses()
  - ...

## 8.2 Reflection APIs

- Examine class modifiers and types
  - getModifiers()
  - getTypeParameters()
  - getGenericInterfaces()
  - getAnnotations()
  - ...
- Fetch annotation information
- Discover class members
  - getDeclaredFields() / getDeclaredMethods(): including private members, but no inherited members
  - getFields() / getMethods(): including inherited members, but no private members
  - ...
- Field
  - Providing methods for accessing type information and setting and getting values of a field on a given object
  - getModifiers()
  - getType()
  - get(Object obj), getByte(Object obj), getInt(Object obj), ...
  - set(Object obj), setByte(Object obj), setInt(Object obj), ...
- Method
  - Providing APIs to access information about a method’s modifiers, return type and parameters, and to invoke methods
  - getReturnType()
  - getGenericReturnType()
  - getParameterTypes()
  - invoke(Object obj, Object... args)
- Constructor
  - Information about a constructor
  - Preferred to be used for creating instances of classes, regardless of the number of parameters

## 8.3 Drawbacks
- Performance suffers
  - Reflective method invocation is much slower than normal method invocation
- Security restrictions
  - Reflection requires a runtime permission which may not be present in a restricted security context
- Readability sacrificed
  - The code required to perform reflective access is clumsy and verbose
- Exposure of internals
  - May result in unexpected side-effects
- Lose benefits of compile-time type checking
- Therefore, use reflection only when necessary

# 9 Collections

## 9.1 Collection Interfaces

- Collection: root
- Set: no duplicate elements
- List: an ordered collection
- Queue(FIFO), Deque(FIFO, LIFO)
- Map
- Common methods
  - `int size()`
  - `boolean isEmpty()`
  - `T[] toArray(T[])`
  - `boolean add(E)`
  - `boolean remove(Object)`
  - ...

## 9.2 List Interface

[document](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)

## 9.3 Set Interface

[document](https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html)

## 9.4 Map Interface

[document](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)

## 9.5 Queue Interface

[document](https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html)

## 9.6 Deque Interface

[document](https://docs.oracle.com/javase/tutorial/collections/interfaces/deque.html)

## 9.7 Utilities

- `sort(List<T> list)`
- `fill(List<? super T> list, T obj)`
- `copy(List<? super T> dest, List<? extends T> src)`
- `unmodifiableList(List<? extends T> list)`

## 9.8 Collection Initialization

- Created from an Array
  - `Arrays.asList(T[])`
- Factory methods >JDK9
  - `Map.of()`
- Double-brace init
- Collections


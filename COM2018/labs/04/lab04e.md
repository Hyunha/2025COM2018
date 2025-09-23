# [COM2018] 2025 Fall Object-oriented Programming
## School of Computer Science, College of Computing, Hanyang University ERICA

- Following what you learned in class, take part of the code written
  in a single `main` method and refactor it into a separate function.
- Practice creating an application that uses `showInputDialog` from
  the `javax.swing` package's `JOptionPane` to receive user input via
  an input window, and `showMessageDialog` to display the calculation
  results in a message window.
- Complete the exercise during lab time and have it checked by the
    teaching assistant.

## [Lab 4-1] Creating a Method in a Circle Area Program

```java
import java.text.DecimalFormat;

public class Circle {
    public static void main(String[] args) {
        int radius = 5;
        double area = Math.PI * radius * radius;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Area of circle: " + df.format(area));
    }
}
```

1. Refactor the code above by writing a separate method called `area`.
   (Refer to `ClassManagement`, `TextSearch` covered in class.)
```java
import java.text.DecimalFormat;

public class Circle {
    public double area(int raidus) {
        return 0.0;    
    }
    
    public static void main(String[] args) {
        int radius = 5;
        Circle c = new Circle();
        // ...
    }
}
```

2. Next, instead of using a fixed `radius`,
   modify the program to take user input via a message dialog as shown
   below:

<img src="./img/1-in.png" width="350">

Also display the result in a message dialog instead of the console:

<img src="./img/1-out.png" width="350">

## [Lab 4-2] Implementing with the MVC Architecture

Rewrite the code from Lab 4-1 according to the MVC structure shown
below:

<img src="./img/classdiagram.png" width="600">
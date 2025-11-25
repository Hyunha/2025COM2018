# [COM2018] 2025 Fall Object-oriented Programming
## School of Computer Science, College of Computing, Hanyang University ERICA

### Lab: The Throbbing Ball

Improve the program from the previous session, which displayed a ball whose size and color changed.
- When the program starts, regardless of the `OK` button,  the ball’s size should change **automatically and continuously**.
- Based on the time interval entered by the user, **only the ball’s size** should be changed.
- When the user clicks the `OK` button,  the color of the ball should change. 
  - If the ball is red, it should change to blue.
  - If the ball is blue, it should change to red.

The provided code is an updated version of the TO-BE code from the previous lab.
Use the class diagram and method descriptions below to complete the program.

<img src="img/lab01_cd.png" width="750">

#### Key Method Hints by Class

- `ThrobbingBall`
    - `flipColor()` : Changes the color of the ball. (Red → Blue, Blue → Red)
    - `getColor()` : Returns the current color of the ball.
- `ThrobController`
    - `run()` : An infinite loop that:
      - toggles the size of the ball 
      - repaints the panel 
      - then pauses by calling delay()
    - `delay()` : Pauses the execution for the specified amount of time (`time` milliseconds).
- `ThrobPanel`
    - `update()` : Updates the state and repaints the display.
- `ColorButton`
    - `actionPerformed(ActionEvent e)` : Changes the color of the ball each time the button is pressed, and then calls `view.update()`.


#### Reference Code for Implementing `ThrobController`

```Java
public class LoopSample {
    static void main() {
        LoopSample s = new LoopSample();
        System.out.println("Let's start game...");
        System.out.println("3");
        s.delay(1000);
        System.out.println("2");
        s.delay(1000);
        System.out.println("1");
        s.delay(1000);
        System.out.println("start!");
        boolean b = true;
        while (true) {
            s.delay(330);
            if (b) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            b = !b;
        }
    }

    private void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
```

### Lab 2 : Counter Button

In the previous class, you completed the Counter program, where pressing the OK button draws a ball in the center Drawing panel.
However, when the user changes the color using the menu bar, all previously drawn balls are redrawn using the current color, ignoring their original colors.

Modify the code so that each ball keeps the color it had when it was originally drawn, as shown in the TO-BE example below.

<img src="img/lab02.png" width="750">

Hint
- Prepare an array of `Color` objects.
- Each time the `OK` button is pressed, store the current color of the ball into this array.
- When drawing balls in the `Drawing` panel, use the colors stored in the `Color` array.
- Think about where the `Color` array should be placed in your program.
# [COM2018] 2025 Fall Object-oriented Programming
## School of Computer Science, College of Computing, Hanyang University ERICA

### Lab 1 : A Ball that Changes Size and Color

- Using the `ActionListener` covered this week, draw a ball that changes size and color.

Draw a ball that periodically changes size, and changes color when a button is pressed.
When the program starts, the ball repeatedly shrinks and grows at regular intervals.
The ball starts red, and each time the **OK** button is pressed, it should toggle between blue and red.

<img src="img/lab01e.png" width="750">

The class diagram for the whole program is shown below.
`ColorButton` implements `ActionListener` and reacts to the user's button-press events.

<img src="img/lab01_cd.png" width="750">

- `ColorButton` : `actionPerformed(ActionEvent e)` - Changes the ball’s color whenever an event occurs.
- `ThrobbingBall` : `throb()` - Toggles whether the ball is at its large size (`isLarge`).
- `ThrobController` : `run()` -  In an infinite loop, toggles the ball’s size state, repaints the ThrobPanel (`writer.repaint()`), then sleeps for the specified time (`Thread.sleep(time)`).

### Lab 2 : Slide Puzzle (GUI Version)

- Let’s turn the slide puzzle you implemented last time into a GUI version.
  As shown below, implement each puzzle piece (`PuzzlePiece`) on the board as a button.

<img src="img/lab02.png" width="750">

The class diagram for the whole program is shown below.
`PuzzleButton` implements `ActionListener` and reacts to the user’s button-press events.

<img src="img/lab02_cd.png" width="750">
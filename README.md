# eec421
Software Enigneering projects:

The objective is to implement a simple maze. 

To design model used here was previously a waterfall model.
But we will try to similate an agile model by incementaly delivering a working solution.


As of 9/23/2015:
 - The software has changed in such a way that the user is able to change the size of the maze.
 - the user is also asked if s/he wants to play the demo again.
 - The resquest is printed into the console.
 
New Challenge on MazeV001.java:
 - Be able to display the request through the Applet, not the console.
 - Be able to print the time it take to reach destination, meaning solving the maze
 - Show the final path in the text descriptive format. For example: Forward, Turn Left, Forward, Turn Right, Forward, Forward.

Improvement on mazeme.java:
 - The application is able to generate a text based maze, with 'x' as wall and empty space as path.
 - The user is required to input the desired length

Challenge on mazeme.java:
 - Be able to move the object inside the maze.
 - The object should be able to find another path when it reaches a wall.
 - The object should be able to reach destination.

As of 9/27/2015
Change made on mazeme.java:
 - Implementation of the solveMaze() function
 - The areas visited are marked by 0.
 - The paths found are carry along with '@'
 - The maze is solved when the object reaches the bottom corner.

Additionnal requirement:
 - The App should not exit without asking to the user if s/he is willing to play again.
 - The App should give as result the number of iteration it takes to solve the maze

Challenge on mazeme.java:
 - Improve the tearwall() function, for better generation of the Maze
 
As of 10/12/2015
New Software specification for mazeme.java: Update mazeme.java to version 2.0
 - The application is called GMaze for Generator Maze
 - The application will no longer reach for a specific target or final destination.
 - The application is now able to track intruders in the maze and killed or erased them.
 - The application will provide statistics of number of intruders found and deleted.
 - the application will also inform the user about intruders that were not deleted.
 - The GMaze will act like an antivirus with goal to clean the system.

Challenge on mazeme.java:
 - Introduce a system of timing to stop the Runner as soon as there is no intruder left.
 - This will prevent the Runner to waste time searching for possible intruders.
 - This will increase efficiency and quick feedback.

New update: of mazeme.java 10/15/2015
 - No need to put a timer to stop the VRunner.
 - Issue resolved by comparing the number of 'hit' and the number of intruders.
 - A 'hit' is when the VRunner catches and erases an intruder.

As of 10/19/2015 The Final implementation can be seen in probuildzer/MazeRunner.
...waiting for more specification.

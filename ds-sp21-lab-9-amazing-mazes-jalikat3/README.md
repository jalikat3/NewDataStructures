# Lab9-AmazingMazesStarterCode

## Objectives
The objective of this lab is to:
*  Implement an iterative maze traversal using a stack.
*  Use the Java collection ArrayDeque as a concrete implementation of a stack.

## Preliminaries

The Java collection classes that implement the Deque<E> interface are recommended for use over the Stack<E> class.  You will be using the ArrayDeque<E> class as a stack to implement the traversal of a maze.  To get started Google the Java 14 ArrayDeque API and locate the information on the ArrayDeque<E> class.  Complete the following table of equivalencies for stack ADT and the ArrayDeque<E> methods. Hint: Push, pop, and peek have two equivalent methods each.
 
| Stack ADT Method | ArrayDeque Equivalent |
| :----: | :--- |
| push(e) |  addFirst(E e), offerFirst(E e) |
| pop() | remove(), removeFirst()     |
| isEmpty() | isEmpty()   |
| getLength() | size()  |

## Amazing Mazes Application Architecture

The Amazing Mazes Application is composed of three classes.  A brief description of each of these classes follows:

*MazeApp* – The MazeApp class is the Java Application class for this program.  This class is complete and requires no coding for this lab.  It contains the main method for the application.

*Position* – The Position class represents the location of a cell in the application.  It has x and y instance variables and provides getX(), getY(), setX(e), and setY(e) accessor methods.  The Position class is complete and requires no additional coding.

*Maze* – The Maze class represents a maze.  The entry position for the maze is assumed to be (0,0) and the exit position is assumed to be the lower right-hand corner of the maze.  The Maze class provides the public methods traverse() and toString().  The toString() method is complete and converts the maze to String for printing.  The traverse() method attempts to iteratively solve the maze using a stack.  If it is successful, the method returns true.  Otherwise, it returns false.  The method has a side effect – it modifies the grid containing the maze.

## Assignment

The assignment for this lab is to complete the traverse() method of the Maze class.  Doing so will require you to complete the implementation of the two private methods nextMove(curPos) and isMoveValid(nxtPos).  Use the notes in the code as a guide. 

When you are finished, test to make sure your program traverses the maze.  Change the maze so it cannot be traversed.  Test your program to see if your program works.  Try defining a new maze and test to see if you can traverse it.  Remember, (0,0) must be the entry point for your new maze and the exit must be the lower right-hand corner.

Comments:

1.  The starter code for the assignment is in this repo.
2.  Use the Java 14 API page on ArrayDeque as a guide to using the class as a stack.
3.  grid.length is the number of rows in the maze. ***(Important)***
4.  grid[0].length is the number of columns in the maze. ***(Important)***
5.  Follow our example in class when deciding which direction to move next.  Order the directions in a given search order.  One possibility, though not an optimal one, would be North, East, South, and West. The idea is to try each direction in turn until you find a valid move. Remember if the node has been visited, it is not a valid move.  Return the first valid move you find.

## Finishing Up

Push your code back to your repository to submit the lab.

## Lab 9 Grading Rubric

1.  The code is structured as directed.
    *  6 points - While loop used in traverse loop, isMoveVaid. and nextMove are coded.
    *  4 points - Two of the three are coded.
    *  2 points - Code ibn the traverse method is completed without callin ghe other methods.
    *  0 points - Otherwise, no points.
    
2.  The program solves a maze that can be traversed.
    *  7 points - The program prints the maze was traversed and the path is marked with 3 or 7.
    *  4 points - The program prints the maze was traversed, but the path is not marked.
    *  3 points - The prints the maze was not traversed, but the path is marked.
    *  0 points - The program prints the maze was not traversed.
    
3.  The program identifies a maze cannot be traversed.
    *  7 points - The program prints the maze cannot be traversed and the path is marked only to the block.
    *  4 points - The program prints the maze cannot be traversed and the path is not marked to the block.
    *  3 points - The program prints the maze can be traversed bu the path is only marked to the block.
    *  0 points - The program prints the maze could be traversed.

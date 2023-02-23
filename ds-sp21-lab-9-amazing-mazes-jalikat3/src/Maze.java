import java.util.ArrayDeque;

/**
 * <p>The Maze class represents a maze. The following methods 
 * are provided: </p>
 *<ul>
 *  <li>boolean traverse() - determines if the maze can be
 *                           traversed.</li>
 *  <li>void toString()    - converts the maze to a string.
 * </ul>
 * 
 * It is assumed that the entry to the maze is at (0,0) and
 * the exit from the maze is in the lower right corner.
 * 
 * Adapted from: Lewis and Chase, Java Software Structures: 
 * Designing and Using Data Structures.
 * 
 * @author S. Sigman
 * @version 1.0 3/26/2017
 */
public class Maze
{

  // passed, will never be not 3 once passed once
  private final int TRIED = 3;

  // goes from the start to the finish, no backtracks included
  private final int PATH = 7;

  // the maze
  private int [][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,0,1,1,0,1,1,1,1,0,0,1},
                            {1,1,1,1,1,0,1,0,1,0,1,0,0},
                            {0,0,0,0,1,1,1,0,1,0,1,1,1},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} };
  

  
  /**
   * Attempts to iteratively traverse the maze.  It inserts special
   * characters indicating locations that have been tried and that
   * eventually become part of the solution.  This method uses a 
   * stack to keep track of the possible moves that could be made.
   * 
   * @return True if the maze can be traversed. Otherwise, false.
   */
  public boolean traverse ()
  {
    // Initial setup for search
    boolean done = false;  // At the start, the maze has not been 
                           // traversed.
    Position pos = new Position(); // Current position, (0,0) initially
    ArrayDeque<Position> stack = new ArrayDeque<Position>();
    stack.push(pos);  // put the first position on the stack
    grid[0][0] = PATH;   // mark the position T

    // Code for the traversal of the maze stack.
    // Position is maintained on the stack.
    // Loop until the position is at the
    // bottom right corner of the maze--(grid.length-1, grid[0].length-1)
    // or until there are no legal moves remaining--stack is empty.

    while (!(done))
    {
      System.out.println(this);
      // assert: pos==stack.peek() //invariant
      Position newMove=nextMove(stack.peek()); //makes a new move based on the first element in the stack

      // if the move is not valid, pop the move off the stack
      if (newMove==null){

        stack.pop();
      }

      // add move to the stack, set to 3 (TRIED)
      else{
        grid[newMove.getX()][newMove.getY()]=TRIED;

        stack.push(newMove);

        // if reaches the end
        if (newMove.getX()==grid.length-1 && newMove.getY()==grid[0].length-1){

          done=true;
        }

        // if the stack is empty, there is no way to traverse
        if(stack.isEmpty()==true){

          done=true;
        }

      }
    }

    // after successfully traversing, turn all elements in the stack to PATH
    while(!stack.isEmpty()){

      Position curPos=stack.pop();
      grid[curPos.getX()][curPos.getY()]=PATH;
    }

    return done;
  }
  
  /**
   * isMoveValid determines whether a given move is valid.  Validity
   * is determined by 1) if the position is not a wall, 2) the position
   * has not been previously visited, and 3) the position is within the
   * limits of the maze.
   * 
   * @param nxtPos The Position to check.
   * @return True if the move is valid. False, otherwise.
   */
  private boolean isMoveValid (Position nxtPos)
  {
    boolean valid = false;  // Assume that the move is not valid.

    // if the move is within the grid, not previously visited, and at 1
    if (0<=(nxtPos.getX())&&nxtPos.getX()<(grid.length)
            && 0<=(nxtPos.getY())&&nxtPos.getY()<(grid[0].length)
            && grid[nxtPos.getX()][nxtPos.getY()]==1){

      // the move is valid
      valid=true;
    }

    // return valid boolean value
    return valid;
  }
  
  /**
   * nextMove returns the next valid move or null if no move
   * is possible.
   * 
   * @param curPos - The current position in the maze.
   * @return If there is a valid move, the position of that move
   *         is returned.  If there is no valid move, null is 
   *         returned.
   */
  private Position nextMove(Position curPos)
  {
    Position newPos = new Position();

    // first move: (0, 1)
    newPos.setX(curPos.getX());
    newPos.setY(curPos.getY()+1);

    if (isMoveValid(newPos)){

      return newPos;
    }

    //second move (1,0)
    else{

      newPos.setX(curPos.getX()+1);
      newPos.setY(curPos.getY());

      if(isMoveValid(newPos)){

        return newPos;
      }

      //third move (0, -1)
      else{
        newPos.setX(curPos.getX());
        newPos.setY(newPos.getY()-1);

        if (isMoveValid(newPos)){

          return newPos;
        }

        //fourth move (-1,0)
        else{

          newPos.setX(curPos.getX()-1);
          newPos.setY(curPos.getY());

          if(isMoveValid(newPos)){

            return newPos;
          }

          // nowhere to move
          return null;

        }
      }
    }
  }


  /**
   * Returns a printable version of the maze as a string.  The maze is
   * encoded as follows:
   *
   * <ul>
   *     <li>0 - represents a wall.</li>
   *     <li>1 - represents an available, non-visited, position.</li>
   *     <li>3 - represents a non-wall position that has been visited.</li>
   *     <li>7 - represents a position on te path through the maze.</li>
   * </ul>
   * 
   * @return The a printable version of the maze.
   */
  public String toString ()
  {
    String result = "\n";
    
    for (int row=0; row < grid.length; row++)
    {
      for (int column=0; column < grid[row].length; column++)
        result += grid[row][column] + "";
      
      result += "\n";
    }
    
    return result;
  }
}


/**
 * MazeApp is an application that creates, solves, and prints a maze.
 * Code based upon the example by Lewis &amp; Chase. <br><br>
 *
 * <strong>Note:</strong> See the documentation for the the toString()
 *       method of the Maze class for the display format for a maze.
 * 
 * @author S. Sigman 
 * @version 1.0 3/26/2017
 */
public class MazeApp
{
  /**
   * Main method that creates a new maze, prints its original form, attempts to
   * solve it, and prints out its final form. <br><br>
   *
   * <strong>Note:</strong> See the documentation for the the toString()
   *       method of the Maze class for the display format for a maze.
   *
   * @param args List of command line arguments - not used in the code.
   */
  public static void main (String[] args)
  {
    Maze labyrinth = new Maze();
    
    System.out.println("The original maze.");
    System.out.println (labyrinth);
    
    if (labyrinth.traverse ())
      System.out.println ("The maze was successfully traversed!");
    else
      System.out.println ("There is no possible path.");
    
    System.out.println("The final maze.");
    System.out.println (labyrinth);
   }
}

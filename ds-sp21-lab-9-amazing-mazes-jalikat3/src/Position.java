/**
 * Position represents the x &amp; y coordinates of one position
 * in a maze.  Code from Lewis and Chase, Java Software Structures: 
 * Designing and Using Data Structures.
 * 
 * @author (S. Sigman 
 * @version 1.0 3/26/2017
 */
public class Position
{
  private int x;  // x coordinate of a cell
  private int y;  // y coordinate of a cell

  /**
    Constructs a position and sets the x &amp; y coordinates to 0,0.
   **/
  public Position ()
  {
    x = 0;
    y = 0;
  }

  /**
   * Returns the x-coordinate value of the current position.
   *
   * @return Returns the x coordinate of the position.
   **/
  public int getX()
  {
    return x;
  }

  /**
   * Returns the y-coordinate value of the current position.
   *
   * @return Returns the y coordinate of the position.
   **/
  public int getY()
  {
    return y;
  }

  /**
   * Sets the value of the current position's x-coordinate.
   * 
   * @param x - The x coordinate of a position.
   **/
  public void setX(int x)
  {
    this.x = x;
  }

  /**
   * Sets the value of the current position's y-coordinate.
   * 
   * @param y - The y coordinate of a position.
   **/  
  public void setY(int y)
  {
    this.y = y;
  }
}

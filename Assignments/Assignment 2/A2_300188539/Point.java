
public class Point {

    private int xCoordinate;
    private int yCoordinate;

    /*Constructor 
     * The parameters x and y are the coordinates
     */
    public Point(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    //Getter method, return the value of instance variable x
    public int getX() {
		    return this.xCoordinate;
    }
    
    //Getter method, return the value of instance variable y
    public int getY() {
      return this.yCoordinate;
    }
    
    //Setter method, sets the values of instance variables x and y
    public void reset(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

 }

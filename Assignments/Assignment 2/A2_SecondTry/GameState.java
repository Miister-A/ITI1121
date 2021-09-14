import java.util.Arrays;

public class GameState {
    
    public static final int FREE_CUBE = 0;
	public static final int SELECTED = 1;
	public static final int RED_CUBE = 2;
	public static final int MAX_SELECTED = 5;

    private int boardSize;
    private Point redCube;
    private int[][] board;

    public GameState(int size) { 
        this.boardSize = size;
        this.board = new int[this.boardSize][this.boardSize];

        int mouseXcoordinate = UseRandom.generateRandom(0,this.boardSize-1); //Random x-coordinate for the mouse
        int mouseYcoordinate = UseRandom.generateRandom(0,this.boardSize-1); //Random y-coordinate for the mouse
        this.setCube(mouseYcoordinate,mouseXcoordinate); //Puts the mouse at a random location

        int[] snakes = new int[MAX_SELECTED];
        for (int i=0 ; i<snakes.length ; i++) {
            int tempX = UseRandom.generateRandom(0,this.boardSize-1); //Random x-coordinate for each snake
            int tempY = UseRandom.generateRandom(0,this.boardSize-1); //Random y-coordinate for each snake
            while (tempX==mouseXcoordinate && tempY==mouseYcoordinate) { //Loop that ensures that the snakes are never put on the same cube as the mouse
                tempX = UseRandom.generateRandom(0,this.boardSize-1);
                tempY = UseRandom.generateRandom(0,this.boardSize-1);
            }
            this.select(tempX,tempY);
        }
    }

    public int getSize() {
        return this.boardSize;
    }

    public int[][] getIntegerBoard() {
        return board;
    }

    /* Getter method for the current red cube
    * return the location of the curent red cube */   
    public Point getCurrentCube() {
        return this.redCube;
    }

    /**
     * Sets the status of the cube at coordinate (i,j) to SELECTED
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void select(int i, int j) {
        this.board[j][i] = SELECTED;
    }

    /**
     * Puts the red cube at coordinate (i,j). Clears the previous location 
     * of the red cube.
     *
      * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void setCube(int i, int j) {
        for (int row = 0; row < this.board.length; row++) { //Loop that searches for the previous location of the red cube and clears it
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col]==2) {
                    this.board[row][col] = 0;
                    break;
                }
            }
        }
        this.redCube = new Point(j,i);
        this.board[j][i] = RED_CUBE;
    }

    /**
     * returns the current status (FREE_CUBE, SELECTED or RED_CUBE) of a given cube in the game
     * 
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     * return the status of the cube at location (i,j)
     */  
    public int getCurrentStatus(int i, int j) {
        return this.board[j][i];
    }

    /**
     * Prints the GameState int[][] board
     */  
    public void printIntegerBoard() {
        for (int[] row : this.board)
            System.out.println(Arrays.toString(row));
    }

    
}

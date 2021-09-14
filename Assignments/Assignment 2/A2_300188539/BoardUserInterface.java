import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BoardUserInterface extends JPanel {

    private GameState state;
    private Cube[][] actualCubeBoard;
    private GameLogic logic;

    public BoardUserInterface(GameState gameState, GameLogic gameLogic) {
        this.state = gameState;
        this.logic = gameLogic;
        this.actualCubeBoard = this.update();
    }

    //updates the status of the board's cubes instances following the game state
	  //calls setType() from the class Cube, as needed.
    //Conceptual diagram : int[][] -> Cube[][]
    public Cube[][] update() {
        int boardSize = this.state.getSize();
        Cube[][] cubeBoard = new Cube[boardSize][boardSize];

        for (int row=0; row<boardSize ; row++) { //Loop used to populate the actual Cube board and the Icon board using the int data from the GameState board
          for (int col=0; col<this.state.getBoard()[row].length; col++) {

              if (this.state.getBoard()[row][col]==0) { //Case #1 : The backbone element is 0 (empty cube) 
                Cube emptyCube = new Cube(row,col,0);
                emptyCube.setType(0);
                cubeBoard[row][col] = emptyCube;
              }

              if (this.state.getBoard()[row][col]==1) { //Case #2 : The backbone integer element is 1 (snake) 
                Cube snake = new Cube(row,col,1);
                snake.setType(1);
                cubeBoard[row][col] = snake;
              }

              if (this.state.getBoard()[row][col]==2) { //Case #3 : The backbone integer element is 2 (mouse) 
                Cube mouse = new Cube(row,col,2);
                mouse.setType(2);
                cubeBoard[row][col] = mouse;
              }
          }
        }
        return cubeBoard;
    }

    public Cube[][] getCubeBoard() {
      return actualCubeBoard;
    }
    
    public void printCubeBoard() {
      for (Cube[] row : this.actualCubeBoard)
        System.out.println(Arrays.toString(row));
    }
}
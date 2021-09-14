import javax.swing.JPanel;
import java.util.Arrays;

public class BoardUserInterface extends JPanel {
    
    private GameState state;
    private GameLogic logic;
    private Cube[][] cubeBoard;

    public BoardUserInterface(GameState gameState, GameLogic gameLogic) {
        this.state = gameState;
        this.logic = gameLogic;
        this.cubeBoard = new Cube[this.state.getSize()][this.state.getSize()];
        this.setBounds(Math.floorDiv(this.state.getSize(), 2), Math.floorDiv(this.state.getSize(), 2), this.state.getSize()*25, this.state.getSize()*25);   
    }

    public void update() { // int[][] -> Cube[][]
        int boardSize = this.state.getSize();

        for (int row=0; row<boardSize ; row++) {
            for (int col=0; col<boardSize; col++) {

                if (this.state.getIntegerBoard()[row][col]==0) { //Case #1 : The backbone element is 0 (empty cube) 
                    Cube emptyCube = new Cube(row,col,0);
                    emptyCube.setType(0);
                    this.cubeBoard[row][col] = emptyCube;
                }

                if (this.state.getIntegerBoard()[row][col]==1) { //Case #2 : The backbone integer element is 1 (snake) 
                    Cube snake = new Cube(row,col,1);
                    snake.setType(1);
                    this.cubeBoard[row][col] = snake;
                }

                if (this.state.getIntegerBoard()[row][col]==2) { //Case #3 : The backbone integer element is 2 (mouse) 
                    Cube mouse = new Cube(row,col,2);
                    mouse.setType(2);
                    this.cubeBoard[row][col] = mouse;
                }
            }
        }
    }

    public Cube[][] getCubeBoard() { 
        return this.cubeBoard;
    }

    public void printCubeBoard() {
        for (Cube[] row : this.cubeBoard)
        System.out.println(Arrays.toString(row));
    }
}

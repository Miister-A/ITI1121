import javax.swing.*;
import java.awt.*;

 /*the class GameUserInterface provides the user interface of the Game. It extends
 JFrame and lays out an instance of BoardUserInterface and  two instances of JButton: one to reset and the second the quit the game at any time.*/

public class GameUserInterface extends JFrame {

	private JButton reset;
	private JButton quit;
	private GameState gameState;
	private GameLogic gameLogic;
	private BoardUserInterface gameBUI;
	
 
    /* Constructor 
	 * initializes the board
     * takes as parameters the state of the game and the gameLogic */
    public GameUserInterface(GameState state, GameLogic logic) {
		this.reset = new JButton("Reset");
		this.quit = new JButton("Quit");
		this.gameState = state;
		this.gameLogic = logic;
		this.gameBUI = gameBUI;
    }

	public void setGameBUI(BoardUserInterface inputBUI) {
		this.gameBUI = inputBUI;
	}

	public JButton getReset(){
		return this.reset;
	}

	public JButton getQuit(){
		return this.quit;
	}

    public BoardUserInterface getBoardUserInterface() {
		return this.gameBUI;
   	}

}

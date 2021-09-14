import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.*;
import java.util.*;

//This class implements the interface ActionListener so that it is called when the player makes a move. 
//It calculates the next step of the game
//It updates state and userInterface.

public class GameLogic implements ActionListener {

    private int boardSize;
    private GameState state;
    private GameUserInterface gameInterface;
    private BoardUserInterface boardInterface;


    public GameLogic(int size) { //The parameter size is the size of the board on which the game will be played
        this.boardSize = size;
        this.state = new GameState(size);
        this.gameInterface = new GameUserInterface(this.state, this);
        this.boardInterface = this.gameInterface.getBoardUserInterface();
    }

    /**
     * Starts the game
     */
    public void start() {
        this.gameInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameInterface.setSize(this.boardSize*50,this.boardSize*50);
        this.gameInterface.setLayout(new GridLayout(this.boardSize,this.boardSize,5,5));

        for (int row=0; row<this.boardSize ; row++) { //Loop used to add all JButtons (cubes) to the JFrame (Game User Interfaces)
            for (int col=0; col<this.boardSize; col++) {
                this.gameInterface.add(this.boardInterface.getCubeBoard()[row][col]);
            }
        }
        
        this.gameInterface.setVisible(true);
    }
 
    /**
     * resets the game
     */
    public void reset() {
	// YOUR CODE HERE
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed" + e.getActionCommand());
        ((JButton)e.getSource()).setEnabled(true);
    }

 
}


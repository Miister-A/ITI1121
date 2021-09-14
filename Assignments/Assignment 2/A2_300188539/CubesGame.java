import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CubesGame {
	public static void main (String[] args){
		GameState testState = new GameState(UseRandom.generateRandom(4,20));
		GameLogic testLogic = new GameLogic(testState.getSize());
		GameUserInterface testGUI = new GameUserInterface(testState,testLogic);
		BoardUserInterface testBUI = testGUI.getBoardUserInterface();

		testState.printIntegerBoard();
		testBUI.printCubeBoard();

		testLogic.start();
	}
}
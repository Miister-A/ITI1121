import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

/********************************************************************
 * The Cube is a type of JButton that represents a cube in the game 
*********************************************************************/

public class Cube extends JButton {

    private int numberOfRows;
    private int numberOfColumns;
    private int cubeType;

    public Cube(int row, int column, int type) {
        this.numberOfRows = row;
        this.numberOfColumns = column;
        this.cubeType = type; 
    }
	
    public void setType(int type) {
        String currentFileDirectory = System.getProperty("user.dir"); //Retrieves the current directory of this class
        String iconsDirectory = currentFileDirectory+"\\"+"icons"+"\\"; //Adds the necessary to access the icons folder within the current directory

        if (type==0) {
            Icon emptyIcon = new ImageIcon(iconsDirectory+"square-0.png"); //Adds the name of the empty cube image to the general string directory
            this.setIcon(emptyIcon); //Sets the empty icon to the current instance of the cube class
        }

        if (type==1) {
            Icon snakeIcon = new ImageIcon(iconsDirectory+"square-1.png"); //Adds the name of the snake image to the general string directory
            this.setIcon(snakeIcon); //Sets the snake icon to the current instance of the cube class
        }

        if (type==2) {
            Icon mouseIcon = new ImageIcon(iconsDirectory+"square-2.png"); //Adds the name of the mouse image to the general string directory
            this.setIcon(mouseIcon); //Sets the mouse icon to the current instance of the cube class
        }
    }

    // Getter method for the attribute row.
    public int getRow() {
        return this.numberOfRows;
    }

    //Getter method for the attribute column.
    public int getColumn() {
        return this.numberOfColumns;
    }

    public int getType() {
        return this.cubeType;
    }

    @Override
    public String toString() {
        String output="";
        if (this.cubeType==0) {
            output="Empty";
        }
        if (this.cubeType==1) {
            output="Snake";
        }
        if (this.cubeType==2) {
            output="Mouse";
        }
        return output;
    }
}

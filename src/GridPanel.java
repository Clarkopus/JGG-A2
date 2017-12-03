import javax.swing.*;
import java.awt.*;

// Class that draws a grid of 20*20 squares
public class GridPanel extends JPanel {

    // Every object that is rendered in the grid uses a 2D array
    // If the element =1 then that element is to be printed
   public  Shape[][] cords = new Shape[20][20];
   public Shape player;
   Application app;
   Logic gm;                                                                                                            // Create a logic object called game manager(gm for short).
    boolean gameStarted = false;
    public GridPanel(Application app){
        super();
        this.app = app;
        gm = new Logic(this.app); // Black magic fuckery. Don't touch!
        Shape oval = new Circle(40,1,1);
        gm.addObject(oval);
    }

    // Method to paint the board


    // Calls the JPanel's paint component and then adds my custom drawing method
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(gameStarted) {
            gm.paint(g);
        }

    }
    /*Method used to add objects to the cords array*/
    public void addObjectToCords(Shape object){
        cords[object.xCord][object.yCord] = object; // Add the object to the 2D array
    }



}

/* - TODO -
* Work on new rendering method
* Add static objects to collect
* Slowly add objectives
* Finish all 60% tasks in the assignment brief
* Document methods
* Clean code*/

/* - HOWTO -
* 1- Create an object that is either a sub class or of type shape
* 2- Give that shape cords and a size
* 3- Add the shape to the grid using the addObjectToCords() method
* 4- Shape prints out inside the paint() method
* 5- Every time the player moves the screen is refreshed*/



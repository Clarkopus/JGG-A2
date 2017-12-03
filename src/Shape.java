
/* Abstract shape class
* Used to create different shapes that are based on this Sub class
* Created by Guy H Clark*/

import java.awt.*;

public abstract class Shape {

    public int width;
    public int height;
    public int xCord;
    public int yCord;

    public Shape(int width, int height, int xCord, int yCord){

        this.width = width;
        this.height = height;
        this.xCord = xCord;
        this.yCord = yCord;
    }
    public Shape(int x, int y){ // non-argument constructor

        this.xCord =x;
        this.yCord =y;
    }

    // Method used to test if the graphic renders

    // Method used to draw the graphic, requests the cords from the pain method inside GridPanel
    abstract void draw(Graphics g, int xCordA, int yCordA);
    // Create get and set methods that allow read/write access to the protected variables

}

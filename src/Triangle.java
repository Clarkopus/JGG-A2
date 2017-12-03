import java.awt.Graphics;
/* The triangle class has a unique constructor that takes in the amount of corners,
*  the x cord on the grid and the y cord of the grid to calculate where to actually
*  print it.
*
* This allows the program to only have to provide the x and y cords and then will
* calculate the actual x and y cord to print onto the screen*/
public class Triangle extends Shape{


    int corners;
    int cornerArrayX[] = new int[3];
    int cornerArrayY[] = new int[3];

    public Triangle(int corners, int x, int y){
        super(x,y);
        this.corners = corners;
                                                                                                                        // Calculate the xcords for each corner
        this.cornerArrayX[0] = ((x+1) * 40);
        this.cornerArrayX[1] = ((x+1 * 2) * 40);
        this.cornerArrayX[2] = (cornerArrayX[1] - 20);

        this.cornerArrayY[0] = ((y) * 40);                                                                              // Calculate the ycords for each corner
        this.cornerArrayY[1] = ((y) *40);
        this.cornerArrayY[2] = (y+1) * 40;
        System.out.println(this.cornerArrayX[0] + " " + this.cornerArrayX[1] + " " + cornerArrayX[2]);                  // Printing for testing purposes
    }

    public void draw(Graphics G){

        G.fillPolygon(cornerArrayX,cornerArrayY,corners);                                                               // Draw a polygon to the grid using the pre-calculated array's
    }

    public void draw(Graphics G, int x, int Y){}
}

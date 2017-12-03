import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    int size;
    public Circle(int size, int xCord, int yCord){

        super(size,size,xCord,yCord);
        this.size = size;
        height = size;
        width = size;

    }

    public void draw(Graphics g, int xCordA, int yCordA){

        Graphics2D g2 = (Graphics2D) g;
        g.fillOval(xCordA,yCordA,size,size);
    }

}

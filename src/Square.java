import java.awt.*;

public class Square extends Shape {

    public Square(int width, int height, int xCord, int yCord) {
        super(width, height,xCord,yCord);
    }
    // Used for testing if it actually draws
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g.fillRect(xCord,yCord,height,width);

    }

    public void draw(Graphics g, int xCordA,int yCordA){
        g.fillRect(xCordA,yCordA,height,width);
    }

}

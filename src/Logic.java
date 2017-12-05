import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/* The logic class is used to deal with all game based logic such
 * as movement, object spawning, score keeping and other important
  * game based logic*/

public class Logic {
    int score;                                                                                                          // Score variable for keeping player score
    Square player;
    Application app;
    // Used to keep track of all objects inside the list
    ArrayList<Shape> objectList = new ArrayList<>();
    Shape[][] cords = new Shape[20][20];
    Color[] colorArray = new Color[]{Color.RED,Color.GREEN, Color.BLUE};
    public Triangle tri;
    ScoreHandler sc = new ScoreHandler();
    boolean check = false;

    public Logic(Application app){
        this.app = app;
        player = new Square(40,40,5,10);
        objectList.add(player);
        addObject(player);
        tri = new Triangle(3,7,9);
        addObject(tri);
        generateMobs(6);
        score = 0;
    }

    public void addObject(Shape s){
                                                                                                                        // Set the shape to be set at its own cords
        cords[s.xCord][s.yCord] = s;
    }

    public void paint(Graphics g){
        Graphics2D  g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        int xCord =0;
        int yCord =0;
        for(int i=0; i<20;i++){
            for(int x=0;x<20;x++){
                xCord +=40;
                Shape objectToDraw = cords[x][i];
                // If the shape isn't null decide what to print
                g.setColor(Color.black);
                tri.draw(g);
                if(objectToDraw != null) {
                    if(objectToDraw instanceof Square) {
                        g2.setColor(colorArray[2]);
                        objectToDraw.draw(g, xCord, yCord);
                    }
                    else {
                        g2.setColor(Color.BLACK);
                        objectToDraw.draw(g,xCord,yCord);
                    }
                }
                // Else just continue to print the standard grid
                else{
                    g2.setColor(Color.WHITE);
                    g2.fillRect(xCord,yCord,40,40);
                    g2.setColor(Color.BLUE);
                    g2.drawRect(xCord,yCord,40,40);
                    continue;
                }
            }

            yCord+=40;
            xCord =0;
        }
    }

    // Used to update the position of an object. Curently only works on player - might change this later
    public void updateObjectPos(String direction){
        //Store the old cords
        int oldX = player.xCord;
        int oldY = player.yCord;
        int newX;
        int newY;
        try {
            //if the direction is right
            if (direction.equals("Right")) {
                newX = (oldX +1);
                newY = oldY;
                // if the old x cords + 1 is larger than the size of the array throw an exception
                if(newX >= 20) throw new ArrayIndexOutOfBoundsException("Sorry, can't move that far!");
                checkForObject(newX,newY);
                cords[oldX][oldY] = null;
                // Create a new shape object with the new cords
                Square playerCopy = new Square(40, 40, newX, newY);
                // Set player to equal to the new object
                player = playerCopy;
            }

            else if (direction.equals("Left")) {
                newX = (oldX -1);
                newY = (oldY);
                if(newX< 0) throw new ArrayIndexOutOfBoundsException("Sorry, can't move that far!");
                checkForObject(newX,newY);
                cords[oldX][oldY] = null;
                Square playerCopy = new Square(40, 40, newX, newY);
                player = playerCopy;
            }

            else if(direction.equals("Up")) {
                newX = oldX;
                newY = (oldY -1);
                if(newY< 0) throw new ArrayIndexOutOfBoundsException("Sorry, can't move that far!");
                checkForObject(newX,newY);
                cords[oldX][oldY] = null;
                Square playerCopy = new Square(40,40,newX,newY );
                player = playerCopy;
            }

            else if(direction.equals("Down")){
                newX = oldX;
                newY = (oldY + 1);
                if(newY >= 20) throw new ArrayIndexOutOfBoundsException("Sorry, can't move that far!");
                checkForObject(newX,newY);
                cords[oldX][oldY] = null;
                Square playerCopy = new Square(40,40,newX,newY);
                player = playerCopy;

            }

        }

        catch(ArrayIndexOutOfBoundsException m){
            JOptionPane.showMessageDialog(null,m.getMessage());
        }

        finally {
            addObject(player);
            if(!check) {
                checkGameState();
            }
            app.repaintThings();

        }

    }
    // Used to generate different characters
    /* Attempts to spawn a  mob at a position depending on the "amount to spawn" variable
    *  If an object (of type shape) is at the position the mob wishes to spawn, keep changing the cords*/
    private void generateMobs(int amountToSpawn){

        int yPos =0;
        int xPos = 0;
        boolean posOcupied =true;

        for(int i=0; i<amountToSpawn;i++){                                                                              // Loop as many times as the condition allows
            while(posOcupied){
                                                                                                                        // Keep generating numbers until they are less than 20
                xPos = generateRandCord();
                yPos = generateRandCord();
                System.out.println("cord: " + xPos);

                Circle mob = new Circle(40, xPos, yPos);                                                         // Create a mob object at the random position
                if(cords[xPos][yPos] != null){                                                                          // If the position at the cords isn't free, re-do the loop
                    continue;
                }

                else {                                                                                                  // Else, add the new object to both the cords and the Object list
                    objectList.add(mob);
                    addObject(mob);
                    posOcupied = false;
                    System.out.println("Spawned mob at: "+ xPos +" "+yPos);
                }
            }

            posOcupied = true;                                                                                          // After a sucesfull loop, set the condition back to true
        }
    }
    /* used to check if the player object collides with another object
     * by using the player's cords as a reference.
     * Also used to update the current score */
    private void checkForObject(int xCord, int yCord){

        if(cords[xCord][yCord] instanceof Circle){
            System.out.println("Mob dected at [" + xCord + "][" + yCord + "]");
            objectList.remove(cords[xCord][yCord]);                                                                     // Remove the object from the collection where the player now is
            score = Integer.parseInt(app.currentScore.getText());
            score +=1;
            app.currentScore.setText(Integer.toString(score));
        }

        else{
            System.out.println("No mobs mobs detected at position [" + xCord + "][" + yCord + "]");                     // debug purposes. Remove when finished
        }

    }
    /* This method is used to move a mob every time the player moves
    * */
    private void moveMobs(ArrayList<Shape> slist){

        for(Shape s: slist){
            if(s instanceof Circle){
                int oldX = s.xCord;
                int oldY = s.yCord;


            }
        }
    }
    /* Will check if the game state is finished or not*/
    private void checkGameState(){
        if(objectList.size() == 1){
            System.out.println("No mobs dected on screen, ending game!");
            sc.addScore("Player", app.currentScore.getText());
            check = true;
        }
    }

    private int generateRandCord(){
    int cord =0;
        while(true) {
            double posRand;
            posRand = Math.random() * 20 + 1;
            cord = (int) posRand;
            if(cord <20){
                return cord;
            }
        }
    }
}


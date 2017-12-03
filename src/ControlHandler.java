import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*Control handler class -
 * Used to keep track of the user input when a button is pressed
 */
public class ControlHandler implements KeyListener {

    Application app;
    public ControlHandler(Application app){
        this.app = app;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
    /* Used to check if a key is pressed inside the Jframe
     * and calls the respected functions depending on the
     * active key press*/
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        // Convert the key code into an int value
        int keyCode = keyEvent.getKeyCode();
        switch(keyCode){
            // If the key code is either one of these update the player position
            case KeyEvent.VK_RIGHT :
                app.squareGridPanel.gm.updateObjectPos("Right");
                break;
            case KeyEvent.VK_D:
                app.squareGridPanel.gm.updateObjectPos("Right");
                break;

            case KeyEvent.VK_LEFT :
                app.squareGridPanel.gm.updateObjectPos("Left");
                break;
            case KeyEvent.VK_A:
                app.squareGridPanel.gm.updateObjectPos("Left");
                break;

            case KeyEvent.VK_UP :
                app.squareGridPanel.gm.updateObjectPos("Up");
                break;
            case KeyEvent.VK_W:
                app.squareGridPanel.gm.updateObjectPos("Up");
                break;

            case KeyEvent.VK_DOWN:
                app.squareGridPanel.gm.updateObjectPos("Down");
                break;
            case KeyEvent.VK_S:
                app.squareGridPanel.gm.updateObjectPos("Down");



        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}


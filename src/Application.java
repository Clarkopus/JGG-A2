import sun.applet.AppletListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

// Application class used to store all UI code
public class Application extends JFrame {

    GridPanel squareGridPanel;
    JButton reset;
    JPanel gameControlPanel;
    JTextField currentScore;
    JLabel scoreLabel;
    JButton start;
    private Thread T;
    private String threadName = "graphics_T";

    public Application(){

        setSize(900,900);
        setTitle("CE203 A1 - Guy H Clark - 0000999090");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* init component variables here*/
        // JPanels go here
        squareGridPanel = new GridPanel(this);
        addKeyListener(new ControlHandler(this));
        gameControlPanel = new JPanel();
        // JButtons go here
        reset = new JButton("Reset");
        start = new JButton("Start");
        start.addActionListener(new buttonHandler(this));
        // JLables go here
        scoreLabel = new JLabel("Current high score");
        // JTextfield/JTextArea go here
        currentScore = new JTextField(6);
        currentScore.setText("0");
        currentScore.setEnabled(false);

        /* Add components to containers here*/
        // JPanel adding goes here
        gameControlPanel.add(scoreLabel);
        gameControlPanel.add(currentScore);
        gameControlPanel.add(reset);
        gameControlPanel.add(start);
        //JFrame adding goes here
        add(squareGridPanel);
        add(gameControlPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
        public void repaintThings(){
            squareGridPanel.repaint();
        }
}

class buttonHandler implements ActionListener{
    Application app;
    public buttonHandler(Application app){
        this.app = app;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        app.squareGridPanel.gameStarted = true;
        app.setFocusable(true);
        app.requestFocus();
        app.repaintThings();
    }
}

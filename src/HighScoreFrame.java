import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/* Class used to create the high score's screen */
public class HighScoreFrame extends JFrame {

    Application app;
    ArrayList<String> scoreList;
    ScoreHandler sh = new ScoreHandler();
    JLabel[] labelList;

    public HighScoreFrame(Application app){
        this.app = app;

        setSize(400,700);
        setTitle("High Score screen");
        generateScores();
        setVisible(true);


    }
    /* Method used to generate the JLables that display the scores
     * Uses an array of JLables and sets their text to the values given
      * by the ScoreHandler object (named sh for short)*/
    public void generateScores(){

        scoreList = sh.readScores();
        labelList = new JLabel[scoreList.size()];
        this.setLayout(new GridLayout(scoreList.size(),1));
        for(int i=0;i<scoreList.size();i++){
            labelList[i] = new JLabel(scoreList.get(i));
            this.add(labelList[i]);
        }

    }

}

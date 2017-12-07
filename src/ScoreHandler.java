import java.io.*;
import java.util.ArrayList;

public class ScoreHandler {

    private BufferedWriter bw;
    private FileWriter fw;
    private BufferedReader br;
    private File f;
    private FileReader fr;

    public ScoreHandler(){

    }
    /* Writes to the file "scores.txt" with the current player's score*/
    private void writeToFile(String contents){

        try{

            fw = new FileWriter("scores.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(contents + "\n");
            System.out.println("File printed - " + contents);

        }catch(IOException e){
        System.out.println(e.getMessage());
        System.out.println("Score file failed to be written to");
        }

        finally{
            try {
                bw.close();
                fw.close();
            }
            catch(IOException e){
                System.out.println("Sorry, error happened!");
                System.out.println(e.getMessage());
            }
        }
    }

    public void addScore(String name, String score){

        String finalString ="";

        finalString += (name + ": " + score);
        writeToFile(finalString);
    }
    /* Used to read the scores from the "scores.txt" file. Returns an ArrayList
    * with the string values of the player name and score number of each player*/
    public ArrayList<String> readScores(){
        ArrayList<String> scoreList = new ArrayList<>();
        try {
            f = new File("scores.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String currentLine;

            while((currentLine = br.readLine())!=null){
                System.out.println(currentLine);
                scoreList.add(currentLine);
            }
        }
        catch(IOException e){
            System.out.println("Sorry, an IO exception has been dectected");
            System.out.println(e.getMessage());
        }

        return scoreList;
    }

}

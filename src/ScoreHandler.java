import java.io.*;

public class ScoreHandler {

    private BufferedWriter bw;
    private FileWriter fw;
    private String fName;

    public ScoreHandler(){

    }

    private void writeToFile(String contents){

        try{

            fw = new FileWriter("scores.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(contents);
            System.out.println("File printed - " + contents);

        }catch(IOException e){
        System.out.println(e.getMessage());
        System.out.println("Score file failed to be written to");
        }

        finally{
            try {
                fw.close();
                bw.close();
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

}

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.*;

public class TopScores extends GridPane {

    public Button playAgain;

    public TopScores(){

        Label gameOver = new Label("Game over. \n Toplist: ");
        gameOver.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 30));
        playAgain = new Button("Spill igjen");
        playAgain.setStyle("-fx-font: 14 arial; -fx-base: #008B8B; -fx-font-size: 12px;" +
                "-fx-text-fill:white; -fx-font-family: \"Arial Narrow\";" +
                "    -fx-font-weight: bold;");
        playAgain.setMinWidth(100);
        playAgain.setMinHeight(35);
        playAgain.setMaxWidth(170);
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.add(gameOver, 0,0);
        this.add(playAgain, 0, 999);
        this.setPadding(new Insets(100, 0, 0,225));

    }

    public void writeToScoreList(Player player){

        FileOutputStream fileOut;
        ObjectOutputStream out;

        try {
            fileOut = new FileOutputStream("scores", true);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        writeFromScoreList();
    }

    public void writeFromScoreList(){

        FileInputStream fileIn;

        try {
            fileIn = new FileInputStream("scores");

            try {
                int count = 1;
                for (; ; ) {
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Player player = (Player) in.readObject();
                    Label scorer = new Label(count + ": " + player);
                    scorer.setPadding(new Insets(10, 0, 10, 0));
                    setStyle(scorer);
                    this.add(scorer, 0, count);
                    count++;
                }


            } catch (EOFException e) {
                fileIn.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch(Exception e){}
    }

    private void setStyle(Label label){
        label.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 18));
    }

}

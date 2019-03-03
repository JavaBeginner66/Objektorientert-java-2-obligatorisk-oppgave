import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.*;
import java.util.Collections;

/**
 * Klasse oppretter ett Gameover panel som viser
 * en topp 10 liste over høyeste scorende spillere
 */

public class TopScores extends GridPane {

    public final Button playAgain;

    private ObservableList<Player> scoreList = FXCollections.observableArrayList();

    /**
     * Metoden plasserer og styler labels
     */
    public TopScores(){

        final Label gameOver = new Label("Game over. \n Toplist: ");
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
        this.setPadding(new Insets(100, 0, 0,150));

    }

    /**
     * Metoden skriver et nytt spiller-objekt til score-fil
     * for hver gang spiller når ''Game over''.
     */
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

    /**
     * Metoden skriver spiller-objekt fra score-fil og
     * legger dem inn i scoreList tabellen.
     */
    public void writeFromScoreList(){

        FileInputStream fileIn;

        try {
            fileIn = new FileInputStream("scores");

            try {

                for (; ;) {
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Player player = (Player) in.readObject();
                    scoreList.add(player);
                }

            } catch (EOFException e) {
                fileIn.close();
                displayTopList();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch(Exception e){}
    }

    /**
     * Metoden sorterer spiller-objekt lista på score, og
     * legger den på panelet.
     */
    private void displayTopList(){

        Collections.sort(scoreList);
        Collections.reverse(scoreList);

        for(int i = 0; i<10; i++){
            final Label scorer = new Label(i+1 + ": " + scoreList.get(i));
            scorer.setPadding(new Insets(10, 0, 10, 0));
            setStyle(scorer);
            this.add(scorer, 0, i+1);
        }
    }

    /**
     * Metoden beskriver skrifts-stil.
     */
    private void setStyle(Label label){
        label.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 18));
    }

}

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Klassen viser (tid?), score og baller igjen
 * oppe i venstre hjørne. Panelet blir satt inn med
 * setTop() av hovedpanelet.
 */

public class ScoreGui extends VBox {

    public static Label labelTime;
    public static Label labelScore;
    public static Label ballsLeft;

    private GameBoard board;

    private int score;

    public ScoreGui(GameBoard board){
        this.board = board;
        setup();
    }

    /**
     * Metoden setter opp og plaserer labels.
     */
    private void setup(){
        labelTime = new Label("Time: ");
        ballsLeft = new Label();
        labelScore = new Label("Score: ");
        labelScore.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 20));
        ballsLeft.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 20));
        labelTime.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.getChildren().addAll(labelTime, labelScore, ballsLeft);
        this.setPadding(new Insets(10,5,5,15));
    }

    /**
     * Standard get og set metoder
     */
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

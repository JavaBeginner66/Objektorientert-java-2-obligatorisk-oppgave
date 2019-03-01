import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ScoreGui extends VBox {

    private GameBoard board;

    public static Label labelTime;
    public static Label labelScore;
    public static Label ballsLeft;

    private int score;

    public ScoreGui(GameBoard board){
        this.board = board;
        setup();
    }

    private void setup(){
        labelTime = new Label();
        ballsLeft = new Label("Balls: ");
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

    public GameBoard getBoard() {
        return board;
    }


    public Label getLabelTime() {
        return labelTime;
    }


    public Label getLabelScore() {
        return labelScore;
    }

    public Label getBallsLeft() {
        return ballsLeft;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

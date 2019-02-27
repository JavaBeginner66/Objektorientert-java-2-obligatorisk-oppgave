import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ScoreGui extends VBox {

    private GameManager board;
    private Label labelTime;
    private Label labelScore;
    private Label ballsLeft;

    public ScoreGui(GameManager board){
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

    public GameManager getBoard() {
        return board;
    }

    public void setBoard(GameManager board) {
        this.board = board;
    }

    public Label getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(Label labelTime) {
        this.labelTime = labelTime;
    }

    public Label getLabelScore() {
        return labelScore;
    }

    public void setLabelScore(Label labelScore) {
        this.labelScore = labelScore;
    }

    public Label getBallsLeft() {
        return ballsLeft;
    }

    public void setBallsLeft(Label ballsLeft) {
        this.ballsLeft = ballsLeft;
    }
}

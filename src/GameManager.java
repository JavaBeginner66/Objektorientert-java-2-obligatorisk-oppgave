import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.awt.*;


public class GameManager extends Application {

    private BorderPane mainPane;
    private Ball ball;
    private Design design;
    private ScoreGui score;

    boolean gameRunning;

    @Override
    public void start(Stage stage) {
        gameRunning = true;

        mainPane = new BorderPane();
        ball = new Ball(70, 50, 20, this);
        design = new Design(this);
        score = new ScoreGui(this);

        mainPane.setTop(score);

        mainPane.getChildren().addAll(ball);

        //startTimer();

        Scene scene = new Scene(mainPane, 650, 950);
        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }

    public BorderPane getMainPane(){
        return mainPane;
    }

    public Ball getBall() {
        return ball;
    }

    public Design getDesign() {
        return design;
    }

    public static void main(String args[]){
        launch(args);
    }

    public ScoreGui getScoreGui() {
        return score;
    }
}

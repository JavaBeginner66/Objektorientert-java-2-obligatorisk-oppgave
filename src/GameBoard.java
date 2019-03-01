import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.awt.*;


public class GameBoard extends Application {

    //public final static AudioClip sound = new AudioClip("https://www.pacdv.com/sounds/people_sound_effects/baby-sneezing-1.wav");

    private BorderPane mainPane;
    private Ball ball;
    private Design design;
    private ScoreGui score;

    @Override
    public void start(Stage stage) {
        // Sende alt inn til gamemanager
        mainPane = new BorderPane();
        design = new Design(this);
        score = new ScoreGui(this);
        GameManager manager = new GameManager(this);

        mainPane.setTop(score);

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

    public Ball createBall(){
        Ball ball = new Ball(600, 800, 20, this);
        mainPane.getChildren().addAll(ball);
        return ball;
    }
}

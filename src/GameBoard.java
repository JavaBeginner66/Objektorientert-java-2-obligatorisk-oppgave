import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.awt.*;
import javafx.event.Event;
import javafx.util.Duration;


public class GameBoard extends Application{

    //public final static AudioClip sound = new AudioClip("https://www.pacdv.com/sounds/people_sound_effects/baby-sneezing-1.wav");

    private BorderPane mainPane;
    private Design design;
    private ScoreGui score;
    private GameManager manager;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        // Sende alt inn til gamemanager
        mainPane = new BorderPane();
        design = new Design(this);
        score = new ScoreGui(this);

        mainPane.setTop(score);
        scene = new Scene(mainPane, 650, 950);
        manager = new GameManager(this);
        flipperControll();

        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }

    public void flipperControll() {

        RotateTransition rt1 = new RotateTransition(Duration.millis(100), (design.f1));
        rt1.setFromAngle(0);
        rt1.setToAngle(-80);
        rt1.setCycleCount(2);
        rt1.setAutoReverse(true);

        RotateTransition rt2 = new RotateTransition(Duration.millis(100), (design.f2));
        rt2.setFromAngle(0);
        rt2.setToAngle(80);
        rt2.setCycleCount(2);
        rt2.setAutoReverse(true);

            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.A) {
                        rt1.play();
                    }
                    if (event.getCode() == KeyCode.D) {
                        rt2.play();
                    }
                }
            });
        }


    protected void moveBall(Ball ball) {

        // Spill-loopen

        if(GameManager.gameRunning) {

            // Sjekke om ball treffer ytre boks
            if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > mainPane.getWidth() - ball.getRadius()) {
                ball.getVelocity().setX(-ball.getVelocity().getX());
            }

            if (ball.getCenterY() <= ball.getRadius()) {
                ball.getVelocity().setY(-(ball.getVelocity().getY()));
            }

            if(ball.getCenterY() >= mainPane.getHeight() - ball.getRadius()){
                GameManager.gameRunning = false;
                mainPane.getChildren().remove(ball);
                manager.newBallConditionCheck();
            }

            // endre position på ball
            ball.newVelocity(ball.getVelocity());
            ball.getVelocity().setY(ball.getVelocity().getY() + ball.getGravity());

            // Gjøre referansen kortere etterhvert
            for (int i = 0; i < design.getObjectArray().size(); i++) {
                if (design.getObjectArray().get(i).detectCollision(ball)) {
                    design.getObjectArray().get(i).collisionEvent(ball);
                }
            }
            // Oppdaterer score hver frame
            ScoreGui.labelScore.setText("Score: " + score.getScore());
        }
    }



    public BorderPane getMainPane(){
        return mainPane;
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

    public GameManager getManager() {
        return manager;
    }

    public Scene getScene() {
        return scene;
    }
}

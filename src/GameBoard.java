import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.awt.*;
import javafx.event.Event;


public class GameBoard extends Application{

    //public final static AudioClip sound = new AudioClip("https://www.pacdv.com/sounds/people_sound_effects/baby-sneezing-1.wav");

    private BorderPane mainPane;
    private Design design;
    private ScoreGui score;
    private GameManager manager;

    @Override
    public void start(Stage stage) {
        // Sende alt inn til gamemanager
        mainPane = new BorderPane();
        design = new Design(this);
        score = new ScoreGui(this);
        manager = new GameManager(this);

        mainPane.setTop(score);


        Scene scene = new Scene(mainPane, 650, 950);

        flipperControll(scene);

        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }

    private void flipperControll(Scene scene){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.print(event);
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
                manager.newBall();
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

}

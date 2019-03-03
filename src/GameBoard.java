import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Programmet simulerer en simpel versjon av spiller ''Pinball''
 * der spilleren skal prøve å holde en ball i spill ved hjelp av
 * ''Flippers'' og ulike hindre.
 *
 * Klassen er ansvarlig for å starte applikasjonen, i tilleg til
 * å kjøre spill-loopen som sier hvordan ballen skal
 * oppføre seg. Klassen har også ansvar for Flipper-kontroller.
 *
 * @authors Jan Andreas Sletta, Torbjørn Lunde Olaisen, Sindre Haavaldsen, Kristian Kløvstad
 * @version 1.0
 * @since   27.02.2019
 */

public class GameBoard extends Application {

    //public final static AudioClip sound = new AudioClip("https://www.pacdv.com/sounds/people_sound_effects/baby-sneezing-1.wav");

    private BorderPane mainPane;
    private Design design;
    private ScoreGui score;
    private GameManager manager;
    private Scene scene;

    /**
     * Metoden legger opp ulike panel/klasser
     */
    @Override
    public void start(Stage stage) {

        mainPane = new BorderPane();
        design = new Design(this);
        score = new ScoreGui(this);
        manager = new GameManager(this);

        mainPane.setTop(score);
        scene = new Scene(mainPane, 650, 950);

        flipperControll();

        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoden legger til en rotasjons-animasjon for flippers
     * Når bruker trykker ''A'' for venstre flipper, eller ''D'' for høyre flipper.
     */
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

    /**
     * Metoden kontrollerer hvordan ballen skal oppføre seg hver gang
     * den blir oppdatert gjennom en Timeline animasjon
     */
    protected void moveBall(Ball ball) {

        if(GameManager.gameRunning) {

            // Sjekke om ball treffer ytre boks
            if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > mainPane.getWidth() - ball.getRadius()) {
                ball.getVelocity().setX(-(ball.getVelocity().getX()));
            }

            if (ball.getCenterY() < ball.getRadius()) {
                ball.getVelocity().setY(-(ball.getVelocity().getY()));
            }

            if(ball.getCenterY() > mainPane.getHeight() - ball.getRadius()){
                GameManager.gameRunning = false;
                mainPane.getChildren().remove(ball);
                manager.gameStateCheck();
            }

            // endre position på ball
            ball.newVelocity(ball.getVelocity());
            ball.getVelocity().setY(ball.getVelocity().getY() + ball.getGravity());


            // Sjekker for kollisjon gjennom grensesnitt
            for (int i = 0; i < design.getObjectArray().size(); i++) {
                if (design.getObjectArray().get(i).detectCollision(ball)) {
                    design.getObjectArray().get(i).collisionEvent(ball);
                }
            }
            // Oppdaterer score hver frame
            ScoreGui.labelScore.setText("Score: " + score.getScore());
            // Oppdaterer timer hver frame
            ScoreGui.labelTime.setText("Time: " + Events.count);
            // Plusser mengden tid til på score
            score.setScore(score.getScore()+Events.count);
        }
    }


    /**
     * Standard get og set metoder
     */

    public BorderPane getMainPane(){
        return mainPane;
    }

    public ScoreGui getScoreGui() {
        return score;
    }


    public static void main(String args[]){
        launch(args);
    }
}

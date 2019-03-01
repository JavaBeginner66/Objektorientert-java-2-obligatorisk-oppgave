import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameManager {

    public static boolean gameRunning;
    public static boolean gameOver;

    public GameBoard board;

    public GameManager(GameBoard board){
        this.board = board;
        gameRunning = false;
        newBall();
    }

    public void newBall(){

        Ball ball = new Ball(600, 800, 20, board);
        board.getMainPane().getChildren().add(ball);

        Animation animation = new Timeline(new KeyFrame(Duration.millis(30), e -> board.moveBall(ball)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        ball.setOnMouseClicked(e -> gameRunning = true);
        System.out.print("Newball");
    }

}

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameManager {

    public static boolean gameRunning;
    public static boolean gameOver;

    public GameBoard board;
    public Ball ball;
    private Player player;

    private Animation animation;

    public GameManager(GameBoard board){
        this.board = board;
        player = new Player();
        gameRunning = false;
        gameOver = false;
        newBall();
    }

    public void newBall(){
        if(animation != null)
            animation.stop();

        if(!ballsLeft())
            gameOver = true;

        ball = new Ball(600, 800, 20, board);
        board.getMainPane().getChildren().add(ball);

        animation = new Timeline(new KeyFrame(Duration.millis(30), e -> board.moveBall(ball)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        ball.setOnMouseClicked(e -> gameRunning = true);
    }

    private boolean ballsLeft(){

        ScoreGui.ballsLeft.setText("Balls: " + player.getBalls());
        player.setBalls(player.getBalls()-1);

        return!(player.getBalls() < 0);

    }


}

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.swing.*;

public class GameManager {

    public static boolean gameRunning;
    public static boolean gameOver;

    public GameBoard board;
    public Ball ball;
    private Player player;

    private Animation animation;

    private TopScores scoreScreen;

    public GameManager(GameBoard board){
        this.board = board;
        gameRunning = false;
        gameOver = false;
        newGame();
    }

    private void gameOver(){

        scoreScreen = new TopScores();
        board.getMainPane().setCenter(scoreScreen);
        scoreScreen.playAgain.setOnAction(e -> {
            scoreScreen.scoreListManager( player/* send inn her */);
            board.getMainPane().setCenter(null);
            newGame();
        });
    }

    private void newGame(){
        player = new Player(enterName());
        ScoreGui.ballsLeft.setText("Balls: " + player.getBalls());
        gameOver = false;
        nextBall();
    }

    private void nextBall(){
        ball = new Ball(600, 800, 20, board);
        board.getMainPane().getChildren().add(ball);

        animation = new Timeline(new KeyFrame(Duration.millis(30), e -> board.moveBall(ball)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        ball.setOnMouseClicked(e -> gameRunning = true);
    }

    public void newBallConditionCheck(){
        if(animation != null)
            animation.stop();

        if(!ballsLeft()) {
            gameOver = true;
            gameOver();
        }

        if(!gameOver)
            nextBall();
    }

    private boolean ballsLeft(){

        player.setBalls(player.getBalls()-1);
        ScoreGui.ballsLeft.setText("Balls: " + player.getBalls());

        return!(player.getBalls() <= 0);
    }

    // Skulle gjerne lagd en javafx gui for denne, men for lite tid
    private String enterName(){
        String name = JOptionPane.showInputDialog("Navn:");
        if(name.equals("")){
            name = "Anonym";
        }
        return name;
    }


}

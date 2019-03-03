import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.swing.*;

/**
 * Klassen styrer spill-status til en hver tid.
 * Sjekk av tilstant styres primært gjennom
 * statiske variabler gameRunning og gameOver.
 *
 * gameRunning betyr at ballen er i spill,
 * mens gameOver betyr at spiller ikke har flere
 * baller igjen, og en toppliste vil vises.
 *
 * I en situasjon der spiller har baller igjen,
 * men ikke løser den ut, vil spillet være i en
 * tilstand der både gameRunning og gameOver er false.
 */

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

    /**
     * Metoden viser Gameover panelet og toppliste,
     * og starter et nytt spill om spiller trykker
     * på ''nytt spill'' knappen
     */
    private void gameOver(){

        scoreScreen = new TopScores();
        board.getMainPane().setCenter(scoreScreen);
        player.setScore(board.getScoreGui().getScore());
        scoreScreen.writeToScoreList(player);
        scoreScreen.playAgain.setOnAction(e -> {
            board.getMainPane().setCenter(null);
            newGame();
        });
    }

    /**
     * Metoden starter et nytt spill ved å lage en
     * ny spiller og sette verdier tilbake til original tilstand
     */
    private void newGame(){
        board.getScoreGui().setScore(0);
        player = new Player(enterName());
        ScoreGui.ballsLeft.setText("Balls: " + player.getBalls());
        gameOver = false;
        nextBall();
    }

    /**
     * Metoden lager et nytt ball-objekt og legger til ny animasjon
     * for det. Ballen blir aktivert ved at spiller trykker på den.
     */
    private void nextBall(){
        ball = new Ball(600, 800, 20, board);
        board.getMainPane().getChildren().add(ball);

        animation = new Timeline(new KeyFrame(Duration.millis(30), e -> board.moveBall(ball)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        ball.setOnMouseClicked(e -> gameRunning = true);
    }

    /**
     * Metoden sjekker spill-tilstand, og velger handling etterfulgt
     * av hvilken tilstand spiller ligger i.
     */
    public void gameStateCheck(){
        if(animation != null)
            animation.stop();

        if(!ballsLeft()) {
            gameOver = true;
            gameOver();
        }

        if(!gameOver)
            nextBall();
    }

    /**
     * Metoden sjekker om spiller har baller igjen.
     * Returnerer false om 0 baller, som igjen blir
     * plukka opp av gameStateCheck().
     */
    private boolean ballsLeft(){

        player.setBalls(player.getBalls()-1);
        ScoreGui.ballsLeft.setText("Balls: " + player.getBalls());

        return!(player.getBalls() <= 0);
    }

    /**
     * Metoden gir bruker en inputDialog til å skrive navn i.
     * Navn blir direkte satt til Player.name, og vil automatisk
     * bli ''Anonym'' om bruker trykker cancel eller krysser den ut.
     */
    private String enterName(){
        String name = "";
        try {
            name = JOptionPane.showInputDialog("Navn:");
            if (name.equals("")) {
                name = "Anonym";
            }
        }catch (NullPointerException e){
                name = "Anonym";
        }
        return name;
    }


}

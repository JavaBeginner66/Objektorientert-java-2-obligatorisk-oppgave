public class GameManager {

    public static boolean gameRunning;
    public static boolean gameOver;

    public GameBoard board;

    public GameManager(GameBoard board){
        this.board = board;
        gameRunning = false;

        board.createBall().setOnMouseClicked(e -> gameRunning = true);
    }


}

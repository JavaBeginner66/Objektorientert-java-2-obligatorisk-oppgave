
import javafx.scene.shape.Circle;

/**
 * Objekt av klasse er en ball som blir satt i spill
 * med forskjellige pseudo-physics
 */

public class Ball extends Circle {

    private GameBoard board;

    private BallVector velocity;
    private BallVector speed;

    private double gravity;
    private double bounce;

    public Ball(double x, double y, double r, GameBoard board) {
        super(x, y, r);
        this.velocity = new BallVector(0,-40);
        this.gravity = 0.5;
        this.bounce = 5;
        this.board = board;
    }

    /**
     * Metode som legger velocity til
     * på ball-posisjon. Varierende velocity vil
     * bestemme hvilken retning/hastighet
     * ballen vil fortsette i neste frame.
     */
    public void newVelocity(BallVector velocity){
        setCenterX(getCenterX() + velocity.getX());
        setCenterY(getCenterY() + velocity.getY());
    }

    /**
     * Standard get og set metoder
     */
    public BallVector getVelocity() {
        return velocity;
    }

    public void setVelocity(BallVector velocity) {
        this.velocity = velocity;
    }

    public GameBoard getBoard() {
        return board;
    }

    public double getGravity() {
        return gravity;
    }

}

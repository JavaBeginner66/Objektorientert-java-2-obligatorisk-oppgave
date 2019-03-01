import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle{

    private BallVector velocity;
    private BallVector speed;

    private GameBoard board;

    private double gravity;
    private double bounce;


    public Ball(double x, double y, double r, GameBoard board) {
        super(x, y, r);
        this.velocity = new BallVector(0,-40);
        this.gravity = 0.5;
        this.bounce = 5;
        this.board = board;
    }

    public void newVelocity(BallVector velocity){
        setCenterX(getCenterX() + velocity.getX());
        setCenterY(getCenterY() + velocity.getY());
    }

    public BallVector getVelocity() {
        return velocity;
    }

    public void setVelocity(BallVector velocity) {
        this.velocity = velocity;
    }

    public double getBounce() {
        return bounce;
    }

    public GameBoard getBoard() {
        return board;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}

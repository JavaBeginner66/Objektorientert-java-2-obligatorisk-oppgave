import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle{

    private Timeline animation;
    private BallVector velocity;
    private BallVector speed;
    private double gravity;
    private double bounce;

    GameManager board;

    public Ball(double x, double y, double r, GameManager board) {
        super(x, y, r);
        this.velocity = new BallVector(5,0.8);
        this.gravity = 0.5;
        this.bounce = 5;
        this.board = board;

        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(30), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }


    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {

        // Sjekke om ball treffer ytre boks
        if (getCenterX() < getRadius() || getCenterX() > board.getMainPane().getWidth() - getRadius()) {
            velocity.setX(-velocity.getX());
        }

        if (getCenterY() <= getRadius() || getCenterY() >= board.getMainPane().getHeight() - getRadius()) {
            velocity.setY(-(velocity.getY() - bounce));
        }


        // endre position på ball
        newVelocity(velocity);
        velocity.setY(velocity.getY() + gravity);

        // Gjøre referansen kortere etterhvert
        for (int i = 0; i < board.getDesign().getObjectArray().size(); i++) {
            if (board.getDesign().getObjectArray().get(i).detectCollision(this)) {
                board.getDesign().getObjectArray().get(i).collisionEvent(this);
            }
        }
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

    public GameManager getBoard() {
        return board;
    }
}

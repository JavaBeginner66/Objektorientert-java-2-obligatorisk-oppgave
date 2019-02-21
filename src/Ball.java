import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ball extends Circle{

    private Timeline animation;
    private double dx = 1, dy = 1;

    PinballBoard board;

    public Ball(double x, double y, double r, PinballBoard board) {
        super(x, y, r);
        this.board = board;

        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(20), e -> moveBall()));
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
        // Check boundaries
        if (getCenterX() < getRadius() || getCenterX() > board.getMainPane().getWidth() - getRadius()) {
            dx *= -1; // Change ball move direction
        }
        if (getCenterY() < getRadius() || getCenterY() > board.getMainPane().getHeight() - getRadius()) {
            dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        setCenterX(getCenterX() + dx);
        setCenterY(getCenterY() + dy);
        dy += 0.5;
        this.setCenterX(getCenterX());
        this.setCenterY(getCenterY());
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball {


    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 3, dy = 3;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;

    GuiSetup pane;

    public Ball(GuiSetup pane) {
        circle.setFill(Color.GREEN);
        this.pane = pane;
        pane.getMainPane().getChildren().addAll(circle);
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
        if (x < radius || x > pane.getMainPane().getWidth() - radius) {
            dx *= -1; // Change ball move direction
        }
        if (y < radius || y > pane.getMainPane().getHeight() - radius) {
            dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        x += dx;
        y += dy;
        dy += 1;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}

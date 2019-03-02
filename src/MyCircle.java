import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements CollisionObjects{

    public MyCircle(double x, double y, double radius){
        super(x, y, radius);
    }

    public boolean detectCollision(Ball ball)
    {
        double distance = Math.sqrt((ball.getCenterX() - this.getCenterX())
                                  * (ball.getCenterX() - this.getCenterX())
                                  + (ball.getCenterY() - this.getCenterY())
                                  * (ball.getCenterY() - this.getCenterY()));

        return (ball.getRadius() + this.getRadius() >= distance);
    }

    public void collisionEvent(Ball ball){
        // Midlertidig (Snur bare om på velocity)
        ball.setVelocity(new BallVector(-ball.getVelocity().getX(), (-ball.getVelocity().getY() +ball.getBounce())));
        // Legger til poeng på score
        ball.getBoard().getScoreGui().setScore(ball.getBoard().getScoreGui().getScore()+25);
        Events tick = new Events(this);
        /*
        GameManager.gameRunning = false;
        ball.getBoard().getMainPane().getChildren().remove(ball);
        ball = null;
        */
    }
}

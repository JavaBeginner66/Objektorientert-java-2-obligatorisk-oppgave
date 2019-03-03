import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements CollisionObjects{

    // Legge til variabel(sjekk) for poeng

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
        int random = (int)(Math.random() * 50 + 1);
        // Midlertidig (Snur bare om på velocity)
        ball.setVelocity(new BallVector(-ball.getVelocity().getX(), (-ball.getVelocity().getY() + random)));
        // Legger til poeng på score
        ball.getBoard().getScoreGui().setScore(ball.getBoard().getScoreGui().getScore()+25);
        Events tick = new Events(this);
    }
}

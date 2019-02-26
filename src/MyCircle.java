import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements CollisionObjects{

    public MyCircle(double x, double y, double radius){
        super(x, y, radius);
    }

    public boolean detectCollision(Ball ball)
    {
        Bounds player = ball.getBoundsInLocal();
        Bounds thisRect = this.getBoundsInLocal();
        return player.intersects(thisRect);
    }

    public void collisionEvent(Ball ball){
        // Midlertidig
        ball.setVelocity(new BallVector(-ball.getVelocity().getX(), -ball.getVelocity().getY()));
    }
}

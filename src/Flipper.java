import javafx.geometry.Bounds;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Flipper extends Line implements CollisionObjects{

    public Flipper(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY);
        setStrokeWidth(7);
    }

    public boolean detectCollision(Ball ball)
    {

        Bounds player = ball.getBoundsInLocal();
        Bounds thisRect = this.getBoundsInLocal();
        return player.intersects(thisRect);
    }

    public void collisionEvent(Ball ball){
        ball.setVelocity(new BallVector(ball.getVelocity().getX(), -ball.getVelocity().getY()));
    }



}

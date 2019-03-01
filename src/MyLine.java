import javafx.geometry.Bounds;
import javafx.scene.shape.Line;

public class MyLine extends Line implements CollisionObjects{

    public MyLine(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY);
    }

    public boolean detectCollision(Ball ball)
    {

        Bounds player = ball.getBoundsInLocal();
        Bounds thisRect = this.getBoundsInLocal();
        return player.intersects(thisRect);
    }

    public void collisionEvent(Ball ball){
        // Hardkoder ball til å sprette mot venstre
        ball.setVelocity(new BallVector(ball.getVelocity().getX()-20, 0));
    }
}

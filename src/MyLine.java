import javafx.geometry.Bounds;
import javafx.scene.shape.Line;

/**
 * Klassen produserer linje-objekt av type Shape
 */

public class MyLine extends Line implements CollisionObjects{

    public MyLine(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY);
        setStrokeWidth(7);
    }

    /**
     * Metoden sjekker kollisjon med Bounds klassen
     */
    public boolean detectCollision(Ball ball)
    {

        Bounds player = ball.getBoundsInLocal();
        Bounds thisRect = this.getBoundsInLocal();
        return player.intersects(thisRect);
    }

    /**
     * Metoden vil gi ballen en ny velocity
     */
    public void collisionEvent(Ball ball){
        ball.setVelocity(new BallVector(ball.getVelocity().getX()-10, 10));
    }
}

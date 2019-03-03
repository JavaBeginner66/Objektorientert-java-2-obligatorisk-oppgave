import javafx.geometry.Bounds;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Klassen oppretter et ''Flipper'' Shape-objekt som spiller kan styre.
 * Hensikten er å styre en flipper mot en kollisjon med ball
 * så den holdes i spill
 */

public class Flipper extends Line implements CollisionObjects{

    public Flipper(double startX, double startY, double endX, double endY){
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
     * Metoden endrer Y-retningen
     */

    public void collisionEvent(Ball ball){
        ball.setVelocity(new BallVector(ball.getVelocity().getX(), -ball.getVelocity().getY()));
    }



}

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.geom.Area;

/**
 * Klassen produserer rektangel-objekt av type Shape
 */

public class MyRectangle extends Rectangle implements CollisionObjects {

    public MyRectangle(double x, double y, double width, double height){
        super(x, y, width, height);
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
     *
     */
    public void collisionEvent(Ball ball){
        ball.setVelocity(new BallVector(-ball.getVelocity().getX(), ball.getVelocity().getY()));
    }

}

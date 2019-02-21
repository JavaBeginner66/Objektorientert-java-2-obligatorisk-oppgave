import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.geom.Area;

public class MyRectangle extends Rectangle implements CollisionObjects {

    public MyRectangle(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public boolean detectCollision(Ball ball)
    {
       
        Bounds player = ball.getBoundsInLocal();
        Bounds thisRect = this.getBoundsInLocal();
        return player.intersects(thisRect);
    }

}

import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.geom.Area;

public class MyRectangle extends Rectangle implements CollisionObjects {

    public MyRectangle(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public boolean detectCollision(Ball ball)
    {
        Shape awtBall = (java.awt.Shape) ball;
        Shape thisRectangle = (java.awt.Shape) this;
        Area playerBall = new Area(awtBall);
        playerBall.intersect(new Area(thisRectangle));
        return !playerBall.isEmpty();
    }

}

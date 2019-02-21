import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle implements CollisionObjects {

    public MyRectangle(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public void collision(Ball ball)
    {
        // sjekk for kollisjon med ball
            // if kollisjon, fra hvilken vinkel?
                // Gi ball ny vinkel/fart
    }

}

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Klassen produserer sirkel objekt av type Shape.
 */

public class MyCircle extends Circle implements CollisionObjects{

    public MyCircle(double x, double y, double radius){
        super(x, y, radius);
    }

    /**
     * Metoden sjekker kollisjon ved å først finne avstand mellom
     * to punkt, også finne ut om radiusen til hver sirkel totalt er
     * høyere enn avstanden
     */
    public boolean detectCollision(Ball ball)
    {
        double distance = Math.sqrt((ball.getCenterX() - this.getCenterX())
                                  * (ball.getCenterX() - this.getCenterX())
                                  + (ball.getCenterY() - this.getCenterY())
                                  * (ball.getCenterY() - this.getCenterY()));

        return (ball.getRadius() + this.getRadius() >= distance);
    }

    /**
     * Metoden gir ballen motsatt velocity + et ekstra push av tilfeldighet.
     * Den gir også score for hver kollisjon, i tilleg til å starte en tick-event.
     */
    public void collisionEvent(Ball ball){
        int random = (int)(Math.random() * 50 + 1);
        ball.setVelocity(new BallVector(-ball.getVelocity().getX(), (-ball.getVelocity().getY() + random)));

        ball.getBoard().getScoreGui().setScore(ball.getBoard().getScoreGui().getScore()+checkPoints());
        Events tick = new Events(this);
    }

    /**
     * Metoden sjekker radiusen på sirkelen og gir poeng hensiktsmessig.
     */
    private int checkPoints(){
        int points = 0;

        if(getRadius() <= 10) {
            points = 500;
        }
        else if(getRadius() <= 25 && getRadius() >= 10){
            points = 300;
        }
        else if(getRadius() <= 50 && getRadius() >= 25){
            points = 150;
        }
        else if(getRadius() <= 100 && getRadius() >= 50){
            points = 50;
        }
        else{
            points = 25;
        }

        return points;
    }
}

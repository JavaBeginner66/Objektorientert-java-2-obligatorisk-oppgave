/**
 * Klassen lagrer x og y kordinater for
 * forskjellige/potensielle ball-felt/variabler
 */

public class BallVector {

    private double x;
    private double y;

    public BallVector(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Standard get og set metoder
     */

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

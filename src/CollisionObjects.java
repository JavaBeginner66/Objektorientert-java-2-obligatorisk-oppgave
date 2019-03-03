/**
 * Grensesnittet implementerer metoder for
 * sjekk og handling av kollisjon mellom
 * spiller-ball og shapes
 */

public interface CollisionObjects {

    /**
     * Metoden leter etter en kollisjon
     * og returnerer true om funnet
     */
    public boolean detectCollision(Ball ball);

    /**
     * Metoden beskriver hva som skjer med
     * ball-feltet om en kollisjon skulle skje
     */
    public void collisionEvent(Ball ball);

}

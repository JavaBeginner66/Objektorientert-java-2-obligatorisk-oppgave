import java.io.Serializable;

/**
 * Klassen lagrer opplysninger om spiller.
 *
 * Implementerer Serializable så Player-objektene
 * kan lagres med ObjectStreams.
 *
 * Implementerer Comparable så Player-objektene kan sorteres
 */

public class Player implements Serializable, Comparable<Player> {

    /**
     * SerialVersionUID er et krav når man bruker ObjectStreams
     * ObjectStreamen ignorerer balls siden den er transient
     */

    private static final long serialVersionUID = 4694861542429517006L;
    private transient int balls;
    private int score;
    private String name;

    public Player(String name){
        this.balls = 5;
        this.score = 0;
        this.name = name;
    }



    /**
     * Standard toString-metode
     */

    @Override
    public String toString() {
        return "Navn: " + name + ", Score: " + score;
    }

    /**
     * Metoden sørger for at Collections.sort sammenligner Player.score.
     */
    @Override
    public int compareTo(Player p) {
        return Integer.compare(this.score, p.score);
    }


    /**
     * Standard set og get metoder
     */
    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

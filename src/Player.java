import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {

    private static final long serialVersionUID = 4694861542429517006L;
    private transient int balls;
    private int score;
    private String name;

    public Player(String name){
        this.balls = 2;
        this.score = 0;
        this.name = name;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Navn: " + name + ", Score: " + score;
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(this.score, p.score);
    }
}

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 475918891428093041L;
    private transient int balls;
    private int score;
    private String name;

    public Player(String name){
        this.balls = 5;
        this.score = 0;
        this.name = name;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Navn: " + name + ", Score: " + score;
    }
}

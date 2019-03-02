import java.io.Serializable;

public class Player implements Serializable {


    private static final long serialVersionUID = 4694861542429517006L;
    private transient int balls;
    private int score;
    private String name;

    public Player(){}

    public Player(String name){
        this.balls = 1;
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

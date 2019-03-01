public class Player {

    private int balls;
    private int score;

    public Player(){
        this.balls = 5;
        this.score = 0;
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
}

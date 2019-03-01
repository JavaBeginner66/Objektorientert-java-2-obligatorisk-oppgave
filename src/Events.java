
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Events {

    public Events(Shape object) {

        colorTicker(object);
    }

    public Events(boolean gameRunning) {
        startTimer(gameRunning);
    }
    

    public void colorTicker(Shape object) {

        try {
            //GameBoard.sound.play();
        }catch(Exception e){
            System.out.print("Failed");
        }

        Thread tick = new Thread() {
            Random random = new Random();
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.CYAN};
            int color = new Random().nextInt(colors.length);

            public void run() {
                double count = 0;
                while (count <= 3) {
                    object.setFill(colors[color]);
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.setFill(Color.BLACK);
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        };
        tick.start();
    }


    public void startTimer(boolean gameRunning) {
        Thread clock = new Thread() {
            public void run() {
                double count = 0;
                while (gameRunning) {
                    ScoreGui.labelTime.setText(String.valueOf(count));
                    System.out.print(count);
                    count++;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        clock.start();
    }




}

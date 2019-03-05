
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Klasse inneholder forskjellige events som
 * starter egne Threads.
 */

public class Events {

    public static int count;

    public Events(Shape object) {

        colorTicker(object);
    }

    /**
     * Eventen vil trigre når spiller-objektet treffer
     * et Shape-objekt, som resulterer i at Shape-objektet
     * begynner å blinke i en tilfeldig farge mellom utvalgte
     * farger i et array.
     */

    public void colorTicker(Shape object) {

        try {
            GameBoard.sound.play();
        }catch(Exception e){
            System.out.print("Sound-effect failed to play");
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
                    object.setFill(Color.WHITE);
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

    /**
     * Eventen starter en timer som starter når spillet
     * starter, og slutter når ball er ute av spill
     */
    public static void startTimer() {

        GameManager.gameRunning = true;
        Thread clock = new Thread() {
            public void run() {
                count = 0;
                while (GameManager.gameRunning) {
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

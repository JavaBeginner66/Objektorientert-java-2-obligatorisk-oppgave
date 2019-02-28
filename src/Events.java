
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Events {

    public Events(Shape object){
        colorTicker(object);
    }

    public void colorTicker(Shape object){
        Thread tick = new Thread(){
            Random random = new Random();
            Color[] colors = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.PINK,Color.CYAN};
            int color = new Random().nextInt(colors.length);
            public void run(){
                double count =0;
                while(count <= 3){
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
}

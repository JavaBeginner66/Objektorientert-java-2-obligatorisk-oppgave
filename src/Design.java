import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Klassen lager forskjellige Shape-objekt
 * som fungerer som hinder/begrensinger/poeng for
 * ballen på banen
 */

public class Design {

    private ArrayList<CollisionObjects> objektArray;
    private GameBoard board;

    public Flipper f1;
    public Flipper f2;

    public Design(GameBoard board) {
        this.board = board;
        objectSetup();
    }

    /**
     * Metoden lager forskjellige Shape objekt som
     * blir lagt inn i objektArray for sjekk i sammenheng
     * med grensesnitt
     */
    private void objectSetup(){

        // Flippers
        f1 = new Flipper( 80, 840, 230, 890);
        f2 = new Flipper(300, 890, 450, 840);



        MyCircle c1 = new MyCircle(200, 350, 50);

        MyCircle c2 = new MyCircle(400, 500, 25);

        MyLine line = new MyLine(550, 0, 650, 100);
        MyRectangle l2 = new MyRectangle(540, 200, 10, 950);

        MyLine l3 = new MyLine(0, 850, 90, 950);
        MyLine l4 = new MyLine(450, 950, 545, 830);

        objektArray = new ArrayList<>();
        objektArray.add(c1);
        objektArray.add(c2);
        objektArray.add(line);
        objektArray.add(l2);
        objektArray.add(f1);
        objektArray.add(f2);
        objektArray.add(l3);
        objektArray.add(l4);

        for (CollisionObjects anObjektArray : objektArray)
            board.getMainPane().getChildren().addAll((Shape) anObjektArray);

    }

    /**
     * Standard get metode
     */
    public ArrayList<CollisionObjects> getObjectArray(){
        return objektArray;
    }

}

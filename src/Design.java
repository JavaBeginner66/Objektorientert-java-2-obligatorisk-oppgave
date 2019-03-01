import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Design {

    private ArrayList<CollisionObjects> objektArray;
    private GameBoard board;

    public Design(GameBoard board) {
        this.board = board;
        objectSetup();
    }

    private void objectSetup(){


        MyCircle c1 = new MyCircle(200, 750, 100);

        MyCircle c2 = new MyCircle(400, 900, 50);

        MyLine line = new MyLine(550, 0, 650, 100);

        objektArray = new ArrayList<>();
        objektArray.add(c1);
        objektArray.add(c2);
        objektArray.add(line);

        for (CollisionObjects anObjektArray : objektArray)
            board.getMainPane().getChildren().addAll((Shape) anObjektArray);

    }

    public ArrayList<CollisionObjects> getObjectArray(){
        return objektArray;
    }

}

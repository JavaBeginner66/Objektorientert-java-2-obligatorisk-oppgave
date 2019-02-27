import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Design {

    private ArrayList<CollisionObjects> objektArray;
    private GameManager board;

    public Design(GameManager board) {
        this.board = board;
        objectSetup();
    }

    private void objectSetup(){
        objektArray = new ArrayList<>();

        MyCircle c1 = new MyCircle(200, 750, 50);

        MyCircle c2 = new MyCircle(400, 900, 500);

        objektArray.add(c1);
        objektArray.add(c2);

        for (CollisionObjects anObjektArray : objektArray)
            board.getMainPane().getChildren().addAll((Shape) anObjektArray);

    }

    public ArrayList<CollisionObjects> getObjectArray(){
        return objektArray;
    }

}

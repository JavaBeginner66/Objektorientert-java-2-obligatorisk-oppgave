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

        MyCircle c1 = new MyCircle(200, 500, 50);

        objektArray.add(c1);

        for (CollisionObjects anObjektArray : objektArray)
            board.getMainPane().getChildren().addAll((Shape) anObjektArray);

    }

    public ArrayList<CollisionObjects> getObjectArray(){
        return objektArray;
    }

}

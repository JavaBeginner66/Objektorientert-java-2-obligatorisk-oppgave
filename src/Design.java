import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Design {

    private ArrayList<CollisionObjects> objektArray;
    private PinballBoard board;

    public MyRectangle r1;

    public Design(PinballBoard board) {
        this.board = board;
        objectSetup();
    }

    private void objectSetup(){
        objektArray = new ArrayList<>();

        MyRectangle r1 = new MyRectangle(100, 100, 200, 200);
        objektArray.add(r1);

        for (CollisionObjects anObjektArray : objektArray)
            board.getMainPane().getChildren().addAll((Shape) anObjektArray);

    }

    public ArrayList<CollisionObjects> getObjectArray(){
        return objektArray;
    }

}

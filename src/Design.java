import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Design {

    private ArrayList<Shape> objektArray;
    private PinballBoard board;

    public Design(PinballBoard board) {
        this.board = board;
        objectSetup();
    }

    private void objectSetup(){
        objektArray = new ArrayList<>();

        MyRectangle r1 = new MyRectangle(100, 100, 200, 200);
        objektArray.add(r1);

        board.getMainPane().getChildren().addAll(objektArray);

    }

    public ArrayList<Shape> getObjectArray(){
        return objektArray;
    }

}

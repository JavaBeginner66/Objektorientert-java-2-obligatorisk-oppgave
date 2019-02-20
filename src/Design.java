import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Design {

    private ArrayList<Shape> objektArray;
    private PinballBoard board;

    public Design(PinballBoard board){
        this.board = board;
        objectSetup();
        board.getMainPane().getChildren().addAll(objektArray);
    }

    private void objectSetup(){

    }

    public ArrayList<Shape> getObjectArray(){
        return objektArray;
    }

}

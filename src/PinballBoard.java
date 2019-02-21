import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;


public class PinballBoard extends Application {

    private BorderPane mainPane;

    @Override
    public void start(Stage stage) {

        mainPane = new BorderPane();
        Ball ball = new Ball(20, 20, 20, this);
        Design design = new Design(this);


        mainPane.getChildren().addAll(ball);
        Scene scene = new Scene(mainPane, 650, 950);
        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }


    public BorderPane getMainPane(){
        return mainPane;
    }



    public static void main(String args[]){
        launch(args);
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;


public class PinballBoard extends Application {

    private BorderPane mainPane;
    private Ball ball;
    private Design design;

    @Override
    public void start(Stage stage) {

        mainPane = new BorderPane();
        ball = new Ball(150, 50, 20, this);
        design = new Design(this);


        mainPane.getChildren().addAll(ball);
        Scene scene = new Scene(mainPane, 650, 950);
        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }


    public BorderPane getMainPane(){
        return mainPane;
    }

    public Ball getBall() {
        return ball;
    }

    public Design getDesign() {
        return design;
    }

    public static void main(String args[]){
        launch(args);
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GuiSetup extends Application {

    private BorderPane mainPane;

    @Override
    public void start(Stage stage) {

        mainPane = new BorderPane();
        Ball ball = new Ball(this);


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

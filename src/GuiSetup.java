import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GuiSetup extends Application {

    BorderPane mainPane;

    @Override
    public void start(Stage stage) {

        mainPane = new BorderPane();



        Scene scene = new Scene(mainPane, 650, 950);
        stage.setTitle("Pinball");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}

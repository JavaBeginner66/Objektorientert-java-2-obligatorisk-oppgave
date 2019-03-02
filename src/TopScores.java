import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopScores extends GridPane {

    public Button playAgain;

    public TopScores(Object object){
    }

    public TopScores(){
        Label gameOver = new Label("Game over. \n Toplist: ");
        gameOver.setFont(Font.font("Monospace",
                FontWeight.BOLD, FontPosture.REGULAR, 30));
        playAgain = new Button("Spill igjen");
        playAgain.setStyle("-fx-font: 14 arial; -fx-base: #008B8B; -fx-font-size: 12px;" +
                "-fx-text-fill:white; -fx-font-family: \"Arial Narrow\";" +
                "    -fx-font-weight: bold;");
        playAgain.setMinWidth(100);
        playAgain.setMinHeight(35);
        playAgain.setMaxWidth(170);
        this.add(gameOver, 0,0);
        this.add(playAgain, 0, 999);
        this.setPadding(new Insets(100, 0, 0,225));

    }

    public void scoreListManager(Player player){

    }

}

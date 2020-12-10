package podkowinski.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EndGameWindow {

    public static void displayWinner(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(180);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-background-color: white");
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(150);
        label.setTextAlignment(TextAlignment.CENTER);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();
    }

    public static void displayGameOver(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(180);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-background-color: white");
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(150);
        label.setTextAlignment(TextAlignment.CENTER);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();
    }
}

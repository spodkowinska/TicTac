package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    Controller controller;
    Model model;
    @Override
    public void start(Stage primaryStage) throws Exception{



        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 510, 510));

        controller = loader.getController();
        model = new Model();
        controller.setModel(model);

        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

}

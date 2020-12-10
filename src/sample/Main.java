package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Arrays;

public class Main extends Application {

    Controller controller;
    Model model;
    Computer computer;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(new Scene(root, 510, 510));

//        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("welcomScreen.fxml"));
//        Parent root1 = loader.load();
//        primaryStage.setTitle("Tic Tac Toe Game");
//        primaryStage.setScene(new Scene(root, 510, 510));
        controller = loader.getController();
       // computer = new Computer(2);
        model = new Model(true);
        controller.setModel(model);
        computer=(Computer)model.getPlayer2();
        computer.setModel(model);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package podkowinski.controller;

import javafx.event.Event;
import javafx.scene.control.Button;
import podkowinski.model.Model;

public class WelcomeScreenController extends Controller {
    Model model;
    boolean isOnePlayerGame;
    boolean isEasyGame;

    public void setModel(Model model) {
        this.model = model;
    }

    public void twoPlayersGame(Event event) {
        isOnePlayerGame = false;
        System.out.println(isOnePlayerGame);
    }

    public void easyGame(Event event) {
        isOnePlayerGame = true;
        isEasyGame = true;
        System.out.println(isOnePlayerGame);
    }

    public void hardGame(Event event) {
        isOnePlayerGame = true;
        isEasyGame = false;
        System.out.println(isOnePlayerGame);
    }
}

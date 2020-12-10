package sample;

import javafx.event.Event;
import javafx.scene.control.Button;

public class WelcomeScreenController {
    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void twoPlayersGame(Event event){
        Button button = (Button) event.getSource();

    }

    public void easyGame(){}

    public void hardGame(){}
}

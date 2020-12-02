package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;


public class Controller implements EventHandler {

    Model model;

    public void setModel(Model model){
        this.model = model;
    }

    @FXML
    public void hoover(Event event) {
    }

    @FXML
    public void click(Event event) {
        Button button = (Button) event.getSource();
        if (button != null) {
            int x = (int)button.getLayoutX();
            int y = (int)button.getLayoutY();
            Point point = createPoint(x, y);
            if (model.getPlayer1().getCurrentPlayer()) {
                button.setGraphic(new ImageView("o.png"));
                model.getPlayer1().addPosition(point);
            } else {
                button.setGraphic(new ImageView("x.png"));
                model.getPlayer2().addPosition(point);
            }
            model.addTakenPosition(point);
            changePlayer();
        }
    }

    @Override
    public void handle(Event event) {
    }

    private void changePlayer() {
        if (model.getPlayer1().getCurrentPlayer()) {
            Player player2 = model.getPlayer2();
            player2.setCurrentPlayer(true);
            model.setPlayer2(player2);
            Player player1 = model.getPlayer1();
            player1.setCurrentPlayer(false);
            model.setPlayer1(player1);
        } else {
            Player player2 = model.getPlayer2();
            player2.setCurrentPlayer(false);
            model.setPlayer2(player2);
            Player player1 = model.getPlayer1();
            player1.setCurrentPlayer(true);
            model.setPlayer1(player1);
        }
    }
    private Point createPoint(int x, int y){
        if(x==0){
            if(y == 0){
                return new Point(0,0);
            }else if(y == 180) {
                return new Point(0, 1);
            } else if(y == 360){
                return new Point(0,2);
            }
        } else if (x == 180){
            if(y == 0){
                return new Point(1,0);
            }else if(y == 180) {
                return new Point(1, 1);
            } else if(y == 360){
                return new Point(1,2);
            }
        }
        else if (x == 360){
            if(y == 0){
                return new Point(2,0);
            }else if(y == 180) {
                return new Point(2, 1);
            } else if(y == 360){
                return new Point(2,2);
            }
        }
        return null;
    }

    private boolean haveWinner(){
       return false;
    }
}

package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;


public class Controller implements EventHandler {

    Model model;

    @FXML Button button1;
    @FXML Button button2;
    @FXML Button button3;
    @FXML Button button4;
    @FXML Button button5;
    @FXML Button button6;
    @FXML Button button7;
    @FXML Button button8;
    @FXML Button button9;

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    public void hoover(Event event) {
        Button button = (Button) event.getSource();
        if (button != null) {
            button.setStyle("-fx-background-color: grey");
//            button.setStyle("-fx-border-color: darkgrey");
        }
    }

    @FXML
    public void unhoover(Event event) {
        Button button = (Button) event.getSource();
        if (button != null) {
            button.setStyle("-fx-background-color: transparent");
        }
    }

    @FXML
    public void click(Event event) {
        Button button = (Button) event.getSource();
        if (button != null) {
            int x = (int) button.getLayoutX();
            int y = (int) button.getLayoutY();
            Point point = createPoint(x, y);
            if (!model.getTakenPositions().contains(point)) {
                if (model.getPlayer1().getCurrentPlayer()) {
                    button.setGraphic(new ImageView("o.png"));
                    model.getPlayer1().addPosition(point);
                    if (haveWinner()) {
                        EndGameWindow.displayWinner("TicTacToe Game", winningMessage(model.getPlayer1()));
                        setNewGame();
                    }
                } else {
                    button.setGraphic(new ImageView("x.png"));
                    model.getPlayer2().addPosition(point);
                    if (haveWinner()) {
                        EndGameWindow.displayWinner("TicTacToe Game", winningMessage(model.getPlayer2()));
                        setNewGame();
                    }
                }
                model.addTakenPosition(point);
                changePlayer();
                if(model.getTakenPositions().size()==9){
                    EndGameWindow.displayGameOver("TicTacToe Game", "GAME OVER");
                    setNewGame();
                }
            }
        }
    }

    private String winningMessage(Player player) {
        return "We have a Winner!\nCongratulations Player " + player.getNumber() + "\n";
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

    private Point createPoint(int x, int y) {
        if (x == 0) {
            if (y == 0) {
                return new Point(0, 0);
            } else if (y == 180) {
                return new Point(0, 1);
            } else if (y == 360) {
                return new Point(0, 2);
            }
        } else if (x == 180) {
            if (y == 0) {
                return new Point(1, 0);
            } else if (y == 180) {
                return new Point(1, 1);
            } else if (y == 360) {
                return new Point(1, 2);
            }
        } else if (x == 360) {
            if (y == 0) {
                return new Point(2, 0);
            } else if (y == 180) {
                return new Point(2, 1);
            } else if (y == 360) {
                return new Point(2, 2);
            }
        }
        return null;
    }

    private boolean haveWinner() {
        if (model.getPlayer1().isWinner() || model.getPlayer2().isWinner()) {
            return true;
        }
        return false;
    }

    public void setNewGame(){
        model.setTakenPositions(new ArrayList<>());
        model.setPlayer1(null);
        model.setPlayer2(null);
        model.setPlayers();
        cleanBoard();
    }

    public void cleanBoard(){
        button1.setGraphic(new ImageView("blank.png"));
        button2.setGraphic(new ImageView("blank.png"));
        button3.setGraphic(new ImageView("blank.png"));
        button4.setGraphic(new ImageView("blank.png"));
        button5.setGraphic(new ImageView("blank.png"));
        button6.setGraphic(new ImageView("blank.png"));
        button7.setGraphic(new ImageView("blank.png"));
        button8.setGraphic(new ImageView("blank.png"));
        button9.setGraphic(new ImageView("blank.png"));
    }

}
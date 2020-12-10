package podkowinski.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import podkowinski.model.Computer;
import podkowinski.view.EndGameWindow;
import podkowinski.model.Model;
import podkowinski.model.Player;

import java.awt.Point;
import java.util.ArrayList;


public class Controller implements EventHandler {

    Model model;


    @FXML
    Button button00;
    @FXML
    Button button01;
    @FXML
    Button button02;
    @FXML
    Button button10;
    @FXML
    Button button11;
    @FXML
    Button button12;
    @FXML
    Button button20;
    @FXML
    Button button21;
    @FXML
    Button button22;

    Button[] buttons = new Button[9];
    //    {button00, button01, button02, button10, button11, button12, button20, button21, button22};

    //TODO after implementing computer actions
    @FXML
    public void initialize() {
    //    setNewGame();
        buttons[0] = button00;
        buttons[1] = button01;
        buttons[2] = button02;
        buttons[3] = button10;
        buttons[4] = button11;
        buttons[5] = button12;
        buttons[6] = button20;
        buttons[7] = button21;
        buttons[8] = button22;


    }

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    public void hoover(Event event) {
        Button button = (Button) event.getSource();
        if (button != null) {
            button.setStyle("-fx-background-color: grey");
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
            boolean isGameFinished = false;
            if (!model.getTakenPositions().contains(point)) {
                if (model.getPlayer1().getCurrentPlayer()) {
                    button.setGraphic(new ImageView("o.png"));
                    model.getPlayer1().addPosition(point);
                    if (!haveWinner()) {
                        model.addTakenPosition(point);
                        changePlayer();
                    }
                    System.out.println("PLAYER 1: " + model.getPlayer1().positions);
                } else if (model.getPlayer2().getCurrentPlayer() && !(model.getPlayer2() instanceof Computer)) {
                    button.setGraphic(new ImageView("x.png"));
                    model.getPlayer2().addPosition(point);
                    if (!haveWinner()) {
                        model.addTakenPosition(point);
                        changePlayer();
                    }
                    System.out.println("PLAYER 2: " + model.getPlayer2().positions);
                }

                if (!haveWinner() && model.getPlayer2() instanceof Computer) {
                    boolean isComputerMoved = false;
                    while (!isComputerMoved) {
                        Point move = ((Computer) model.getPlayer2()).randomMove();
                        if (!model.getTakenPositions().contains(move)) {
                            for (Button buttonToCheck : buttons) {
                                if (buttonToCheck.getId().equals(((int) move.getX()) + "" + (int) move.getY())) {
                                    buttonToCheck.setGraphic(new ImageView("x.png"));
                                    model.getPlayer2().addPosition(move);
                                    System.out.println("COMPUTER: " + model.getPlayer2().positions);
                                    if (!haveWinner()) {
                                        changePlayer();
                                        model.addTakenPosition(move);
                                    }
                                    isComputerMoved = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (haveWinner()) {
                EndGameWindow.displayWinner("TicTacToe Game", winningMessage(model.getPlayer1().isCurrentPlayer ? model.getPlayer1() : model.getPlayer2()));
                setNewGame();
                isGameFinished = true;
            }
            if (model.getTakenPositions().size() == 9) {
                EndGameWindow.displayGameOver("TicTacToe Game", "GAME OVER");
                setNewGame();
            }
        }
    }

//        if(model.getPlayer2() instanceof Computer){
//
//            Point move = ((Computer) model.getPlayer2()).randomMove();
//            for( Button buttonToCheck : buttons) {
//                if (buttonToCheck.getId() == String.valueOf(move.getX()) + String.valueOf(move.getY())) {
//                    buttonToCheck.setGraphic(new ImageView("x.png"));
//                    break;
//                }
//            }
//        }


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

    public void setNewGame() {
        model.setTakenPositions(new ArrayList<>());
        model.setPlayer1(null);
        model.setPlayer2(null);
        model.setPlayers();
        cleanBoard();

    }

    public void cleanBoard() {
        button01.setGraphic(new ImageView("blank.png"));
        button02.setGraphic(new ImageView("blank.png"));
        button00.setGraphic(new ImageView("blank.png"));
        button10.setGraphic(new ImageView("blank.png"));
        button11.setGraphic(new ImageView("blank.png"));
        button12.setGraphic(new ImageView("blank.png"));
        button20.setGraphic(new ImageView("blank.png"));
        button21.setGraphic(new ImageView("blank.png"));
        button22.setGraphic(new ImageView("blank.png"));
    }

}
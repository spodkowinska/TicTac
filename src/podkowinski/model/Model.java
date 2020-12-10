package podkowinski.model;

import java.awt.*;
import java.util.ArrayList;

public class Model {

    public Model(boolean isOnePlayerGame, boolean isEasyGame){
        setPlayers();
        this.takenPositions = new ArrayList<>();
        this.isOnePlayerGame = isOnePlayerGame;
        this.isEasyGame = isEasyGame;
    }
    private Player player1;
    private Player player2;
    boolean isOnePlayerGame;
    boolean isEasyGame;

    private ArrayList<Point> takenPositions;

    public void setTakenPositions(ArrayList<Point> takenPositions) {
        this.takenPositions = takenPositions;
    }

    public ArrayList<Point> getTakenPositions() {
        return takenPositions;
    }

    public void addTakenPosition(Point takenPosition) {
        this.takenPositions.add(takenPosition);
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayers() {
        Player player1 = new Player(1);
        player1.setCurrentPlayer(true);
        setPlayer1(player1);
        if (isOnePlayerGame) {
            setPlayer2(new Player(2));
        }
        else {
            setPlayer2(new Computer(2));
        }
    }
}

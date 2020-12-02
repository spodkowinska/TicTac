package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    int number;
    ArrayList<Point> positions;
    public boolean isCurrentPlayer;


    public Player(int number) {
        this.number = number;
        this.positions = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setCurrentPlayer(boolean currentPlayer) {
        isCurrentPlayer = currentPlayer;
    }

    public boolean getCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void addPosition(Point point) {
        for(int i = 0; i<positions.size(); i++){

            if(positions.get(i).getX()>point.getX()){
                if(positions.get(i).getY()>point.getY()){
                    positions.add(i,point);
                }
            }
        }
        this.positions.add(point);
    }

    public boolean isWinner() {
        if (positions.size() > 2) {
            if (positions.size()==5){
                if (positions.get(0).getX() - positions.get(2).getX() == positions.get(2).getX() - positions.get(4).getX()
                        && positions.get(0).getY() - positions.get(2).getY() == positions.get(2).getY() - positions.get(4).getY()) {
                    return true;
                }
                if (positions.get(0).getX() - positions.get(3).getX() == positions.get(3).getX() - positions.get(4).getX()
                        && positions.get(0).getY() - positions.get(3).getY() == positions.get(3).getY() - positions.get(4).getY()) {
                    return true;
                }
                if (positions.get(0).getX() - positions.get(1).getX() == positions.get(1).getX() - positions.get(4).getX()
                        && positions.get(0).getY() - positions.get(1).getY() == positions.get(1).getY() - positions.get(4).getY()) {
                    return true;
                }
            }
            if (positions.size() >= 4) {
                if (positions.get(0).getX() - positions.get(2).getX() == positions.get(2).getX() - positions.get(3).getX()
                        && positions.get(0).getY() - positions.get(2).getY() == positions.get(2).getY() - positions.get(3).getY()) {
                    return true;
                }
                if (positions.get(0).getX() - positions.get(1).getX() == positions.get(1).getX() - positions.get(3).getX()
                        && positions.get(0).getY() - positions.get(1).getY() == positions.get(1).getY() - positions.get(3).getY()) {
                    return true;
                }
            }
            if (positions.size() >= 3) {
                if (positions.get(0).getX() - positions.get(1).getX() == positions.get(1).getX() - positions.get(2).getX()
                        && positions.get(0).getY() - positions.get(1).getY() == positions.get(1).getY() - positions.get(2).getY()) {
                    return true;
                }
            }
        }
        return false;
    }
}

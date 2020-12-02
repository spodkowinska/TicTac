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


    public Player(int number){
        this.number = number;
        this.positions = new ArrayList<>();
    }

    public int getNumber(){
        return number;
    }

    public void setCurrentPlayer(boolean currentPlayer) {
        isCurrentPlayer = currentPlayer;
    }

    public boolean getCurrentPlayer() {
        return isCurrentPlayer;
    }
    public void addPosition(Point point){
        this.positions.add(point);
    }

    public boolean isWinner(){
        if(this.positions.size()>2){
            for(int i = 0; i<positions.size()-2; i++){

            }
        }
        return false;
    }
}

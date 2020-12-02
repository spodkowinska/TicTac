package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Player {
    int number;
    SortedSet<Point> positions;
    public boolean isCurrentPlayer;


    public Player(int number) {
        this.number = number;
        this.positions = new TreeSet<>((p1,p2)->p1.getX() == p2.getX() ? (int)(p2.getY() - p1.getY()) : (int)(p2.getX() - p1.getX()));
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
//        for (int i = 0; i < positions.size(); i++) {
//            if (positions.get(i).getX() > point.getX()) {
//                for (int j = 0; j < positions.size(); j++) {
//                    if (positions.get(j).getY() > point.getY()) {
//                        positions.add(i, point);
//                    }
//                }
//            }
//        }

        this.positions.add(point);
//        positions.sort((p1,p2)->p1.getX() == p2.getX() ? (int)(p2.getY() - p1.getY()) : (int)(p2.getX() - p1.getX()));

    }
    

    public boolean isWinner() {

        ArrayList<Point> points = new ArrayList<Point>(positions);
        if (points.size() > 2) {
            if (points.size() == 5) {
                if (points.get(0).getX() - points.get(2).getX() == points.get(2).getX() - points.get(4).getX()
                        && points.get(0).getY() - points.get(2).getY() == points.get(2).getY() - points.get(4).getY()) {
                    return true;
                }
                if (points.get(0).getX() - points.get(3).getX() == points.get(3).getX() - points.get(4).getX()
                        && points.get(0).getY() - points.get(3).getY() == points.get(3).getY() - points.get(4).getY()) {
                    return true;
                }
                if (points.get(0).getX() - points.get(1).getX() == points.get(1).getX() - points.get(4).getX()
                        && points.get(0).getY() - points.get(1).getY() == points.get(1).getY() - points.get(4).getY()) {
                    return true;
                }
            }
            if (points.size() >= 4) {
                if (points.get(0).getX() - points.get(2).getX() == points.get(2).getX() - points.get(3).getX()
                        && points.get(0).getY() - points.get(2).getY() == points.get(2).getY() - points.get(3).getY()) {
                    return true;
                }
                if (points.get(0).getX() - points.get(1).getX() == points.get(1).getX() - points.get(3).getX()
                        && points.get(0).getY() - points.get(1).getY() == points.get(1).getY() - points.get(3).getY()) {
                    return true;
                }
            }
            if (points.size() >= 3) {
                if (points.get(0).getX() - points.get(1).getX() == points.get(1).getX() - points.get(2).getX()
                        && points.get(0).getY() - points.get(1).getY() == points.get(1).getY() - points.get(2).getY()) {
                    return true;
                }
            }
        }
        return false;
    }
}

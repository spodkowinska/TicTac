package sample;


import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {
    public Computer(int number) {
        super(number);
    }

    Model model;
    Random random = new Random();

    public void setModel(Model model) {
        this.model = model;
    }

    public Point randomMove() {
        ArrayList<Point> takenPositions = model.getTakenPositions();
        boolean pointFound = false;
        Point nextPoint = new Point();
        while (!pointFound) {
            int randomX = random.nextInt(3);
            int randomY = random.nextInt(3);
            boolean randomAccepted = true;
            for (Point position : takenPositions) {
                if (randomX == position.getX() && randomY == position.getY()) {
                    randomAccepted = false;
                    break;
                }
            }
            if (randomAccepted) {
                nextPoint = new Point(randomX, randomY);
                pointFound = true;
            }
        }
        return nextPoint;
    }
}

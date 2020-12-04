package sample;


import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.*;

public class Computer extends Player {
    Model model;
    Random random;
    Map<Point, Point> middlePointStrategyMap;

    public Computer(int number) {
        super(number);
        middlePointStrategyMap = new HashMap<>();
        createStrategy();
        random = new Random();
    }


    public void setModel(Model model) {
        this.model = model;
    }

// to use on easy level

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

// to use on hard level

    public Point firstMove() {
        Random random = new Random();
        Point nextPoint = new Point(1, 1);
        ArrayList<Point> takenPositions = model.getTakenPositions();
        boolean pointFound = false;
        while (!pointFound) {
            boolean pointUnique = true;
            for (Point point : takenPositions) {
                if (point.getX() == nextPoint.getX() && point.getY() == nextPoint.getY()) {
                    pointUnique = false;
                    break;
                }
            }
            if (pointUnique) {
                pointFound = true;
            }
            int optionNumber = random.nextInt(4);
            switch (optionNumber) {
                case 0:
                    nextPoint.setLocation(0, 0);
                case 1:
                    nextPoint.setLocation(0, 2);
                case 2:
                    nextPoint.setLocation(2, 0);
                case 3:
                    nextPoint.setLocation(2, 2);
            }
        }
        return nextPoint;
    }

    public Point nextMove() {
        Point nextPoint = new Point();
        SortedSet<Point> playerPositions = model.getPlayer1().positions;
        for (Point point : playerPositions) {
            if (point.equals(new Point(1, 1))) {
                nextPoint = middlePointStrategy();
                return nextPoint;
            }
        }
        nextPoint = cornerPointStrategy();
        return nextPoint;
    }

    private void createStrategy() {
        middlePointStrategyMap.put(new Point(0, 0), new Point(2, 2));
        middlePointStrategyMap.put(new Point(0, 1), new Point(0, 2));
        middlePointStrategyMap.put(new Point(0, 2), new Point(2, 0));
        middlePointStrategyMap.put(new Point(1, 0), new Point(1, 2));
        middlePointStrategyMap.put(new Point(1, 2), new Point(1, 0));
        middlePointStrategyMap.put(new Point(2, 0), new Point(0, 2));
        middlePointStrategyMap.put(new Point(2, 1), new Point(0, 1));
        middlePointStrategyMap.put(new Point(2, 2), new Point(0, 2));
    }

    public Point middlePointStrategy() {
        Point newPoint;
        Point previousMove = model.getTakenPositions().get((model.getTakenPositions()).size() - 1);
        newPoint = middlePointStrategyMap.get(previousMove);
        return newPoint;
    }

    public Point cornerPointStrategy() {
        Point newPoint = new Point();
        ArrayList<Point> playerPositions = new ArrayList<>(model.getPlayer1().positions);
        ArrayList<Point> computerPositions = new ArrayList<>(this.positions);
        int myX = twoInARow(computerPositions);
        if (myX != -1) {
            for (int i = 0; i < 3; i++) {
                newPoint.setLocation(myX, i);
                if (computerPositions.contains(newPoint)) {
                    break;
                }
                return newPoint;
            }
        }
        int myY = twoInAColumn(computerPositions);
        if (myY != -1) {
            for (int i = 0; i < 3; i++) {
                newPoint.setLocation(i, myY);
                if (computerPositions.contains(newPoint)) {
                    break;
                }
                return newPoint;
            }
        }
        int x = twoInARow(playerPositions);
        if (x != -1) {
            for (int i = 0; i < 3; i++) {
                newPoint.setLocation(x, i);
                if (playerPositions.contains(newPoint)) {
                    break;
                }
                return newPoint;
            }
        }
        int y = twoInAColumn(playerPositions);
        if (y != -1) {
            for (int i = 0; i < 3; i++) {
                newPoint.setLocation(i, y);
                if (playerPositions.contains(newPoint)) {
                    break;
                }
                return newPoint;
            }
        }
        return randomMove();

    }

    // returns position x if in collection there are two point in a row, if not -1;
    private int twoInARow(ArrayList<Point> positions) {
        for (int i = 0; i < positions.size() - 1; i++) {
            if (positions.get(i).getX() == positions.get(i + 1).getX()) {
                if (!threeIARow((int) positions.get(i).getX())) {
                    return (int) positions.get(i).getX();
                }
            }
        }
        return -1;
    }

    // returns position y if in collection there are two point in a row, if not -1;
    private int twoInAColumn(ArrayList<Point> positions) {
        for (int i = 0; i < positions.size() - 1; i++) {
            if (positions.get(i).getY() == positions.get(i + 1).getY()) {
                return (int) positions.get(i).getY();
            }
        }
        return -1;
    }

    private boolean threeIARow(int x) {
        ArrayList<Point> takenPositions = model.getTakenPositions();

        return (takenPositions.contains(new Point(x, 0)) && takenPositions.contains(new Point(x, 1)) && takenPositions.contains(new Point(x, 2))) ? true : false;
    }

}

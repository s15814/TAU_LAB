package logic;

import model.Figure;

public class FourSidesCheck {
    public void checkIfFourSidedFigureCanBeBuilt(Figure figure) {
        Figure fourSides = figure;
        boolean check = true;
        int a = figure.getX1();
        int b = figure.getX2();
        int c = figure.getX3();
        int d = figure.getX4();

        while (true) {
            if (checkIfItsTrapezoid(a, b, c, d))
                break;
            if (checkIfItsTrapezoid(a, c, b, d))
                break;
            if (checkIfItsTrapezoid(a, d, b, c))
                break;
            if (checkIfItsTrapezoid(b, c, a, d))
                break;
            if (checkIfItsTrapezoid(b, d, a, c))
                break;
            if (checkIfItsTrapezoid(c, d, a, b))
                break;
            if (checkIfItsSquare(a, b, c, d))
                break;
            System.out.println("You can't build a figure");
            break;
        }
    }

    private boolean checkIfItsSquare(int side1, int side2, int side3, int side4) {
        if (side1 == side2 && side2 == side3 && side3 == side4) {
            System.out.println("You can build a square");
            return true;
        } else {
            return checkIfItsRectangle(side1, side2, side3, side4);
        }
    }

    private boolean checkIfItsRectangle(int side1, int side2, int side3, int side4) {
        if ((side1 == side2 && side3 == side4) ||
                (side1 == side3 && side2 == side4) ||
                (side1 == side4 && side2 == side3)) {
            System.out.println("You can build a rectangle");
            return true;
        }
        return false;
    }

    private boolean checkIfItsTrapezoid(int side1, int side2, int side3, int side4) {
        if (Math.abs(side4 - side3) < Math.abs(side2 - side1) && Math.abs(side2 - side1) < side4 + side3) {
            System.out.println("You can build a trapezoid");
            return true;
        }
        return false;
    }
}

package com.pjwstk.figure;

public class Rectangle extends Polygon {
    public Rectangle() {
        super(4);
    }

    @Override
    public boolean checkIfFigureCanBeBuilt(int... sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        int d = sides[3];

        if (isRectangleASquare(a, b, c, d))
            return true;
        else {
            return areTwoPairsOfSidesEqual(a, b, c, d);
        }
    }

    private boolean isRectangleASquare(int a, int b, int c, int d) {
        return (a == d && b == c && b == d);
    }

    private boolean areTwoPairsOfSidesEqual(int a, int b, int c, int d) {
        if (a == b && c == d) {
            return true;
        } else if (a == d && c == b) {
            return true;
        } else {
            return a == c && d == b;
        }
    }
}

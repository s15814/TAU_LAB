package com.pjwstk.figure;

public class Triangle extends Polygon {
    public Triangle() {
        super(3);
    }

    @Override
    public boolean checkIfFigureCanBeBuilt(int... sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        return isSumOfSidesHigherThanThirdSide(a, b, c) &&
                isSumOfSidesHigherThanThirdSide(a, c, b) &&
                isSumOfSidesHigherThanThirdSide(b, c, a);
    }

    private boolean isSumOfSidesHigherThanThirdSide(int first, int second, int third) {
        return (first + second) > third;
    }
}

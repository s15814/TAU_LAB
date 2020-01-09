package com.pjwstk.figure;

public class Trapeze extends Polygon {
    public Trapeze() {
        super(4);
    }

    @Override
    public boolean checkIfFigureCanBeBuilt(int... sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        int d = sides[3];

        boolean[] results = new boolean[6];
        results[0] = isValidTrapeze(a, b, c, d);
        results[1] = isValidTrapeze(a, c, b, d);
        results[2] = isValidTrapeze(a, d, b, c);
        results[3] = isValidTrapeze(b, c, a, d);
        results[4] = isValidTrapeze(b, d, a, c);
        results[5] = isValidTrapeze(c, d, a, b);

        for (boolean result : results) {
            if (result) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidTrapeze(int a, int b, int c, int d) {
        if (Math.abs(a - b) > 0) {
            double left = Math.abs(d - c);
            double mid = Math.abs(b - a);
            double right = d + c;
            return left < mid && mid < right;
        } else {
            return false;
        }
    }
}

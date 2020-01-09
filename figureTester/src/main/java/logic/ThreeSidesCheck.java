package logic;

import model.Figure;

public class ThreeSidesCheck {
    public void checkIfTriangleCanBeBuilt(Figure figure) {
        boolean triangleCorrect = false;
        Figure triangle = figure;
        int a = triangle.getX1();
        int b = triangle.getX2();
        int c = triangle.getX3();

        if (areTheSidesCorrectForTriangle(a, b, c) &&
                areTheSidesCorrectForTriangle(a, c, b) &&
                areTheSidesCorrectForTriangle(b, c, a)) {
            triangleCorrect = true;
        }
        if (triangleCorrect) {
            System.out.println("You can build a triangle");
        } else {
            System.out.println("You can't build a figure");
        }
    }

    private boolean areTheSidesCorrectForTriangle(int side1, int side2, int side3) {
        if ((side1 + side2) > side3)
            return true;
        return false;
    }
}

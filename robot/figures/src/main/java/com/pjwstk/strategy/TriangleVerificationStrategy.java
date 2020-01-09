package com.pjwstk.strategy;

import com.pjwstk.figure.Figure;
import com.pjwstk.figure.Triangle;

public class TriangleVerificationStrategy implements FigureVerificationStrategy {
    private Figure triangle = new Triangle();

    @Override
    public boolean checkIfFigureCanBeBuilt(int... sides) {
        return triangle.isBuildingFigurePossible(sides);
    }
}

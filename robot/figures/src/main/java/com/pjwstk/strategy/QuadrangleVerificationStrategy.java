package com.pjwstk.strategy;

import com.pjwstk.figure.Figure;
import com.pjwstk.figure.Rectangle;
import com.pjwstk.figure.Trapeze;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleVerificationStrategy implements FigureVerificationStrategy {
    private List<Figure> quadrangles = new ArrayList<>();

    public QuadrangleVerificationStrategy() {
        quadrangles.add(new Rectangle());
        quadrangles.add(new Trapeze());
    }

    @Override
    public boolean checkIfFigureCanBeBuilt(int... sides) {
        for (Figure figure : quadrangles) {
            if (figure.isBuildingFigurePossible(sides)) {
                return true;
            }
        }
        return false;
    }
}

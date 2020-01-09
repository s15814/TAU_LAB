package com.pjwstk.figure;

public abstract class Polygon implements Figure {
    private final int amountOfSides;
    private final String name;

    public Polygon(int amountOfSides) {
        this.amountOfSides = amountOfSides;
        this.name = this.getClass().getSimpleName();
    }

    public boolean isAmountOfSidesCorrect(int... sides) {
        if (sides.length != amountOfSides) {
            System.out.println(name + " must have exactly " + amountOfSides + " sides!");
            return false;
        }
        return true;
    }

    @Override
    public boolean isBuildingFigurePossible(int... sides) {
        if (isAmountOfSidesCorrect(sides)) {
            return checkIfFigureCanBeBuilt(sides);
        }
        return false;
    }

    public abstract boolean checkIfFigureCanBeBuilt(int... sides);
}

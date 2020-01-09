package com.pjwstk;

import com.pjwstk.strategy.FigureVerificationStrategy;
import com.pjwstk.strategy.QuadrangleVerificationStrategy;
import com.pjwstk.strategy.TriangleVerificationStrategy;
import com.pjwstk.util.NumberUtils;

public class FigureValidator {
    private boolean validationFailed = false;
    private final FigureVerificationStrategy triangleStrategy = new TriangleVerificationStrategy();
    private final FigureVerificationStrategy quadrangleStrategy = new QuadrangleVerificationStrategy();

    public boolean verify(String[] args) {
        int[] numbers = new int[0];
        try {
            numbers = NumberUtils.parseNumbers(args);
        } catch (NumberFormatException nfe) {
            System.out.println("Error: Failed to parse all numbers correctly");
            System.out.println(nfe.getMessage());
            validationFailed = true;
        }

        if (validationFailed) {
            return false;
        }

        switch (numbers.length) {
            case 3:
                return triangleStrategy.checkIfFigureCanBeBuilt(numbers);
            case 4:
                return quadrangleStrategy.checkIfFigureCanBeBuilt(numbers);
            default:
                System.out.println("Error: Amount of input parameters must be either 3 or 4");
                return false;
        }
    }
}

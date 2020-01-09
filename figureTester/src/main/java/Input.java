import logic.FourSidesCheck;
import logic.ThreeSidesCheck;
import model.Figure;


public class Input {
    Figure figure;
    ThreeSidesCheck checkForTriangle = new ThreeSidesCheck();
    FourSidesCheck fourSidesCheck = new FourSidesCheck();

    public static int[] parseNumbers(String[] numberStrings) throws NumberFormatException {
        int counter = 0;
        int[] numbers = new int[numberStrings.length];
        for (String s : numberStrings) {
            numbers[counter++] = parseNumber(s);
        }
        return numbers;
    }

    private static int parseNumber(String number) throws NumberFormatException {
        int num = Integer.parseInt(number);
        if (num <= 0) {
            throw new NumberFormatException("Error: Number " + num + " is not higher than 0!");
        }
        return num;
    }

    public void validate(String[] args) {
        int[] sides = new int[0];
        try {
            sides = parseNumbers(args);
        } catch (NumberFormatException nfe) {
            System.out.println("Error:");
            System.out.println(nfe.getMessage());
        }

        if (sides.length == 3) {
            figure = new Figure(sides[0], sides[1], sides[2]);
            checkForTriangle.checkIfTriangleCanBeBuilt(figure);
        } else if (sides.length == 4) {
            figure = new Figure(sides[0], sides[1], sides[2], sides[3]);
            fourSidesCheck.checkIfFourSidedFigureCanBeBuilt(figure);
        } else {
            System.out.println("You must input 3 or 4 parameters");
        }
    }

}

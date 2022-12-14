import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        start();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter coordinate 1: ");
        String coord1 = input.nextLine();
        int[] xy1 = coordinateToXY(coord1);

        System.out.print("Enter coordinate 2: ");
        String coord2 = input.nextLine();
        int[] xy2 = coordinateToXY(coord2);

        if (xy1[0] == xy2[0]) {
            System.out.println("These points share a vertical line, x = " + xy1[0]);
        } else {
            LinearEquation linEq = new LinearEquation(xy1[0], xy1[1], xy2[0], xy2[1]);

            System.out.print(linEq.lineInfo());

            System.out.print("\nEnter a value for x: ");
            double xValue = input.nextDouble();
            System.out.println("\nThe point on the line is " + linEq.coordinateForX(xValue));
        }


    }

    public static void start() {
        System.out.println("\nWelcome to the Linear Equation Runner Program!\n");
    }

    // Turn a string in form "(x, y)" to an integer array of the numbers x and y
    public static int[] coordinateToXY(String coord) {
        // Remove (), split by comma -> (x, y) -> x, y -> {x, y}
        String[] vals = coord.replace("(", "").replace(")", "").split(",");
        // Remove whitespace, parse integer values
        // If no int, set to 0
        int xVal, yVal;

        try {
            xVal = Integer.parseInt(vals[0].strip());
        } catch (Exception e) {
            xVal = 0;
        }

        try {
            yVal = Integer.parseInt(vals[1].strip());
        } catch (Exception e) {
            yVal = 0;
        }

        // Return values
        return new int[]{xVal, yVal};
    }
}

// if no input for number, make it zero
// simplify fractions
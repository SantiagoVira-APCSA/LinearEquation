import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter coordinate 1: ");
        String coord1 = input.nextLine();
        int[] xy1 = coordinateToXY(coord1);

        System.out.print("Enter coordinate 2: ");
        String coord2 = input.nextLine();
        int[] xy2 = coordinateToXY(coord2);

        LinearEquation linEq = new LinearEquation(xy1[0], xy1[1], xy2[0], xy2[1]);

        System.out.print(linEq.lineInfo());

        System.out.print("\nEnter a value for x: ");
        double xValue = input.nextDouble();
        System.out.println("\nThe point on the line is " + linEq.coordinateForX(xValue));

    }

    public static int[] coordinateToXY(String coord) {
        String[] vals = coord.substring(1, coord.length() - 1).split(",");
        int[] xy = {Integer.parseInt(vals[0].strip()), Integer.parseInt(vals[1].strip())};
        return xy;
    }
}

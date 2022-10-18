public class LinearEquation {
    private double x1, y1, x2, y2;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double roundedToHundredth(double toRound) {
        return (Math.round(toRound * 100)) / 100.0;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    public double slope() {
        return roundedToHundredth((y2 - y1) / (x2 - x1));
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        double yInt = yIntercept();
        double slope = slope();

        if (x1 == x2) {
            return "These points share a vertical line";
        }
        if (slope == 0) {
            return "y = " + truncateZero(yInt);
        }

        String slopeString = slope < 0 ? "-" : "";
        if (Math.abs(slope) != 1) {
            if (slope == (int) slope) {
                slopeString += truncateZero(Math.abs(y2 - y1));
            } else {
                slopeString += truncateZero(Math.abs(y2 - y1)) + "/" + truncateZero(Math.abs(x2 - x1));
            }
        }

        String intString;
        if (yInt == 0) {
            intString = "";
        } else if (yInt > 0) {
            intString = " + " + truncateZero(yInt);
        } else {
            intString = " - " + truncateZero(Math.abs(yInt));
        }

        return "y = " + slopeString + "x" + intString;
    }


    public String coordinateForX(double xValue) {
        double yValue = roundedToHundredth(slope() * xValue + yIntercept());
        return "(" + truncateZero(roundedToHundredth(xValue)) + ", " + truncateZero(yValue) + ")";
    }


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        return "\nThe two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) +
                "\nThe equation of the line that intersects these points is " + equation() +
                "\nThe slope of this line is " + truncateZero(slope()) +
                "\nThe y-intercept of this line is " + truncateZero(yIntercept()) +
                "\nThe distance between the two points is " + truncateZero(distance()) + "\n";
    }

    public String truncateZero(double value) {
        return "" + ((int) value == value ? value : (int) value);
    }

}

public class LinearEquation {
    // Instance Variables
    private double x1, y1, x2, y2;

    // Constructor
    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Returns a given value rounded to the nearest hundredth
    public double roundedToHundredth(double toRound) {
        return (Math.round(toRound * 100)) / 100.0;
    }

    // Returns the distance between the two points rounded to the nearest hundredth
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    // Returns the y-intercept value for the line that intersects the two points
    // rounded to the nearest hundredth
    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    // Returns the slope value for the line that intersects the two points
    // rounded to the nearest hundredth
    public double slope() {
        return roundedToHundredth((y2 - y1) / (x2 - x1));
    }

    // Returns a string with the equation for the line that intersects the two points
    public String equation() {
        // Establish constant values
        final double yInt = yIntercept();
        final double slope = slope();

        // Handle horizontal line
        if (slope == 0) {
            return "y = " + truncateZero(yInt);
        }

        // Find all information about presenting the slope
        String slopeString = slope < 0 ? "-" : "";
        // If slope is not 1 or -1 (needs more than just a sign)
        if (Math.abs(slope) != 1) {
            // If it is an integer m, don't display m/1, just m
            if (slope == (int) slope) {
                slopeString += truncateZero(Math.abs(slope));
            }
            // Otherwise show the slope as calculated
            else {
                slopeString += truncateZero(Math.abs(y2 - y1)) + "/" + truncateZero(Math.abs(x2 - x1));
            }
        }

        // Find all information about presenting the y-intercept
        String intString;
        // No y-intercept -> display nothing
        if (yInt == 0) {
            intString = "";
        }
        // Positive y-intercept -> display "+" and the value
        else if (yInt > 0) {
            intString = " + " + truncateZero(yInt);
        }
        // Negative y-intercept -> display "-" and absolute value of intercept formatted neatly
        else {
            intString = " - " + truncateZero(Math.abs(yInt));
        }

        // Return all pieces assembled
        return "y = " + slopeString + "x" + intString;
    }

    // Returns a coordinate pair in form (x, y) the intersects the same line that intersects
    // the two pointsgiven x
    public String coordinateForX(double xValue) {
        double yValue = roundedToHundredth(slope() * xValue + yIntercept());
        return "(" + truncateZero(roundedToHundredth(xValue)) + ", " + truncateZero(yValue) + ")";
    }

    // Returns string with all information about the line that intersects the two points
    public String lineInfo() {
        if (x1 == x2) {
            return "The two points share a vertical line";
        }
        return "\nThe two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) +
                "\nThe equation of the line that intersects these points is " + equation() +
                "\nThe slope of this line is " + truncateZero(slope()) +
                "\nThe y-intercept of this line is " + truncateZero(yIntercept()) +
                "\nThe distance between the two points is " + truncateZero(distance()) + "\n";
    }


    // Returns a string with either the supplied value or an integer
    // version of the supplied value if equivalent
    // (ex. 4.0 -> "4", 4.1 -> "4.1")
    public String truncateZero(double value) {
        if ((int) value == value) {
            return "" + (int) value;
        }
        return "" + value;
    }

}

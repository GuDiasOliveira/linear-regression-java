public class LinearRegression {

    private double[] x, y;


    public LinearRegression(double[] x, double[] y) throws IllegalArgumentException {
        // Don't let the X and Y sets have different length
        if (x.length != y.length)
            throw new IllegalArgumentException("The lengths of the sets of X and Y must be the same");

        // Setting the X and Y sets
        this.x = x;
        this.y = y;
    }


    public LinearRegressionResult calculate() throws IllegalArgumentException {
        LinearRegressionResult result = new LinearRegressionResult();

        // Getting N (the quantity of values)
        int n = x.length;
        // Calculating the sums parameters
        double x1, y1, xy, x2;
        x1 = y1 = xy = x2 = 0.0;
        for (int i=0; i<n; i++) {
            x1 += x[i];
            y1 += y[i];
            xy += x[i] * y[i];
            x2 += x[i] * x[i];
        }
        // Finally, calculating the final parameters A and B
        result.a = (n*xy - x1*y1) / (n*x2 - x1*x1);
        result.b = (x2*y1 - xy*x1) / (n*x2 - x1*x1);

        // Returning the result
        return result;
    }
}
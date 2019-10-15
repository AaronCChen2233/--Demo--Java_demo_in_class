public class MortgageCalculator {
    public static double calculatMortgage(double principal, double rate, double month) {
        double m;
        m = principal * ((rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate, month) - 1));
        return m;
    }
}

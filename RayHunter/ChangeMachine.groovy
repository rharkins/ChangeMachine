import Denominations

/**
 * ChangeMachine
 *
 * Rounding is done with half down.
 *
 * @author Ray Hunter ray.hunter@stgconsulting.com
 */
class ChangeMachine {

    private static final BigDecimal HUNDRED = new BigDecimal(100.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal FIFTY = new BigDecimal(50.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal TWENTY = new BigDecimal(20.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal TEN = new BigDecimal(10.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal FIVE = new BigDecimal(5.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal QUARTER = new BigDecimal(0.25).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal DIME = new BigDecimal(0.10).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal NICKEL = new BigDecimal(0.05).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal ZERO = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_DOWN);

    def static makeChange(String input) {

        assert !input.empty;

        print "Input: " + input + "\t\t";

        BigDecimal money;
        try {
            money = new BigDecimal(input).setScale(2, BigDecimal.ROUND_HALF_DOWN);

            if (!money.equals(ZERO)) {
                calculateChange(money);
            } else {
                println "Currency is Zero!";
            }

        } catch (NumberFormatException ex) {
            println "Invalid input: " + input;
        }

    }

    /**
     * Calculate the dollars and change.
     *
     * @param currency BigDecimal
     */
    private static calculateChange(BigDecimal currency) {

        def denomination = new Denominations();

        // calculate $100s
        if (currency.compareTo(HUNDRED) >= 0) {
            denomination.hundreds = currency.divideToIntegralValue(HUNDRED).intValue();
            currency = currency.subtract(HUNDRED * denomination.hundreds);
        }

        // calculate $50s
        if (currency.compareTo(FIFTY) >= 0) {
            denomination.fifties = currency.divideToIntegralValue(FIFTY).intValue();
            currency = currency.subtract(FIFTY * denomination.fifties);
        }

        // calculate $20s
        if (currency.compareTo(TWENTY) >= 0) {
            denomination.twenties = currency.divideToIntegralValue(TWENTY).intValue();
            currency = currency.subtract(TWENTY * denomination.twenties);
        }

        // calculate $10s
        if (currency.compareTo(TEN) >= 0) {
            denomination.tens = currency.divideToIntegralValue(TEN).intValue();
            currency = currency.subtract(TEN * denomination.tens);
        }

        // calculate $5s
        if (currency.compareTo(FIVE) >= 0) {
            denomination.fives = currency.divideToIntegralValue(FIVE).intValue();
            currency = currency.subtract(FIVE * denomination.fives);
        }

        // calculate $1s
        denomination.ones = currency.intValue();

        // calculate the remainder
        BigDecimal remainder = currency.remainder(BigDecimal.ONE).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        if (!remainder.equals(ZERO)) {

            // calculate 0.25s
            if (remainder.compareTo(QUARTER) >= 0) {
                denomination.quarters = remainder.divideToIntegralValue(QUARTER).intValue()
                remainder = remainder.subtract(QUARTER * denomination.quarters);
            }

            // calculate 0.10s
            if (remainder.compareTo(DIME) >= 0) {
                denomination.dimes = remainder.divideToIntegralValue(DIME).intValue()
                remainder = remainder.subtract(DIME * denomination.dimes);
            }

            // calculate 0.05s
            if (remainder.compareTo(NICKEL) >= 0) {
                denomination.nickles = remainder.divideToIntegralValue(NICKEL).intValue()
                remainder = remainder.subtract(NICKEL * denomination.nickles)
            }

            // calculate 0.01s
            denomination.pennies = remainder.multiply(100).intValue()
        }

        println denomination.toString()
    }

}
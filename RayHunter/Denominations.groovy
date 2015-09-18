/**
 * Class to handle the denominations.
 *
 * @author Ray Hunter ray.hunter@stgutah.com
 */
class Denominations {

    def hundreds = 0;
    def fifties = 0;
    def twenties = 0;
    def tens = 0;
    def fives = 0;
    def ones = 0;
    def quarters = 0;
    def dimes = 0;
    def nickles = 0;
    def pennies = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (hundreds > 0) {
            sb.append(hundreds).append(" \$100 bill, ")
        }

        if (fifties > 0) {
            sb.append(fifties).append(" \$50 bill, ")
        }

        if (twenties > 0) {
            sb.append(twenties).append(" \$20 bill, ")
        }

        if (tens > 0) {
            sb.append(tens).append(" \$10 bill, ")
        }

        if (fives > 0) {
            sb.append(fives).append(" \$5 bill, ")
        }

        if (ones > 0) {
            sb.append(ones).append(" \$1 bill, ")
        }

        if (quarters > 0) {
            sb.append(quarters).append(" quarters, ")
        }

        if (dimes > 0) {
            sb.append(dimes).append(" dimes, ")
        }

        if (nickles > 0) {
            sb.append(nickles).append(" nickles, ")
        }

        if (pennies > 0) {
            sb.append(pennies).append(" pennies, ")
        }

        def result = sb.toString()
        def index = result.lastIndexOf(",")

        return result.substring(0, index);
    }
}

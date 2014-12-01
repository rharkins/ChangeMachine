import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class HeyMisterYouGotChange {
	
	public enum Denomination {
		HUNDRED(new BigDecimal(100),"Hundred"),
		FIFTY(new BigDecimal(50),"Fifty"),
		TWENTY(new BigDecimal(20),"Twenty"),
		TEN(new BigDecimal(10),"Ten"),
		FIVE(new BigDecimal(5),"Five"),
		ONE(new BigDecimal(1),"One"),
		QUARTER(new BigDecimal(0.25),"Quarter"),
		DIME(new BigDecimal(0.1),"Dime"),
		NICKEL(new BigDecimal(0.05),"Nickel"),
		PENNY(new BigDecimal(0.01),"Penny");
		
		private BigDecimal value;
		private String desc;
		
		private Denomination(BigDecimal value, String desc) {
			this.value = value;
			this.desc = desc;
		}
		
		public BigDecimal getValue() {return this.value;}
		public String getSingular() {return this.desc;}
	}
	
	
	public HeyMisterYouGotChange(BigDecimal changeToGive) {
		if (changeToGive == null) {
			System.out.println("Give me a break.. and some money!");
		}
		else {
			System.out.println("Total change to give: " + NumberFormat.getCurrencyInstance().format(changeToGive));
			coughUpTheGoodness(scale(changeToGive));
		}
	}

	
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter in some monetary values. Any other value will quit.");
		System.out.println("You can try 186.41 for all denominations\n");
		while (s.hasNextBigDecimal()) {
			BigDecimal next = s.nextBigDecimal();
			if (next.compareTo(BigDecimal.ZERO) < 0) {
				System.out.println("Sorry, you owe me money!!!");
				break;
			}
			new HeyMisterYouGotChange(next);
		}
		System.out.println("Exiting.");
	}
	
	void coughUpTheGoodness(BigDecimal changeToGive) {
		BigDecimal remainingValue = scale(changeToGive);
		
		for (Denomination d : Denomination.values()) {
			if (remainingValue.equals(scale(BigDecimal.ZERO))) { break; }
			
			BigDecimal[] divRem = remainingValue.divideAndRemainder(scale(d.getValue()));
			BigDecimal remainder = divRem[0];
			remainingValue = divRem[1];
			if (remainder.compareTo(BigDecimal.ZERO) > 0) {
				System.out.println("\t"+remainder+" "+pluralizificationedness(d, remainder));
			}
			switch(d) {
				case PENNY:
					System.out.println("Hey, I know you! You're the guy that gave me that double-die Denver mint penny!\n Oh, thanks a lot, Mister! That thing was worth a fortune!\n When I cashed it in, I had enough money to buy a whole bunch of shares,\n and, I got me a real NEAT watch! It's a Rolex! See?! ");
				default:
					break;
			} 
		}
	}
	
	static String pluralizificationedness(Denomination d, BigDecimal remainder) {
		String desc = (remainder.compareTo(BigDecimal.ONE) > 0) 
				? (d.getSingular().endsWith("y") 
						? d.getSingular().substring(0,d.getSingular().length()-1)+"ies" 
						: d.getSingular()+"s")
				: d.getSingular();
		return desc; 
	}
	
	static BigDecimal scale(BigDecimal val) {
		return val.setScale(2, RoundingMode.HALF_UP);
	}
}


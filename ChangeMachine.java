package ChangeMachine;

import java.lang.Math;

public class ChangeMachine {
	
	public void CalculateChange(double dblMakeChangeAmount)
	{
		int intStartingDollars = (int) Math.floor(dblMakeChangeAmount);
		int intRemainingDollars = intStartingDollars;
		int intStartingChange = (int) (Math.round(100 * (dblMakeChangeAmount - Math.floor(dblMakeChangeAmount))));
		int intRemainingChange = intStartingChange;
		int intHundreds = 0;
		int intFiftys = 0;
		int intTwentys = 0;
		int intTens = 0;
		int intFives = 0;
		int intOnes = 0;
		int intQuarters = 0;
		int intDimes = 0;
		int intNickles = 0;
		int intPennies = 0;
		boolean FirstPrint = false;
		// Create ChangeMachineOutput variable and set initial value to the MakeChangeAmount
		java.lang.String ChangeMachineOutput = dblMakeChangeAmount + " -> ";
		
		// Calculate number of 100s
		intHundreds = intRemainingDollars / 100;
		// Subtract number of hundreds from remaining dollars
		intRemainingDollars = intRemainingDollars - (intHundreds * 100);
		// If there are hundreds, set first print variable to true - this is the first currency printed
		if (intHundreds != 0)
			FirstPrint = true;
		// If there is only 1 hundred dollar bill, output is singular
		if (intHundreds == 1)
		{ 
			ChangeMachineOutput = ChangeMachineOutput + "1 $100 bill";
		}
		// If there are 2 or more hundred dollar bills, output is plural
		else if (intHundreds > 1)
		{
			ChangeMachineOutput = ChangeMachineOutput + intHundreds + " $100 bills";
		}
		// This will print the number of $100 bills on a separate line - used for debugging purposes
		//System.out.println("Hundreds - " + intHundreds);
		
		// Calculate number of 50s
		intFiftys = intRemainingDollars / 50;
		// Subtract number of fifties from remaining dollars
		intRemainingDollars = intRemainingDollars - (intFiftys * 50);
		// Check if there is only 1 fifty dollar bill, output is singular
		if (intFiftys == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = "1 $50 bill ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 $50 bill";
		}
		// This will print the number of $50 bills on a separate line - used for debugging purposes
		//System.out.println("Fiftys - " + intFiftys);
		
		// Calculate number of 20s
		intTwentys = intRemainingDollars / 20;
		// Subtract number of twenties from remaining dollars
		intRemainingDollars = intRemainingDollars - (intTwentys * 20);
		// Check if there is only 1 twenty dollar bill, output is singular
		if (intTwentys == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = "1 $20 bill ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 $20 bill";
		}
		// If there are 2 or more twenty dollar bills, output is plural
		if (intTwentys > 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = intTwentys + " $20 bills";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", " + intTwentys + " $20 bills";
		}
		// This will print the number of $20 bills on a separate line - used for debugging purposes
		//System.out.println("Twentys - " + intTwentys);
		
		// Calculate number of 10s
		intTens = intRemainingDollars / 10;
		// Subtract number of tens from remaining dollars
		intRemainingDollars = intRemainingDollars - (intTens * 10);
		// Check if there is only 1 ten dollar bill, output is singular
		if (intTens == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = "1 $10 bill ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 $10 bill";
		}
		// This will print the number of $10 bills on a separate line - used for debugging purposes
		//System.out.println("Tens - " + intTens);
		
		// Calculate number of 5s
		intFives = intRemainingDollars / 5;
		// Subtract number of fives from remaining dollars
		intRemainingDollars = intRemainingDollars - (intFives * 5);
		// Check if there is only 1 five dollar bill, output is singular
		if (intFives == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = "1 $5 bill ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 $5 bill";
		}
		// This will print the number of $5 bills on a separate line - used for debugging purposes
		//System.out.println("Fives - " + intFives);
		
		// Calculate number of 1s
		// Subtract number of ones from remaining dollars
		intOnes = intRemainingDollars;
		// Check if there is only 1 one dollar bill, output is singular
		if (intOnes == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = "1 $1 bill ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 $1 bill";
		}
		// If there are 2 or more one dollar bills, output is plural
		if (intOnes > 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = intOnes + " $1 bills";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", " + intOnes + " $1 bills";
		}
		// This will print the number of $1 bills on a separate line - used for debugging purposes
		//System.out.println("Ones - " + intOnes);
		
		// Calculate number of Quarters
		intQuarters = intRemainingChange / 25;
		// Subtract number of quarters from remaining change
		intRemainingChange = intRemainingChange - (intQuarters * 25);
		// Check if there is only 1 quarter, output is singular
		if (intQuarters == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = ChangeMachineOutput + "1 quarter ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 quarter";
		}
		// If there are 2 or more quarters, output is plural
		if (intQuarters > 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = intQuarters + " quarters";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", " + intQuarters + " quarters";
		}
		// This will print the number of quarters on a separate line - used for debugging purposes
		//System.out.println("Quarters - " + intQuarters);
		
		// Calculate number of Dimes
		intDimes = intRemainingChange / 10;
		// Subtract number of dimes from remaining change
		intRemainingChange = intRemainingChange - (intDimes * 10);
		// Check if there is only 1 dime, output is singular
		if (intDimes == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = ChangeMachineOutput + "1 dime ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 dime";
		}
		// If there are 2 or more dimes, output is plural
		if (intDimes > 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = intDimes + " dimes";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", " + intDimes + " dimes";
		}
		// This will print the number of dimes on a separate line - used for debugging purposes
		//System.out.println("Dimes - " + intDimes);
		
		// Calculate number of Nickles
		intNickles = intRemainingChange / 5;
		// Subtract number of nickles from remaining change
		intRemainingChange = intRemainingChange - (intNickles * 5);
		// Check if there is only 1 nickle, output is singular
		if (intNickles == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = ChangeMachineOutput + "1 nickle ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 nickle";
		}
		// This will print the number of nickles on a separate line - used for debugging purposes
		//System.out.println("Nickles - " + intNickles);
		
		// Calculate number of Pennies
		// Subtract number of pennies from remaining change
		intPennies = intRemainingChange;
		// Check if there is only 1 penny, output is singular
		if (intPennies == 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = ChangeMachineOutput + "1 penny ";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", 1 penny";
		}
		// If there are 2 or more pennies, output is plural
		if (intPennies > 1)
		{
			// Check if this is the first printed currency
			if (FirstPrint == false)
			{
				ChangeMachineOutput = intPennies + " pennies";
				FirstPrint = true;
			}
			// Not the first printed currency, add to existing currency in output
			else
				ChangeMachineOutput = ChangeMachineOutput + ", " + intPennies + " pennies";
		}
		// This will print the number of pennies on a separate line - used for debugging purposes
		//System.out.println("Pennies - " + intPennies);
		
		// This is the final print statement for the ChangeMachine output
		System.out.println(ChangeMachineOutput);
		
	}
	
}

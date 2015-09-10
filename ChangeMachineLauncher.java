
package ChangeMachine;

public class ChangeMachineLauncher {

	public static void main(String[] args) 
	{
		// Create a new ChangeMachine object
		ChangeMachine myChangeMachine = new ChangeMachine();
		// Call the CalculateChange method, passing the value to be processed
		myChangeMachine.CalculateChange(999.99);

	}

}

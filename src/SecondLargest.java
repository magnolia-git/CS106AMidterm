import acm.program.ConsoleProgram;
public class SecondLargest extends ConsoleProgram {
	
	// Instance variables
	
	public static int largest = 0;
	public static int secondLargest = 0;
	public static int userInput = 0;
	
	public void run() {
		println("This program finds the two largest integers in a list."
				+ " Enter values, one per line, using a 0 to signal the end of the list.");
		while (true) {
			
			userInput = readInt(" ? ");
		
			if (userInput == 0) break; 
			
			if (userInput > largest) {
				largest = userInput;
			} else if (userInput <= largest && userInput >= secondLargest) {
				secondLargest = userInput;
			}
		}
		println("The largest value is " + largest);
		println("The second largest is " + secondLargest);
	}	
}
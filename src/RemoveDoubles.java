
public class RemoveDoubles {
	public static void main(String[] args) {
		
		System.out.println(removeDoubledLetters("Snoot Boop"));
	}
	
	public static String removeDoubledLetters(String string) {
		String newString = ""; 
		newString += string.charAt(0);
		
		for (int i = 1; i < string.length(); i++) {
			char cha = string.charAt(i);
			if (cha != string.charAt(i - 1)) { 
				newString += cha;
			}
		}
		return newString;
	}
}
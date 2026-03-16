package strings;

public class StringAlgo {
	/**
	 * @param str Non null string of length minimum 2
	 * @param charsToShift Total number of characters to shift
	 * 
	 * @throws NullPointerException If the given input string is null
	 * @throws StringIndexOutOfBoundsException
	 * If the given input string length < 2
	 * 
	 * @return Returns first 2 characters shifted to last of the string
	 */
	public String shiftCharsToLast(String str, int charsToShift) {
		if(str == null)
			throw new NullPointerException("Input string cannot be null");
		
		int appendAt = str.length();

		String newStr = str.substring(charsToShift, appendAt);
		newStr += str.substring(0, charsToShift);
		return newStr;
	}
	
	public String getFromDB() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "This is DB value";
	}
}

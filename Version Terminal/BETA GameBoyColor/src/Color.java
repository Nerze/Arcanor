package tools;

/**
 * This class allow us to print colors into the terminal
 */
public class Color{
	
	// usage : String text = cBLACK + "This is a Black text" + cfin;
	public static final String cfin = "\u001B[0m";
	public static final String cBLACK = "\u001B[30m";
	public static final String cRED = "\u001B[31m";
	public static final String cGREEN = "\u001B[32m";
	public static final String cYELLOW = "\u001B[33m";
	public static final String cBLUE = "\u001B[34m";
	public static final String cPURPLE = "\u001B[35m";
	public static final String cCYAN = "\u001B[36m";
	public static final String cWHITE = "\u001B[37m";

	// usage : String text = bBLACK + "This text has a black background" + cfin;
	public static final String bBLACK = "\u001B[40m";
	public static final String bRED = "\u001B[41m";
	public static final String bGREEN = "\u001B[42m";
	public static final String bYELLOW = "\u001B[43m";
	public static final String bBLUE = "\u001B[44m";
	public static final String bPURPLE = "\u001B[45m";
	public static final String bCYAN = "\u001B[46m";
	public static final String bWHITE = "\u001B[47m";

}

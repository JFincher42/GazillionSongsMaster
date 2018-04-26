package gazillionSongs;

/**
 * Range class
 * Defines an integer range as the span between a minimum and maximum
 * The minimum is assumed to be less than the maximum, but this is not enforced
 * 
 * @author jfincher42@gmail.com
 *
 */
public class Range {
	
	// Fields
	private int min, max;			// Minimum and maximum of int range

	// Constructor
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Range constructor
	 * Splits the range string at the dash (-), and converts each part into an integer
	 * Assumes the string has a dash in it - will fail otherwise
	 */
	public Range(String rangeString) {
		String[] extents = rangeString.split("-");
		this.min = Integer.parseInt(extents[0]);
		this.max = Integer.parseInt(extents[1]);
	}

	/**
	 * getMin returns the range's minimum
	 * @return range minimum
	 */
	public int getMin() {
		return min;
	}

	/**
	 * setMin sets the range's minimum
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * getMax returns the range's maximum
	 * @return range maximum
	 */
	public int getMax() {
		return max;
	}

	/**
	 * setMax sets the range's maximum
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * contains - does this range contain this specified value?
	 * @return true if the value is within the range, false otherwise
	 */
	public boolean contains(int value) {
		return (value>=this.min && value<=this.max);
	}
	
	/**
	 * isValid - verifies that the range provided is valid.
	 * A range is valid if:
	 *  - it's a single number, or
	 *  - it's two numbers separated by a single dash character (-) AND
	 *    the first number is less than or equal to the right number
	 * 
	 * @return true if the range is valid, false otherwise
	 */
	public static boolean isValid(String rangeString){
		if (rangeString.contains("-")) {
			String[] extents = rangeString.split("-");
			return (Integer.parseInt(extents[0]) <= Integer.parseInt(extents[1]));
		} else return true;
	}
	
}

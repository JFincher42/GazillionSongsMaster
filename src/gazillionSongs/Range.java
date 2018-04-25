package gazillionSongs;

/**
 * Range class - encapsulates checking for values in ranges
 * @author fincherj
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
	
	public Range(String rangeString) {
		String[] extents = rangeString.split("-");
		this.min = Integer.parseInt(extents[0]);
		this.max = Integer.parseInt(extents[1]);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public boolean contains(int value) {
		return (value>=this.min && value<=this.max);
	}
	
	public static boolean isValid(String rangeString){
		if (rangeString.contains("-")) {
			String[] extents = rangeString.split("-");
			return (Integer.parseInt(extents[0]) <= Integer.parseInt(extents[1]));
		} else return true;
	}
	
}

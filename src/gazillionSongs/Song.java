package gazillionSongs;

/**
 * Song class - holds all the data about a single song
 * 
 * @author fincherj
 *
 */

public class Song {

	// Fields
	private int year; 			// The year the song was releases
	private int rank; 			// What rank the song reached
	private String artist; 		// Who is the artist
	private String title; 		// Song title

	// Constructor
	public Song(int year, int rank, String artist, String title) {
		this.year = year;
		this.rank = rank;
		this.artist = artist;
		this.title = title;
	}

	// Getters and Setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * toString
	 * 
	 * Uses the same output format as input expected
	 */
	public String toString() {
		// Need to start with an empty string since the first element is an int
		return "" + this.year + "\t" + this.rank + "\t" + this.artist + "\t" + this.title;
	}

	/**
	 * compareTo - compares this song to another, based on the provided field
	 * 
	 * @param otherSong The other Song to compare
	 * @param field Which field do we use for the comparison?
	 * @return negative if this Song sorts first, positive if otherSong sorts first, and 0 otherwise
	 */
	public int compareTo(Song otherSong, String field) {
		// Since year and rank are integers, simple subtraction gives us the right numbers
		if (field.equals("year"))
			return this.year - otherSong.getYear();
		else if (field.equals("rank"))
			return this.rank - otherSong.getRank();

		// For the string fields, use the string compareTo method, and ignore case
		else if (field.equals("artist"))
			return this.artist.toLowerCase().compareTo(otherSong.getArtist().toLowerCase());
		else if (field.equals("title"))
			return this.title.toLowerCase().compareTo(otherSong.getTitle().toLowerCase());
		
		// Some other field, so we guess they're equal
		else
			return 0;
	}

	/**
	 * isMatch - does the data provided match what this song contains?
	 * 
	 * @param field What field are we inspecting?
	 * @param value For what value are we looking?
	 */
	public boolean isMatch(String field, String value) {
		// Years can have a range, so check for that
		if (field.equals("year")) {
			if (value.contains("-")) {
				Range range = new Range(value);
				return range.contains(this.year);
			}
			else return (this.year == Integer.parseInt(value));
		}

		// Ranks can have ranges as well
		else if (field.equals("rank"))
			if (value.contains("-")) {
				Range range = new Range(value);
				return range.contains(this.rank);
			}
			else return this.rank == Integer.parseInt(value);

		// The string fields should just use the String.contains() method, ignoring case
		else if (field.equals("artist"))
			return this.artist.toLowerCase().contains(value.toLowerCase());
		else if (field.equals("title"))
			return this.title.toLowerCase().contains(value.toLowerCase());

		// We should never ever get here, but if we do...
		else
			return false;
	}
}

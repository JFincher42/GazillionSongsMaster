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

	public int compareTo(Song otherSong, String field) {
		if (field.equals("year"))
			return this.year - otherSong.getYear();
		else if (field.equals("rank"))
			return this.rank - otherSong.getRank();
		else if (field.equals("artist"))
			return this.artist.toLowerCase().compareTo(otherSong.getArtist().toLowerCase());
		else if (field.equals("title"))
			return this.title.toLowerCase().compareTo(otherSong.getTitle().toLowerCase());
		else
			return 0;
	}

	public boolean isMatch(String field, String value) {
		if (field.equals("year")) {
			if (value.contains("-")) {
				Range range = new Range(value);
				return range.contains(this.year);
			}
			else return (this.year == Integer.parseInt(value));
		}
		else if (field.equals("rank"))
			if (value.contains("-")) {
				Range range = new Range(value);
				return range.contains(this.rank);
			}
			else return this.rank == Integer.parseInt(value);
		else if (field.equals("artist"))
			return this.artist.toLowerCase().contains(value.toLowerCase());
		else if (field.equals("title"))
			return this.title.toLowerCase().contains(value.toLowerCase());
		else
			return false;
	}
}

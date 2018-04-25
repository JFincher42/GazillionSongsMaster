package gazillionSongs;

import java.util.ArrayList;
import java.io.PrintStream;

/**
 * SongCollection - implements a collection of Song objects
 * @author fincherj
 *
 */
public class SongCollection {

	// THe once and future list o' songs
	private ArrayList<Song> songList;

	// What are valid fields?  Used for error checking
	private ArrayList<String> validFields = new ArrayList<String>();

	// Constructor
	public SongCollection() {
		songList = new ArrayList<Song>();
		validFields.add("year");
		validFields.add("rank");
		validFields.add("artist");
		validFields.add("title");
	}

	/**
	 * addSong - parses a line and adds a new Song to the list
	 * 			 Splits the line into four parts
	 * 			 parses each part, then adds a new Song to the list
	 * 
	 * @param songLine One line from a song file
	 */
	public void addSong(String songLine) {
		String[] songData = songLine.split("\t");

		int year = Integer.parseInt(songData[0]);
		int rank = Integer.parseInt(songData[1]);
		String artist = songData[2];
		String title = songData[3];

		songList.add(new Song(year, rank, artist, title));
	}

	/**
	 * filter - restricts the items in a list to those that fit a set criteria
	 */
	public boolean filter(String field, String data) {
		// Check that the field and data are valid
		if (validate(field, data)){
			for (int i = songList.size() - 1; i >= 0; i--) {
				if (!songList.get(i).isMatch(field, data)) {
					songList.remove(i);
				}
			}
			return true;
		} else
			return false;
	}

	public boolean selectionSort(String field) {
		// Check that the field is valid
		if (validFields.contains(field.toLowerCase())) {

			for (int i = 0; i < songList.size() - 1; i++) {
				int minimum = i;
				for (int j = i; j < songList.size(); j++) {
					if (songList.get(j).compareTo(songList.get(minimum), field) < 0) {
						minimum = j;
					}
				}
				swap(minimum, i);
			}
			return true;
		} else
			return false;
	}

	public boolean insertionSort(String field) {
		// Check that the field is valid
		if (validFields.contains(field.toLowerCase())) {
			for (int j = 1; j < songList.size(); j++) {
				Song value = songList.get(j); // value is the next element to insert
				int possibleIndex = j;
				while (possibleIndex > 0 && value.compareTo(songList.get(possibleIndex - 1), field) < 0) {
					songList.set(possibleIndex, songList.get(possibleIndex - 1));
					possibleIndex--;
				}
				songList.set(possibleIndex, value); // put value in its place!
			}
			return true;
		} else
			return false;
	}

	public boolean mergeSort(String field) {
		// Check that the field is valid
		if (validFields.contains(field.toLowerCase())) {

			int n = songList.size();
			ArrayList<Song> temp = new ArrayList<Song>(songList);
			mergeSortX(songList, 0, n - 1, temp, field);

			return true;
		} else
			return false;
	}

	private void mergeSortX(ArrayList<Song> orig, int from, int to, ArrayList<Song> temp, String field) {
		// If from >= to, then there's nothing to sort
		if (from < to) {
			// Calculate the middle element, then sort each half
			int middle = (from + to) / 2;
			mergeSortX(orig, from, middle, temp, field);
			mergeSortX(orig, middle + 1, to, temp, field);
			// When done, merge the two sorted halves together
			merge(orig, from, middle, to, temp, field);
		}
	}

	private void merge(ArrayList<Song> orig, int from, int middle, int to, ArrayList<Song> temp, String field) {
		int nextLeft = from; // The next element of the left section
		int nextRight = middle + 1; // The next element of the right section
		int nextMerge = from; // Where to put the next lowest element in temp

		// If there are elements in both sections
		while (nextLeft <= middle && nextRight <= to) {
			// Find the lowest element, and copy it to temp
			// We can simplify this a bit
			if (orig.get(nextLeft).compareTo(orig.get(nextRight), field) < 0)
				temp.set(nextMerge, orig.get(nextLeft++));
			else
				temp.set(nextMerge, orig.get(nextRight++));
			nextMerge++;
		}

		// Does the left section have any elements remaining? Copy them over
		while (nextLeft <= middle)
			temp.set(nextMerge++, orig.get(nextLeft++));

		// Does the right section have anay elements remaining? Copy them over
		while (nextRight <= to)
			temp.set(nextMerge++, orig.get(nextRight++));

		// Now blast the whole thing back into the source array
		for (int copyMerge = from; copyMerge <= to; copyMerge++)
			orig.set(copyMerge, temp.get(copyMerge));
	}

	public boolean quickSort(String field) {

		return true;
	}

	/**
	 * printSongs - outputs the entire list of songs to the specified stream
	 * @param output
	 */
	public void printSongs(PrintStream output) {
		for (Song song : songList) {
			output.println(song);
		}
	}

	private void swap(int i, int j) {
		Song temp = songList.get(i);
		songList.set(i, songList.get(j));
		songList.set(j, temp);
	}

	/**
	 * validate - ensures the field and data are valid
	 */
	private boolean validate(String field, String data){
		return (validFields.contains(field.toLowerCase())) && (Range.isValid(data));
	}
}
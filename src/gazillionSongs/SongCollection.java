package gazillionSongs;

import java.util.ArrayList;
import java.io.PrintStream;

/**
 * SongCollection - implements a collection of Song objects
 * @author jfincher42@gmail.com
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

		// validFields is used to verify what valid field names are
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
	 * 
	 * @param field On which field do we want to filter songs?
	 * @param data What data is used to include songs in the final list?
	 */
	public boolean filter(String field, String data) {
		// Check that the field and data are valid
		if (validate(field, data)){
			// Start the scan from the end
			// That way, when we remove something, the index is always less than the length
			for (int i = songList.size() - 1; i >= 0; i--) {
				if (!songList.get(i).isMatch(field, data)) {
					songList.remove(i);
				}
			}
			// Success!
			return true;
		} else
			// Bad data, no soup for you
			return false;
	}

	/**
	 * selectionSort - sorts data ascending using a selection sort algorithm
	 * 
	 * @param field On which field do we want to sort?
	 */
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

	/**
	 * insertionSort - sorts data ascending using an insertion sort algorithm
	 * 
	 * @param field On which field do we want to sort?
	 */
	public boolean insertionSort(String field) {
		// Check that the field is valid
		if (validFields.contains(field.toLowerCase())) {

			for (int j = 1; j < songList.size(); j++) {
				// value is the next element to insert
				Song value = songList.get(j);
				int possibleIndex = j;
				// Walk backwards through the list and find where it gets inserted
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

	/**
	 * mergeSort - sorts data ascending using a merge sort algorithm
	 * 
	 * @param field On which field do we want to sort?
	 */ 
	public boolean mergeSort(String field) {
		// Check that the field is valid
		if (validFields.contains(field.toLowerCase())) {

			// Define the size of the array to sort and a temporary array to hold merge results
			int n = songList.size();
			ArrayList<Song> temp = new ArrayList<Song>(songList);

			// Make the recursive call
			mergeSortX(songList, 0, n - 1, temp, field);

			return true;
		} else
			return false;
	}

	/**
	 * mergeSortX - recursive merge sort routine
	 * 
	 * @param orig An ArrayList<Song> representing the array list to sort
	 * @param from The first element of the ArrayList to sort
	 * @param to The last element of the ArrayList to sort
	 * @param temp An ArrayList<Song> used to hold merge contents
	 * @param field On what field are we sorting the data?
	 */
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

	/**
	 * merge - merge two sorted sections into a single sorted section
	 * 
	 * @param orig An ArrayList<Song> representing the array list to sort
	 * @param from The first element of the left section of the ArrayList
	 * @param middle The mid-point element, and the last item of the left section
	 * @param to The last element of the right section of the ArrayList
	 * @param temp An ArrayList<Song> used to hold merge contents
	 * @param field On what field are we sorting the data?
	 */
	private void merge(ArrayList<Song> orig, int from, int middle, int to, ArrayList<Song> temp, String field) {
		int nextLeft = from; 			// The next element of the left section
		int nextRight = middle + 1; 	// The next element of the right section
		int nextMerge = from; 			// Where to put the next lowest element in temp

		// If there are elements in both sections
		while (nextLeft <= middle && nextRight <= to) {
			// Find the lowest element, and copy it to temp
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

	/**
	 * quickSort - sorts data ascending using a quicksort algorithm
	 * NOT IMPLEMENTED YET
	 */
	public boolean quickSort(String field) {

		return true;
	}

	/**
	 * printSongs - outputs the entire list of songs to the specified stream
	 * @param output A PrintStream object to which to output the list of songs
	 */
	public void printSongs(PrintStream output) {
		for (Song song : songList) {
			output.println(song);
		}
	}

	/**
	 * swap - swaps two Songs at the specified indices
	 * 
	 * @param i The first item to swap
	 * @param j The second item to swap
	 */
	private void swap(int i, int j) {
		Song temp = songList.get(i);
		songList.set(i, songList.get(j));
		songList.set(j, temp);
	}

	/**
	 * validate - ensures the field and data are valid
	 * 
	 * @param field The field name to validate
	 * @param data The data to validate for formatting
	 */
	private boolean validate(String field, String data){
		return (validFields.contains(field.toLowerCase())) && (Range.isValid(data));
	}
}
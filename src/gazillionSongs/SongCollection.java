package gazillionSongs;

import java.util.ArrayList;
import java.io.PrintStream;

/**
 * SongCollection - implements a collection of Song objects
 * @author fincherj
 *
 */
public class SongCollection {

	// Fields
	private ArrayList<Song> songList; // The once and future song list

	// Constructor
	public SongCollection() {
		songList = new ArrayList<Song>();
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

	public boolean filter(String field, String data) {
		for (int i = songList.size() - 1; i >= 0; i--) {
			if (!songList.get(i).isMatch(field, data)) {
				songList.remove(i);
			}
		}
		return true;
	}

	public boolean selectionSort(String field) {
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
	}

	public boolean insertionSort(String field) {
		for (int j = 1; j < songList.size(); j++) {
			Song value = songList.get(j); // value is the next element to insert
			int possibleIndex = j;
			while (possibleIndex > 0 && value.compareTo(songList.get(possibleIndex - 1), field) < 0) {
				songList.set(possibleIndex, songList.get(possibleIndex-1));
				possibleIndex--;
			}
			songList.set(possibleIndex, value); // put value in its place!
		}
		return true;
	}

	public boolean mergeSort(String field) {

		return true;
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
}
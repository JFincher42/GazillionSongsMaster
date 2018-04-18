/*
 * Gazillion Songs Programming Project
 * 
 * AP CS class project
 */

package gazillionSongs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import java.util.Scanner;

public class GazillionSongs {
	public static Scanner userInput;

	public static void main(String[] args) throws FileNotFoundException {
		File outputFile, inputFile;
		FileReader inputFileReader;
		Scanner input;
		PrintStream output;

		// Setup globals
		userInput = new Scanner(System.in);
		// User greeting, get input File
		System.out.println("Welcome to Gazillion Songs!");
		inputFile = getInputFile();
		inputFileReader = new FileReader(inputFile);
		input = new Scanner(inputFileReader);

		// Process input file
		SongCollection sc = new SongCollection();

		while (input.hasNext()) {
			sc.addSong(input.nextLine());
		}
		input.close();
		try {
			inputFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get and process user command
		if (processUserCommand(sc)) {

			// Get output file and dump data
			outputFile = getOutputFile();
			output = new PrintStream(outputFile);

			sc.printSongs(output);
			output.close();
		} else {
			System.out.println("Invalid command.");
		}
		userInput.close();
	}

	public static File getInputFile() {
		boolean validInput = false;
		File inputFile = null;

		userInput.reset();
		System.out.print("What input file do you wish to user? ");
		while (!validInput) {
			String inputFileName = userInput.next();
			inputFile = new File(inputFileName);
			validInput = inputFile.exists();
			if (!validInput)
				System.out.print("Invalid input file - please try again: ");
		}
		return inputFile;
	}

	public static File getOutputFile() {
		boolean outputExists = true;
		File outputFile = null;

		userInput.reset();
		System.out.print("What output file do you wish to user? ");
		while (outputExists) {
			String outputFileName = "";
			while (outputFileName.equals(""))
				outputFileName = userInput.nextLine();
			outputFile = new File(outputFileName);
			outputExists = outputFile.exists();
			if (outputExists) {
				System.out.print("Output file exists - do you want to overwrite? (y/n) ");
				String answer = userInput.next().toLowerCase();
				if (answer.charAt(0) == 'y')
					outputExists = false;
				else
					System.out.print("Enter a new filename: ");
			}
		}
		return outputFile;
	}

	public static boolean processUserCommand(SongCollection sc) {

		System.out.println("Enter command: ");
		String inputLine = "";
		while (inputLine.equals("")) {
			inputLine = userInput.nextLine();
		}
		String[] command = inputLine.split(":");

		// Filter command
		if (command[0].toLowerCase().equals("filter"))
			return sc.filter(command[1], command[2]);
		else if (command[0].toLowerCase().equals("insertionsort"))
			return sc.insertionSort(command[1]);
		else if (command[0].toLowerCase().equals("selectionsort"))
			return sc.selectionSort(command[1]);
		else if (command[0].toLowerCase().equals("mergesort"))
			return sc.mergeSort(command[1]);

		// Invalid command - return false
		return false;

	}

}

/*
 * Gazillion Songs Programming Project
 * 
 * AP CS class project
 * Check out readme.md for details on the project
 */

package gazillionSongs;

/**
 * Imports
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import java.util.Scanner;

import gazillionSongs.SongCollection;

/**
 * Class GazillionSongs
 * Entry point to the entire program
 */
public class GazillionSongs {

	// Used for getting input from the user
	public static Scanner userInput;

	/**
	 * main
	 * 
	 * Since we open files here, we have to handle FileNotFound exceptions
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// Our input and output files, used to test for file existance
		File outputFile, inputFile;

		// Used to read the input file
		FileReader inputFileReader;
		Scanner input;

		// Used to write data to the output file
		PrintStream output;

		// Setup globals
		userInput = new Scanner(System.in);

		// User greeting, get input File
		System.out.println("Welcome to Gazillion Songs!");
		inputFile = getInputFile();
		inputFileReader = new FileReader(inputFile);
		input = new Scanner(inputFileReader);

		// Process input file, close it when we're done
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

		// Get and process the user's command
		processUserCommand(sc);

		// Get output file and dump data
		outputFile = getOutputFile();
		output = new PrintStream(outputFile);
		sc.printSongs(output);

		// Close our streams for completeness
		output.close();
		userInput.close();
	}

	/**
	 * getInputFile
	 * 
	 * Prompts the user for an input file.
	 * 
	 * @return A File object representing the file to use.
	 */
	public static File getInputFile() {
		// Was our request successful?
		boolean success = false;
		
		// Need to set to null to satisfy the linter
		File inputFile = null;

		// Prompt and keep asking until we get a good input file
		System.out.print("What input file do you wish to use? ");
		while (!success) {
			// Keep getting lines until we get something that is real
			String inputFileName = "";
			while (inputFileName.equals(""))
				inputFileName = userInput.nextLine();

			// Check that the file actually exists
			inputFile = new File(inputFileName);
			success = inputFile.exists();
			if (!success)
				System.out.print("Invalid input file. Please try again: ");
		}
		return inputFile;
	}

	/**
	 * getOutputFile
	 * 
	 * Prompts the user for an output file.
	 * 
	 * @return A File object representing the output file to use
	 */
	public static File getOutputFile() {
		boolean outputExists = true;
		File outputFile = null;

		System.out.print("What output file do you wish to use? ");
		while (outputExists) {
			// Keep getting lines until we get something that is real
			String outputFileName = "";
			while (outputFileName.equals(""))
				outputFileName = userInput.nextLine();

			// Check to see if the file exists
			outputFile = new File(outputFileName);
			outputExists = outputFile.exists();
			if (outputExists) {
				// ask theuser if they want to overwrite
				System.out.print("Output file exists - do you want to overwrite? (y/n) ");
				String answer = userInput.next().toLowerCase();

				// If so, assume the file doesn't exist anymore
				if (answer.charAt(0) == 'y')
					outputExists = false;
				else
					System.out.print("Enter a new filename: ");
			}
		}
		return outputFile;
	}

	/**
	 * processUserCommand - entry point for handling filter and sort commands
	 */
	public static void processUserCommand(SongCollection sc) {

		// Setup some error handling
		boolean success = false;
		while (!success) {
			// Keep getting commands until we get something that is real
			System.out.print("Enter command: ");
			String inputLine = "";
			while (inputLine.equals(""))
				inputLine = userInput.nextLine();

			// Split each part
			String[] command = inputLine.split(":");

			// Filter command
			// Second argument is the fielf, third is the data to use
			if (command[0].toLowerCase().equals("filter"))
				success = sc.filter(command[1], command[2]);

			// Get things sorted
			// Second argument is the field on which to sort
			else if (command[0].toLowerCase().equals("insertionsort"))
				success = sc.insertionSort(command[1]);
			else if (command[0].toLowerCase().equals("selectionsort"))
				success = sc.selectionSort(command[1]);
			else if (command[0].toLowerCase().equals("mergesort"))
				success = sc.mergeSort(command[1]);
			else if (command[0].toLowerCase().equals("quicksort"))
				success = sc.quickSort(command[1]);

			// What you talkin' 'bout, Willis?'
			if (!success)
				System.out.print("Invalid command.  Please try again. ");
		}

	}

}

//*******************************************************
//DO NOT MODIFY THIS FILE!!!
//*******************************************************

package gazillionSongsTests;

import gazillionSongs.GazillionSongs;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

public class GazillionSongsTests {
	
	@Test
	public void BasicFilterYear()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterYearExpected.txt");
		File actual = new File("BasicFilterYear.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:year:1990\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicFilterYearRange()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterYearRangeExpected.txt");
		File actual = new File("BasicFilterYearRange.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:year:1990-1999\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicFilterRank()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterRankExpected.txt");
		File actual = new File("BasicFilterRank.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:rank:1\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicFilterRankRange()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterRankRangeExpected.txt");
		File actual = new File("BasicFilterRankRange.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:rank:1-10\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicFilterArtist()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterArtistExpected.txt");
		File actual = new File("BasicFilterArtist.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:artist:frank\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicFilterTitle()
	{
		File expected = new File("test/gazillionSongsTests/BasicFilterTitleExpected.txt");
		File actual = new File("BasicFilterTitle.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:title:one\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicInsertionSortYear()
	{
		File expected = new File("test/gazillionSongsTests/BasicInsertionSortYearExpected.txt");
		File actual = new File("BasicInsertionSortYear.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\ninsertionSort:year\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}

	@Test
	public void BasicInsertionSortRank()
	{
		File expected = new File("test/gazillionSongsTests/BasicInsertionSortRankExpected.txt");
		File actual = new File("BasicInsertionSortRank.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\ninsertionSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}

	@Test
	public void BasicInsertionSortArtist()
	{
		File expected = new File("test/gazillionSongsTests/BasicInsertionSortArtistExpected.txt");
		File actual = new File("BasicInsertionSortArtist.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\ninsertionSort:artist\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}

	@Test
	public void BasicInsertionSortTitle()
	{
		File expected = new File("test/gazillionSongsTests/BasicInsertionSortTitleExpected.txt");
		File actual = new File("BasicInsertionSortTitle.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\ninsertionSort:title\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicSelectionSortYear()
	{
		File expected = new File("test/gazillionSongsTests/BasicSelectionSortYearExpected.txt");
		File actual = new File("BasicSelectionSortYear.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nselectionSort:year\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicSelectionSortRank()
	{
		File expected = new File("test/gazillionSongsTests/BasicSelectionSortRankExpected.txt");
		File actual = new File("BasicSelectionSortRank.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nselectionSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicSelectionSortArtist()
	{
		File expected = new File("test/gazillionSongsTests/BasicSelectionSortArtistExpected.txt");
		File actual = new File("BasicSelectionSortArtist.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nselectionSort:artist\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicSelectionSortTitle()
	{
		File expected = new File("test/gazillionSongsTests/BasicSelectionSortTitleExpected.txt");
		File actual = new File("BasicSelectionSortTitle.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nselectionSort:title\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicMergeSortYear()
	{
		File expected = new File("test/gazillionSongsTests/BasicMergeSortYearExpected.txt");
		File actual = new File("BasicMergeSortYear.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nmergeSort:year\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicMergeSortRank()
	{
		File expected = new File("test/gazillionSongsTests/BasicMergeSortRankExpected.txt");
		File actual = new File("BasicMergeSortRank.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nmergeSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicMergeSortArtist()
	{
		File expected = new File("test/gazillionSongsTests/BasicMergeSortArtistExpected.txt");
		File actual = new File("BasicMergeSortArtist.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nmergeSort:artist\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicMergeSortTitle()
	{
		File expected = new File("test/gazillionSongsTests/BasicMergeSortTitleExpected.txt");
		File actual = new File("BasicMergeSortTitle.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nmergeSort:title\n" + actual.getName() + "\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicErrorCheckingInputFile()
	{
		File actual = new File("Output.txt");
		String inputString = "DoesNotExist.txt\ntest/gazillionSongsTests/80s.txt\nfilter:year:1980\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingOutputFile()
	{
		File expected = new File("test/gazillionSongsTests/BasicErrorCheckingOutputFileExpected.txt");
		File actual = new File("BasicErrorCheckingOutputFile.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nfilter:year:1980\n" + actual.getName() + "\nyes\n";
		RunTest(inputString, expected, actual);
	}
	
	@Test
	public void BasicErrorCheckingFilter()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nfilter:unknown:1985\nfilter:year:1985\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingFilterRangeYear()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nfilter:year:1985-1983\nfilter:year:1983-1985\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingFilterRangeRank()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nfilter:rank:10-1\nfilter:rank:1-10\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingInsertionSort()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\ninsertionSort:unknown\ninsertionSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingSelectionSort()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nselectionSort:unknown\nselectionSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingMergeSort()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nmergeSort:unknown\nmergeSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void BasicErrorCheckingUnknownCommand()
	{
		File actual = new File("Output.txt");
		String inputString = "test/gazillionSongsTests/80s.txt\nunknown:unknown\ninsertionSort:rank\n" + actual.getName() + "\n";
		RunTest(inputString, null, actual, false, true);
	}
	
	@Test
	public void CompoundedRuns()
	{
		File expected = new File("test/gazillionSongsTests/60sExpected.txt");
		File sixties = new File("60s.txt");
		String inputString = "test/gazillionSongsTests/GazillionSongs.txt\nfilter:year:1960-1969\n" + sixties.getName() + "\n";
		RunTest(inputString, expected, sixties, true, false);
		
		expected = new File("test/gazillionSongsTests/60sSortedRankExpected.txt");
		File sixtiesSortedRank = new File("60sSortedRank.txt");
		inputString = sixties.getName() + "\nselectionSort:rank\n" + sixtiesSortedRank.getName() + "\n";
		RunTest(inputString, expected, sixtiesSortedRank, true, false);
		
		expected = new File("test/gazillionSongsTests/60sSortedRankExpected.txt");
		File sixtiesSortedRankFilteredArtist = new File("60sSortedRankFilteredArtist.txt");
		inputString = sixtiesSortedRank.getName() + "\nfilter:artist:john\n" + sixtiesSortedRankFilteredArtist.getName() + "\n";
		RunTest(inputString, expected, sixtiesSortedRank, true, false);
		
		assertTrue(sixties.delete());
		assertTrue(sixtiesSortedRank.delete());
		assertTrue(sixtiesSortedRankFilteredArtist.delete());
	}
	
	private void RunTest(String inputString, File expected, File actual)
	{
		RunTest(inputString, expected, actual, true, true);
	}
	
	private void RunTest(String inputString, File expected, File actual, boolean verifyOutput, boolean deleteActual)
	{
		ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
		System.setIn(input);
		
		try {
			GazillionSongs.main(null);
		}
		catch (FileNotFoundException e) {
			if(actual.exists())
				actual.delete();
			
			fail("Caught a FileNotFoundException");
		}

		if(verifyOutput)
			verifyOutputFile(expected, actual);
		
		if(deleteActual)
			assertTrue(actual.delete());
	}
	
	private void verifyOutputFile(File expectedFile, File actualFile)
	{
		Scanner expected, actual;
		try {
			expected = new Scanner(expectedFile);
			actual = new Scanner(actualFile);
			
			String expectedLine, actualLine;
			
			while(expected.hasNextLine() && actual.hasNextLine())
			{
				expectedLine = expected.nextLine();
				actualLine = actual.nextLine();
				
				assertTrue("expected: " + expectedLine + "| acutal: " + actualLine, expectedLine.equals(actualLine));
			}
			
			if(expected.hasNextLine())
			{
				if(actualFile.exists())
					actualFile.delete();
				
				fail("Output file is missing some songs!");
			}
			else if(actual.hasNextLine())
			{
				if(actualFile.exists())
					actualFile.delete();
				
				fail("Output file has extra songs!");
			}
			
			expected.close();
			actual.close();
		}
		catch (FileNotFoundException e) {
			if(actualFile.exists())
				actualFile.delete();
			
			fail("Caught a FileNotFoundException");
		}
	}	

}

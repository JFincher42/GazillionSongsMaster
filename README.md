# Gazillion Songs Programming Project
**AP Computer Science Class Project** 2017-2018

## Introduction
Searching and sorting algorithms are often used to manipulate and organize large datasets. Amoung these types of datasets are lists of songs on either a user's computer (through an application such as iTunes or Groove) or an internet service (such as Pandora or Spotify). In this project, you will implement a text-based song database program that can sort or search by various field lists of top 100 songs from the past 100+ years. 

### Program Operation
Upon startup, your program should greet the user and inform them that the program will sort and filter a large database of popular songs. You should then prompt the user for an input file from which this database should be read. A sample file (GazillionSongs.txt) that contains over 37,000 songs from the last 100+ years is provided for you to start with.

After the user provides the input file, you should ask them to enter a sort/filter command (see below) and an output file name. Your program should then filter or sort the input song list according to the command and output the results to the specified file. You must take your input in the following order: input file, sort/filter command, output file. Each piece o input should be one line. You should NOT have a loop to process multiple files -- the program should terminate after the output has been printed to the specified output file. 

### File Format
Input and output will be done to and from a file. Both the input and output files should have the same format. Each file will consist of a series of lines formatted as follows:  
  `Year\tRank\tArtist\tTitle`  
  
Each line of the file will consist of the year, rank, artist, and title of a single song, with each of the fields separated by tabs (`\t`). Output files must maintain this format -- you should be able to use the output file of one run of the program as the input to another run. 

### Entering Commands
The user will supply a sort/filter command consistent with one of the following options:
> - filter:year:*year(s)*  
> - filter:rank:*rank(s)*  
> - filter:artist:*artist*  
> - filter:title:*title*  
> - insertionSort:*field(s)*  
> - selectionSort:*field(s)*    
> - mergeSort:*field(s)*    


## Implementation Details
### Error Checking
Your program should not crash as long as the user provides reasonable input. You may assume that the input file is correctly formatted. However, your program must be able to handle other error conditions, including but not limited to: 
  - input file does not exist (prompt the user again)
  - output file already exists (confirm the user wants to overwrite)
  - unrecognized command given in sort/search command  (prompt the user again)
  - range specified for year or rank is invalid (prompt the user again)  

In these (and any other) error cases, your program should recognize and report the error, then prompt the user for the correct input again.

### Sample Execution Logs
```
>Enter input file: GazillionSongs.txt
>Enter sort/search command: filter:year:2000-1999
>Command is not formatted correctly. Please re-enter the command: filter:year:1990-1999
>Enter output file: 90s.txt

>Enter input file: GazillionSongs.txt
>Enter sort/search command: filter:artist:john
>Enter output file: johns.txt

>Enter input file: GazillionSongs.txt
>Enter sort/search command: filter:rank:1
>Enter output file: number1s.txt

>Enter input file: number1s.txt
>Enter sort/search command: filter:title:time
>Enter output file: timeNumber1s.txt

>Enter input file: GazillionSongs.txt
>Enter sort/search command: selectionSort:title
>Enter output file: sorted.txt

>Enter input file: wrongName.txt
>Input file does not exist. Please re-enter: GazillionSongs.txt
>Enter sort/search command: insertionSort:year
>Enter output file: sorted.txt
>Output file already exists. Do you want to overwrite the file? yes
```

## Example Design
The only required implementation is to use an `ArrayList` of Song objects, each containing fields that represent the year, rank, artist, and title of each song. Beyond that, the program design is up to you!

If you don't know where to begin, here is an example of one way that you could design and organize your program. **NOTE**: You are *not* required to follow these suggestions. They represent only one possible design. 

You could create four classes: `GazillionSongs`, `Song`, `SongCollection`, and `Range`. `GazillionSongs` is the client, and contains only the `main()` method and other necessary helper methods. The remaining classes include the following methods, along with any other methods or fields you find necessary or useful:

**Song Class**  
`public Song(int year, int rank, String artist, String title)`  
- Constructor: construct a song object with the given year, rank, artist and title.  

`public int getYear()`  
- Return the year of this song.  

`public int getRank()`  
- Return the rank of this song.  

`public String getArtist()`  
- Return the artist of this song.  

`public String getTitle()`  
- Return the title of this song.  

`public String toString()`  
- Returns a string representation of this song.  

`public int compareTo(Song otherSong, String field)`  
- Compare the given field of this song to the other song. It returns a zero if the given field has the same value in this and the other song. It returns a negative number if the given field of this song is "less than" the other song. It returns a positive number if the given field of this song is "greater than" the other song.  

`public boolean isMatch(String field, String value)`  
- Compare the given field of this song to the given value. If it is a match, it returns true, otherwise it returns false.  

**SongCollection Class**  
`public SongCollection()`  
- Constructor: construct a song collection object which contains an array list of songs.

`public void addSong(String line)`  
- Parse the line read from the song file, create the song and add it to the collection.

`public void filter(String field, String data)`  
- Do filtering on the song collection by matching the given field with the given data.

`public void insertionSort(String field)`  
- Do an insertion sort on the song collection by the given field(s).

`public void selectionSort(String field)`  
- Do a selection sort on the song collection by the given field(s).

`public void mergeSort(String field)`  
- Do a merge sort on the song collection by the given field(s).

`public void printSongs(PrintStream output)`  
- Prints the string representation of each song in the collection to the given print stream.

**Range Class**    
`public Range(String s)`  
- Constructor: Parse a string of the form "<min>-<max>" or "<value>" and construct a Range object representing those values.

`public boolean contains(int value)`  
- Returns true if the given value is in this range, and false otherwise.

`public int getMin()`  
- Returns the minimum value in this range.

`public int getMax()`  
- Returns the maximum value in this range.

## Checkpoints
**Checkpoint 1**  
The program should do the following:
- Ask the user for an input file and an output file.
- Open the input file and read lines using `Scanner`.
- Open the output file and output lines using `PrintStream`.

**Checkpoint 2**  
The program should do the following:
- Ask the user for an input file, a command, and an output file.
- If the user enters a filter command, the output file should contain the filtered list of songs.

**Checkpoint 3**  
The program should do the following:
- Ask the user for an input file, a command, and an output file.
- If the user enters a sort command (except for merge sort), the output file should contain the filtered list of songs.

**Final**  
The program should do the following:
- Ask the user for an input file, a command, and an output file.
- If the user enters any sort command (including merge sort), the output file should contain the filtered list of songs.

## Extra Credit

Additional features will can get up to 20 extra credit points, at the discretion of the graders.  Ideas include, but are not limited to:  

- Allowing multiple sort/filter options to be entered at one time. For example:  
`> Enter input file: agazillionsongs.txt`  
`> Enter sort/filter command: -year:1990-1999 –rank:1-10`    
`> Enter output file: 90sTop10s.txt`    

- Adding binary search on a pre-sorted database.  
- Allow sorting on more than one field (secondary sort).  
- You can propose your own idea as well!  

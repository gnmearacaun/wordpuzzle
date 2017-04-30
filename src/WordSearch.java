import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by briain on 06/04/17.
 */
public class WordSearch {

    private char[][] grid;
    private ArrayList<String> words;
    private int dimension;
    WordSearch puzzle = new WordSearch();
    public WordSearch() throws Exception {


        words = readWords();
        dimension = getDimension();
        createGrid();
        printAsString();
//        insertWord();
    }

    private ArrayList<String> readWords() throws Exception{
        BufferedReader bufReader = new BufferedReader(new FileReader("toddlist.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line;
        while ((line = bufReader.readLine()) != null) {
            listOfLines.add(line);
        }
        bufReader.close();
        return listOfLines;
    }


    public void printAsString() throws Exception {

        StringBuilder lw = new StringBuilder();
        for (String s : words) {
            lw.append(s);
            lw.append("\t");
        }
        System.out.println(words.toString());
    }

    private int getDimension() {
        double result = 0;
        for (int i = 0; i < words.size(); i++) {
            result += words.get(i).length();
        }
        result *= 1.75;
        result = Math.sqrt(result);
        result = Math.ceil(result);
        return (int) result;
    }

    private void createGrid() {
        grid = new char[dimension][dimension];
        initializeGrid();
    }
// initialising the grid with stars
    public void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = '*';
            }
        }
    }


    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    private int getRandomDirection() {
        int directions = {1,2,3,4};
        int idx;
        idx = new Random().nextInt(directions.length);
        String direction = (directions[idx]);
        return direction;
    }

    public void showWordSearchPuzzle(){
    generateWordsearchpuzzle() ;
    int i,j;
    //Until i = size of words list
    for(i=0; i<words.size(); i++)
    {
    System.out.println(printAsString().get(i));//Print word at this position
    }
    System.out.println(printAsString());//Prints the puzzle as string
    }

    //Creating the puzzle:
    private void generateWordsearchpuzzle()
         {
    int i = 0,  row=0, col=0, k, empty = 0;
     puzzle = this.puzzle;
        while(i < words.size()){//while “i” is less than the size of the list of words
//pick random number for direction
//and random coordinate with row and col
            int direction=getRandomDirection();
            //rand = (int)(Math.random()*4) ;
           // row = (int)(Math.random()*(puzzle[0].length)) ;
           // col = (int)(Math.random()*(dimension)) ;
//stores temp value of col/row so that it can be used to check for empty spaces in loop
            int coltemp = col ;
            int rowtemp = row ;
            String strange = "";
//direction of word in puzzle is chosen according to value of random

            if(direction == 0)
            {
// col/row+1 is the actually pos of col/row in the grid
//if length of the grid – col/row+1 is greater or equal to length of the word
//and ensure that the word fits.
                if(puzzle[0].length – (col+1) >=words.get(i).length())
                {

// strange or string range that there are no letters only stars where we are to place the word
                    for(strange = 0 ; strange <words.get(i).length(); empty++){
//if no letter is found we move on to check the next col
                        if((Character.isLetter(puzzle[row][coltemp]))==false){
                            coltemp++ ;
                        }else{
//if not we set strange to a value that will break the loop
//and that will not satisfy the next if statement
                            strange = words.get(i).length()+1 ;
                        }
                    }
//here we check to see if there was indeed enough empty spaces
                    if(strange == words.get(i).length()){
                      int j  = 0 ;
//put in the characters of the chosen word one by one
                        while( j < words.get(i).length() ){
                            grid[row][col] = words.get(i).charAt(j) ;
                            col++ ;
                            j++ ;
                        }
//increment i to move onto the next chosen word
                        i++ ;
                    }
                }
            } //same method as above for checking empty spaces
            else if(direction == 1){
                if(words.size() – (col+1)>=words.get(i).length()) {
                    for(empty = 0 ; empty <words.get(i).length(); empty++){
                        if((Character.isLetter(puzzle[row][coltemp]))==false){
                            coltemp++ ;
                        }else{
                            strange = words.get(i).length()+1 ;
                        }
                    }
                    if(strange == words.get(i).length()) {
                     //same as above except we are putting characters in the word backwards
                        j = words.get(i).length()-1 ;
                        while( j >= 0 ){
                            grid[row][col] = words.get(i).charAt(j) ;
                            col++;
                            j– ;
                        }
// move onto next word
                        i++ ;
                    }
                }

            }else if(direction == 2)
            {//same as above except with changing rows
//so the chosen words will be put in in a north or south direction
                if(grid[0].length – (row+1) >=words.get(i).length() && (Character.isLetter(puzzle[row][col])==false)) {
                    for(strange = 0 ; strange <words.get(i).length(); empty++){
                        if((Character.isLetter(grid[rowtemp][col]))==false){
                            rowtemp++ ;
                        }else{
                            strange = words.get(i).length()+1 ;

                        }
                    }
                    if(strange == words.get(i).length()){

                        k = words.get(i).length()-1 ;
                        while( j >= 0 ){
                            puzzle[row][col] = words.get(i).charAt(j) ;
                            row++;
                            j– ;
                        }
                        i++ ;
                    }
                }
            }
            else if(direction == 3)
            {//same as above
                if(grid[0].length – (row+1) >=words.get(i).length() ) {
                    for(strange = 0 ; strange <words.get(i).length(); strange++){
                        if((Character.isLetter(puzzle[rowtemp][col]))==false){
                            rowtemp++ ;
                        }else{
                            strange = words.get(i).length()+1;
                        }
                    }
                    if(strange == words.get(i).length()){
                        j = 0 ;
                        while(j < words.get(i).length() ){
                            grid[row][col] = words.get(i).charAt(j);
                            row++;
                            j++;
                        }
                        i++;
                    }
                }
            }
        }

        int a,j;
//characters of alphabet in order of how they appear on the keyboard
        char[] alphabet = {(‘Q’),(‘W’),(‘E’),(‘R’),(‘T’),(‘Y’),(‘U’),(‘I’),(‘O’),(‘P’),(‘A’),(‘S’),(‘D’),(‘F’),(‘G’),(‘H’),(‘J’),(‘K’),(‘L’),(‘Z’),(‘X’),(‘C’),(‘V’),(‘B’),(‘N’),(‘M’)} ;
        for(i=0;i < words.size(); i++){
//goes through the grid and if no character is in place it randomly adds one from the alphabet
            for(a=0; a<words.size(); a++)
            {
                for(j=0; j<grid[0].length; j++)
                {
                    if(Character.isLetter(puzzle[a][j])==false){
                        int z = (int)((Math.random()* alphabet.length));
                        grid[a][j] = alphabet[z] ;
                    }
                }
            }
        }
    }
            int i,j;
            for(i=0; i<words.size(); i++) {
                //Until i = size of words list
                System.out.println(words.get(i)); }
                //Print word at this position
            System.out.println(printAsString());
            //Prints the puzzle as string
        }

       //Creating the puzzle:

            private void createGrid() {
                int i = 0, rand, row, col, k, strange = 0;
                words = this.words ;
                while(i < words.size()){//while “i” is less than the size of the list of words
                    //pick random number for direction
                    //and random coordinate with row and col
                    rand = (int)(Math.random()*4) ;
                    row = (int)(Math.random()*(dimension)) ;
                    col = (int)(Math.random()*(dimension)) ;
                    //stores temp value of col/row so that it can be used to check for empty spaces in loop
                    int coltemp = col ;
                    int rowtemp = row ;
                    //direction of word in puzzle is chosen according to value of random
                    if(rand == 0)
                    {
                        // col/row+1 is done to take into count the actually pos of col/row in the grid
                        //if length of puzzle – col/row+1 is greater or equal to length of chosen word then
                        //there must be enough spaces for the word to fit
                        if(grid.length – (col+1) >=words.get(i).length())
                        {

                            //next we check to see if there is enough EMPTY spaces to fit the word in
                            for(strange = 0 ; strange <words.get(i).length(); strange++){
                                //if no letter is found we move on to check the next col
                                if((Character.isLetter(grid[row][coltemp]))==false){

                                    coltemp++ ;

                                }else{
                                    //if not we set empty to a value that will break the loop
                                    //and that will not satisfy the next if statement
                                    strange = words.get(i).length()+1 ;

                                }
                            }
                            //here we check to see if there was indeed enough empty spaces
                            if(strange == words.get(i).length())
                            {

                                k = 0 ;
                                //put in the characters of the chosen word one by one
                                while( k < puzzle.get(i).length() ){
                                    puzzle[row][col] = puzzle.get(i).charAt(k) ;

                                    col++ ;
                                    k++ ;

                                }
                                //increment i to move onto the next chosen word
                                i++ ;
                            }

                        }
                    } //same method as above for checking empty spaces
                    else if(rand == 1){
                        if(puzzle.length – (col+1)>=puzzle.get(i).length() )
                        {
                            for(strange = 0 ; strange <puzzle.get(i).length(); strange++){
                                if((Character.isLetter(puzzle[row][coltemp]))==false){

                                    coltemp++ ;

                                }else{
                                    strange = puzzle.get(i).length()+1 ;

                                }
                            }
                            if(strange == puzzle.get(i).length())
                            {
                                //same as above except we are putting characters in the word from last till first
                                k = puzzle.get(i).length()-1 ;
                                while( k >= 0 ){

                                    puzzle[row][col] = puzzle.get(i).charAt(k) ;

                                    col++;
                                    k– ;
                                }
                                // move onto next word
                                i++ ;
                            }

                        }

                    }else if(rand == 2)
                    {//same as above except with changing rows
                        //so the chosen words will be put in in a north or south direction

                        if(puzzle[0].length – (row+1) >=puzzle.get(i).length() && (Character.isLetter(puzzle[row][col])==false))
                        {
                            for(empty = 0 ; empty <puzzle.get(i).length(); empty++){
                                if((Character.isLetter(puzzle[rowtemp][col]))==false){

                                    rowtemp++ ;

                                }else{
                                    empty = puzzle.get(i).length()+1 ;

                                }
                            }
                            if(empty == puzzle.get(i).length()){

                                k = puzzle.get(i).length()-1 ;
                                while( k >= 0 ){

                                    puzzle[row][col] = puzzle.get(i).charAt(k) ;

                                    row++;
                                    k– ;

                                }
                                i++ ;
                            }

                        }
                    }

                    else if(rand == 3)
                    {//same as above
                        if(puzzle[0].length – (row+1) >=puzzle.get(i).length() )
                        {
                            for(empty = 0 ; empty <puzzle.get(i).length(); empty++){
                                if((Character.isLetter(puzzle[rowtemp][col]))==false){

                                    rowtemp++ ;

                                }else{
                                    empty = puzzle.get(i).length()+1 ;

                                }
                            }
                            if(empty == puzzle.get(i).length()){
                                k = 0 ;
                                while(k < puzzle.get(i).length() ){

                                    puzzle[row][col] = puzzle.get(i).charAt(k) ;

                                    row++;
                                    k++ ;

                                }
                                i++ ;
                            }

                        }
                    }
                }

                int a,j;
                //characters of alphabet in order of how they appear on the keyboard
                char[] alphabet = {(‘Q’),(‘W’),(‘E’),(‘R’),(‘T’),(‘Y’),(‘U’),(‘I’),(‘O’),(‘P’),(‘A’),(‘S’),(‘D’),(‘F’),(‘G’),(‘H’),(‘J’),(‘K’),(‘L’),(‘Z’),(‘X’),(‘C’),(‘V’),(‘B’),(‘N’),(‘M’)} ;
                for(i=0;i < puzzle.size(); i++){
                    //goes through the grid and if no character is in place it randomly adds one from the alphabet
                    for(a=0; a<puzzle.length; a++)
                    {
                        for(j=0; j<puzzle[0].length; j++)
                        {
                            if(Character.isLetter(puzzle[a][j])==false){
                                int z = (int)((Math.random()* alphabet.length));
                                puzzle[a][j] = alphabet[z] ;

                            }

                        }
                    }

                }

        }

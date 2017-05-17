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
    public WordSearch() throws Exception {


        words = readWords();
        //puzzle = this.puzzle;
        dimension = getDimension();
        //generateWordsearchpuzzle();
        createGrid();
        //printWords();
        //printAsString();
    }

    private ArrayList<String> readWords() throws Exception {
        BufferedReader bufReader = new BufferedReader(new FileReader("20Awords.txt"));
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
        int[] directions = {1, 2, 3 , 4};
        int idx;
        idx = new Random().nextInt(directions.length);
        int direction = (directions[idx]);
        return direction;
    }

    public void printWords() throws Exception {
           int i;
        for(i=0; i<words.size(); i++){ //Until i = size of words list
        }
            System.out.println(words.get(i-1));//Prints the puzzle as string
    }


    public void generateWordsearchpuzzle(){
        int i = 0,  l = 0, row, col;
        int strange;
        //stores temp value of col/row so that it can be used to check for empty spaces in loop
        //pick random number for direction and random coordinate with row and col


        while(i < words.size()){//while “i” is less than the size of the list of words
            int direction = getRandomDirection();
            row = (int) (Math.random() * grid.length);
            col = (int)(Math.random() * grid[0].length);
            int coltemp= col;
            int rowtemp= row;
            String currentW = words.get(i);
            int wordLength = words.get(i).length();
            //for debugging purposes, the following were getting hung up on an out of bounds exception
            //System.out.println("currentW " + currentW);
            //System.out.println(wordLength);
            //System.out.println(direction);
            //System.out.println(row);
            //System.out.println(col);

            //direction of word in puzzle is chosen according to value of 1-4
            if(direction == 1) {   // I could have used switch/case for the direction values, but went with if/else instead
            //Is the length of the grid – col/row+1 greater or equal to length of the word?
                    if((grid.length - (col+1)) >= wordLength) {
                    // Col+1/row+1 adjusts for the index +1
            //ensure there's enough room for the current word.
            //  check the range of necessary spaces to ensure they are not letters (but stars) to place the current word
                    for(strange = 0 ; strange < wordLength; strange++){
                        if((!Character.isLetter(grid[row][coltemp]))){
                            //if no letter is found we move on to check the next col to the right in this instance
                            coltemp++;
                        }else{
            //if we come across a letter, we set a value to strange that will break the for-loop and not
            //satisfy the next iteration because there's not enough space for the word. It will go back and get new random
                            //values for positions and the direction
                            strange  = wordLength +1;
                        }
                    }
            // Checking: is the range of stars equal to the length of the word?
            if(strange == wordLength){
               int j = 0 ; // if so put the characters in one at a time,
                    while( j < wordLength){
                         grid[row][col] = words.get(i).charAt(j); //put the character at position j of the word i
                        // (out of the arrayList called words) into the actual position (ie col, not coltemp)
                         col++ ;  // jump to the next column right
                         j++ ; // increment our letter count until it reaches the limit of the word
                    }
// i increments to the next word in the array when we're done with inserting via prior nested loop
                        i++ ;
                    }
                }
            } //same plan as in direction '1', but putting the word in backwards
            else if(direction == 2){
                  if((col+1) >= wordLength) {
                    for(strange  = 0 ;strange < wordLength; strange++){
                        if((!Character.isLetter(grid[row][coltemp]))){
                            coltemp--;
                        }else{
                             strange = wordLength+1;
                        }
                    }
                    if( strange == wordLength) { //I might try giving k the value of the wordlength -1 to adjust for the indexing
                        //the characters in the word backwards, right to left
                        int k = 0;
                        //wordlength -1 to adjust for the fact that we want the index of the first letter to start at 0
                        //just like k
                        while( k <= wordLength -1 ){
                            //Starting at the end of the word
                            //get the letter at k position and place it in the grid
                            grid[row][col] = words.get(i).charAt(k);
                            //move from right to left
                            col--;
                            //move from rightmost letter to the left
                            k++;
                        } // move onto next word
                        i++ ;
                    }
                }

            }else if(direction == 3) {//same as above except the chosen words will be put in from south to north direction
                if((row+1) >= wordLength) {
                    //if(grid[0].length - (row+1) >=wordLength && (!Character.isLetter(grid[row][col]))) {
                    for( strange = 0 ; strange  < wordLength; strange++) {
                        if((!Character.isLetter(grid[rowtemp][col]))){
                            rowtemp--;
                        }else{
                             strange = wordLength+1 ;

                        }
                    }
                    // this time were placing the word in backwards; bottom to top
                    if(strange == wordLength) {
                        int k = 0;
                        while(k <= wordLength -1 ){
                            grid[row][col] = words.get(i).charAt(k) ;
                            row--;
                            k++;
                        }
                        i++;
                    }
                }
            }
            else if(direction == 4) {//similar to above except now the word is inserted top to bottom
                if(grid[0].length - (row+1) >= wordLength ) {
                    for(strange = 0 ; strange <wordLength; strange++){
                        if((!Character.isLetter(grid[rowtemp][col]))){
                            rowtemp++ ;
                        }else{
                             strange = wordLength+1;
                        }
                    }
                    if(strange == wordLength){
                        while(l < wordLength){
                            grid[row][col] = words.get(i).charAt(l);
                            row++;
                            l++;
                        }
                        i++;
                    }
                }
            }
        }

        int a;
          //characters of alphabet in order of how they appear on the keyboard
        char[] alphabet = {('q'),('w'),('e'),('r'),('t'),('y'),('u'),('i'),('o'),('p'),('a'),('s'),('d'),('f'),('g'),('h'),('j'),('k'),('l'),('z'),('x'),('c'),('v'),('b'),('n'),('m')} ;
        for(i=0;i < words.size(); i++){
         //goes through the grid and if no character is in place it randomly adds one from the alphabet
            for(a=0; a<grid.length; a++)
            {
                for(int b=0; b<grid[0].length; b++)
                {
                    if(!Character.isLetter(grid[a][b])){
                        int z = (int)((Math.random()* alphabet.length));
                        grid[a][b] = alphabet[z] ;
                    }
                }
            }
        }
    }
}



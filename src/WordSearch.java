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
        int i = 0,  l = 0, row = 0, col = 0 ;
        int strange;
        //stores temp value of col/row so that it can be used to check for empty spaces in loop
        //pick random number for direction and random coordinate with row and col


        while(i < words.size()){//while “i” is less than the size of the list of words
            int direction = getRandomDirection();
            row = (int) (Math.random() * grid.length);
            col = (int)(Math.random()*grid[0].length);
            int coltemp= col;
            int rowtemp= row;
            String currentW = words.get(i);
            int wordLength = words.get(i).length();
            System.out.println(direction);
            System.out.println(row);
            System.out.println(col);
            System.out.println(wordLength);
            System.out.println("currentW " + currentW);

            //direction of word in puzzle is chosen according to value of direction
            if(direction == 0) {   // I could use switch/case here also
            // col/row+1 is the actually pos of col/row in the grid
            //if length of the grid – col/row+1 is greater or equal to length of the word
            //and ensure there's enough room for the current word.
                if(dimension - (col+1) >= wordLength) {
            //  check there are stars, not letters, for word placement
                    for(strange = 0 ; strange < wordLength; strange++){
            //if no letter is found we move on to check the next col to the right in this case
                        if((Character.isLetter(grid[row][coltemp]))==false){
                            coltemp++;
                        }else{
            //if not we set a value to st-range that will break the loop so that will not
            //satisfy the next if statement because it exceeds the limits of the permitted word length
                            strange  = wordLength +1;
                        }
                    }
            // is the range of stars equal to the length of the word?
            if(strange <= wordLength){
               int j = 0 ; //put the characters in, one at a time,
                    while( j < wordLength){
                         grid[row][col] = words.get(i).charAt(j); //put the character at position j from word at
                        // postiton i of the array into the actual position (ie col vs. coltemp)
                         col++ ;  // jump to the next column right
                         j++ ; // increment our letter count until it reaches the limit of the word
                    }
// i increments to the next word in the array when we're done with inserting with prior nested loop
                        i++ ;
                    }
                }
            } //same method as in direction '0', checking empty spaces
            else if(direction == 1){
                if(words.size() - (col+1)>= wordLength) {
                    for(strange  = 0 ;strange < wordLength; strange++){
                        if((Character.isLetter(grid[row][coltemp]))==false){
                            coltemp++ ;
                        }else{
                             strange = wordLength+1;
                        }
                    }
                    if( strange == wordLength) { //we're giving k the value of the wordlength -0 to adjust for the indexing
                        //the characters in the word backwards, right to left
                        int k = wordLength -1;
                        while( k >= 0 ){
                            grid[row][col] = words.get(i).charAt(k);
                            col--;
                            k--;
                        } // move onto next word
                        i++ ;
                    }
                }

            }else if(direction == 2) {//same as above except with changing rows
//so the chosen words will be put in in a north or south direction
                if(grid[0].length - (row+1) >=wordLength && (Character.isLetter(grid[row][col])==false)) {
                    for( strange = 0 ; strange  < wordLength; strange++) {
                        if((Character.isLetter(grid[rowtemp][col]))==false){
                            rowtemp++;
                        }else{
                             strange = wordLength+1 ;

                        }
                    }
                    // this time were placing the word in backwards; bottom to top
                    if(strange == wordLength) {
                        int k = wordLength -1 ;
                        while(k >= 0 ){
                            grid[row][col] = words.get(i).charAt(k) ;
                            row++;
                            k--;
                        }
                        i++;
                    }
                }
            }
            else if(direction == 3) {//similiar to above except now the word is inserted top to bottom
                if(grid[0].length - (row+1) >= wordLength ) {
                    for(strange = 0 ; strange <wordLength; strange++){
                        if((Character.isLetter(grid[rowtemp][col])) == false ){
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
            for(a=0; a<words.size(); a++)
            {
                for(int b=0; b<grid[0].length; b++)
                {
                    if(Character.isLetter(grid[a][b])==false){
                        int z = (int)((Math.random()* alphabet.length));
                        grid[a][b] = alphabet[z] ;
                    }
                }
            }
        }
    }
}



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
        createGrid();
        printWords();
        print = printAsString();
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
            System.out.println(printAsString().get(i));//Print word at this position
        }
//            System.out.println(printAsString());//Prints the puzzle as string
    }


    private void generateWordsearchpuzzle();{
        int i, j, k, l = 0, row=0, col=0 ;
        int strange = 0;
        int coltemp= col;
        int rowtemp= row;
        //stores temp value of col/row so that it can be used to check for empty spaces in loop
        int direction = getRandomDirection();
        //pick random number for direction and random coordinate with row and col

        while(i < words.size()){//while “i” is less than the size of the list of words
            //direction of word in puzzle is chosen according to value of direction
            if(direction == 0) {
            // col/row+1 is the actually pos of col/row in the grid
            //if length of the grid – col/row+1 is greater or equal to length of the word
            //and ensure there's enough room for the current word.
                if(dimension - (col+1) >= words.get(i).length()) {
            //  check there are stars, not letters, for word placement
                    for(strange = 0 ; strange < words.get(i).length(); strange++){
            //if no letter is found we move on to check the next col to the right in this case
                        if((Character.isLetter(grid[row][coltemp]))==false){
                            coltemp++ ;
                        }else{
            //if not we set a value to strange that will break the loop so that will not
            //satisfy the next if statement because it exceeds the limits of the permitted word length
                            strange  = words.get(i).length()+1;
                        }
                    }
            // is the range of stars equal to the word length
            if(strange == words.get(i).length()){
               int j = 0 ; //put in the characters of the current word one at a time
                    while( j < words.get(i).length() ){
                         grid[row][col] = words.get(i).charAt(j) ;
                         col++ ;  // jump to the next position on the grid
                         j++ ; // increment our letter count
                    }
// i increments to the next word in the array when we're done with inserting with prior nested loop
                        i++ ;
                    }
                }
            } //same method as above for checking empty spaces
            else if(direction == 1){
                if(words.size() - (col+1)>=words.get(i).length()) {
                    for(strange  = 0 ;strange <words.get(i).length(); strange ++){
                        if((Character.isLetter(grid[row][coltemp]))==false){
                            coltemp++ ;
                        }else{
                             strange = words.get(i).length()+1;
                        }
                    }
                    if( strange == words.get(i).length()) {
                     //same as above except we are putting characters in the word backwards
                        k = words.get(i).length()-1;
                        while( k >= 0 ){
                            grid[row][col] = words.get(i).charAt(k);
                            col--;
                            //
                            k--;
                        }
                       // move onto next word
                        i++ ;
                    }
                }

            }else if(direction == 2)
            {//same as above except with changing rows
//so the chosen words will be put in in a north or south direction
                if(grid[0].length - (row+1) >=words.get(i).length() && (Character.isLetter(grid[row][col])==false)) {
                    for( strange = 0 ; strange  <words.get(i).length(); strange++) {
                        if((Character.isLetter(grid[rowtemp][col]))==false){
                            rowtemp++ ;
                        }else{
                             strange = words.get(i).length()+1 ;

                        }
                    }
                    // this time were placing the word in backwards; bottom to top
                    if(strange == words.get(i).length()) {
                        k = words.get(i).length() -1 ;
                        while(k >= 0 ){
                            grid[row][col] = words.get(i).charAt(k) ;
                            row--;
                            k--;
                        }
                        i++;
                    }
                }
            }
            else if(direction == 3) {//similiar to above except now the word is inserted top to bottom
                if(grid[0].length - (row+1) >= words.get(i).length() ) {
                    for(strange = 0 ; strange <words.get(i).length(); strange++){
                        if((Character.isLetter(grid[rowtemp][col])) == false ){
                            rowtemp++ ;
                        }else{
                             strange = words.get(i).length()+1;
                        }
                    }
                    if(strange == words.get(i).length()){
                        while(l < words.get(i).length() ){
                            grid[row][col] = words.get(i).charAt(l);
                            row++;
                            l++;
                        }
                        i++;
                    }
                }
            }
        }

        int a,j;
//characters of alphabet in order of how they appear on the keyboard
        char[] alphabet = {('q'),('w'),('e'),('r'),('t'),('y'),('u'),('i'),('o'),('p'),('a'),('s'),('d'),('f'),('g'),('h'),('j'),('k'),('l'),('z'),('x'),('c'),('v'),('b'),('n'),('m')} ;
        for(i=0;i < words.size(); i++){
//goes through the grid and if no character is in place it randomly adds one from the alphabet
            for(a=0; a<words.size(); a++)
            {
                for(j=0; j<grid[0].length; j++)
                {
                    if(Character.isLetter(grid[a][j])==false){
                        int z = (int)((Math.random()* alphabet.length));
                        grid[a][j] = alphabet[z] ;
                    }
                }
            }
        }
    }
}



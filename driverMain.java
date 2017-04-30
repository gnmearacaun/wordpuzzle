Driver class:

        Test case 1:

private static void test1()
        {//this test case is one with random words from the file bncwords.txt, 100 words to be chosen, shortest length = 3, longest length = 3

        WordSearchPuzzle wordSearch = new WordSearchPuzzle(“bncwords.txt”,100,3,3);
        wordSearch.getWordSearchList() ;//gets the list of chose words
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();//prints the puzzle
        }

        Test case 2:

private static void test2()
        {//again words are from bncwords.txt, 8 words, shortest = 2, longest = 8
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(“bncwords.txt”,8,2,8);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();
        }

        Test case 3:

private static void test3()
        {//words are from basicenglish.txt, 5 words, shortest = 1o, longest = 2 (this test if our statement in second block of code works)
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(“basicenglish.txt”,5,10,2);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();
        }

        Test case 4:

private static void test4()
        {//Words are from basicenglish.txt, 15 words to choose, shortest is 5, longest is 8
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(“basicenglish.txt”,15,5,8);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();
        }

        Test case 5:

private static void test5()
        {
        System.out.println(“**************************THE FOLLOWING ARE THE TEST FOR USER INPUT WORDS********************************+|n”) ;
        System.out.println();
        ArrayList<String> words = new ArrayList<String>();
        words.add(“THAT”);
        words.add(“INTERESTING”);
        words.add(“AS”);
        words.add(“INTERACTION”);
        words.add(“SMOOTH”);

        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();

        }

        Test case 6:

private static void test6()
        {

        ArrayList<String> words = new ArrayList<String>();
        words.add(“CAT”);
        words.add(“PSEUDOPSEUDOHYPOPARATHYROIDISM”);//this is actually a word 🙂
        words.add(“DOG”);
        words.add(“SMOOTH”);

        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();

        }

        Test case 7:

private static void test7()
        {

        ArrayList<String> words = new ArrayList<String>();
        words.add(“THAT”);
        words.add(“IN”);
        words.add(“AS”);
        words.add(“ON”);
        words.add(“ROUGH”);

        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();

        }

        Test case 8:

private static void test8()
        {

        ArrayList<String> words = new ArrayList<String>();
        words.add(“BECUASE”);
        words.add(“I”);
        words.add(“LOVE”);
        words.add(“IMPERETIVE”);
        words.add(“PROGRAMMING”);

        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle() ;

        System.out.println();

        }

        Main driver method:

public static void main(String[] args)
        {
        System.out.println();
        System.out.println(“**************************THE FOLLOWING ARE THE TEST FOR RANDOMLY GENERATED WORDS FROM GIVEN FILES********************************+|n”) ;
        System.out.println();
        Driver.test1();
        Driver.test2();
        Driver.test3();
        Driver.test4();
        Driver.test5();
        Driver.test6();
        Driver.test7();
        Driver.test8();
        }

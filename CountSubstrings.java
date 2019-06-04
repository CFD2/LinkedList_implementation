import java.io.*;
import java.util.*;

/**
 * Created by Vadim Yastrebov 100908473 on 17/7/17.
 */
public class CountSubstrings {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Character> arrPattern = new ArrayList<>(); //an arraylist for pattern

        LinkedList<Character> linkedPattern = new LinkedList<>();   //a linkedlist for pattern

        String filename = openFile();   //using the provided methods

        System.out.println("Enter your search phrase: ");
        String in = new Scanner(System.in).nextLine();
        convertStringToList(in,linkedPattern);  //convert the search phrase into either arrayList
        convertStringToList(in, arrPattern);    //or linkedList

        long time1 = System.currentTimeMillis();    //create 2 separate timers for the experiment to be valid.
        System.out.println("Using LinkedList: " + readAndMatchDocument(filename, linkedPattern, new LinkedList<>()) + " matches, derived in " + (System.currentTimeMillis() - time1) + " Milliseconds.");

        long time2 = System.currentTimeMillis();    //second timer variable
        System.out.println("Using ArrayList:  " + readAndMatchDocument(filename, arrPattern, new ArrayList<>()) + " matches, derived in " + (System.currentTimeMillis() - time2) + " Milliseconds.");


    }

    /**
     * this method was given by Prof. Ukwatta
     * @param text is the text represented by arraylist/linkedlist
     * @param pattern is the search pattern as a list
     * @return substring index from the text that matched the pattern
     */
    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index
            // within text
            int k = 0; // k is index into pattern
            while (k < m && text.get(i + k) == pattern.get(k))
                // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }

    /*
	 * Repeatedly prompt user for filename until a file with such a name exists
	 * and can be opened.
	 */

    /**
     * Reusing the given code
     * @return the file path to the specified file
     */

    private static String openFile() {

        BufferedReader keyboardReader = new BufferedReader(
                new InputStreamReader(System.in));

        String inFilePath = "";
        BufferedReader inFileReader;
        boolean pathsOK = false;

        while (!pathsOK) {
            try {
                System.out.print("Please enter the path for the input file: ");
                inFilePath = keyboardReader.readLine();
                inFileReader = new BufferedReader(new FileReader(inFilePath));
                pathsOK = true;
                inFileReader.close();
            } // try
            catch (IOException e) {
                System.out.println(e);
            } // catch I/O exception
        } // while
        return inFilePath;
    } // method openFiles


	/* This was given.
	 * Helper method to convert a string to a List. Loops over all characters in
	 * the string and may not be all that efficient - may be better to read in
	 * the file character by character until we hit whitespace.
	 */

    private static void convertStringToList(String in, List<Character> out) {
        char[] input_chars = in.toCharArray();
        out.clear();
        for (int i = 0; i < input_chars.length; i++) {
            out.add(input_chars[i]);
        }
    }

	/* This was given.
	 * Iterate over all strings in input file to determine whether the input
	 * string is a substring in any of these strings. Returns the number of
	 * times such a match exists.
	 */

    public static int readAndMatchDocument(String filename, List<Character> pattern, List<Character> Input)
            throws FileNotFoundException {
        StringTokenizer tokens;
        String line, textword;
        int count = 0;
        // open file anew to ensure we start at the first character
        BufferedReader inFileReader = new BufferedReader(new FileReader(
                filename));

        try {
            while (true) {
                line = inFileReader.readLine();
                if (line == null)
                    break;
                tokens = new StringTokenizer(line);
                // for all the words in the line
                while (tokens.hasMoreTokens()) {
                    textword = tokens.nextToken();
                    convertStringToList(textword, Input);
                    if (findBrute(Input, pattern) != -1)
                        count = count + 1;
                } // end while tokens
            } // end while true
        } catch (IOException e) {
            System.out.println(e);
        } // catch I/O exception}
        try {
            inFileReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }

}

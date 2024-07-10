package com.company.assessment.wordfinder;

import com.company.assessment.wordfinder.utils.Trie;
import com.company.assessment.wordfinder.utils.TrieWordLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class matches the words present in the input file to a Trie
 */
public class WordMatcher {

    //variable to store the TrieWordLoader object reference passed through constructor
    private TrieWordLoader predefinedWordLoader;
    //this variable will hold the reference to the trie loaded by the TrieWordLoader
    private Trie trie;

    /**
     * parameterized constructor
     * @param predefinedWordLoader reference to the TrieWordLoader instance
     */
    public WordMatcher(TrieWordLoader predefinedWordLoader) {
        this.predefinedWordLoader = predefinedWordLoader;
    }

    /*
     This method loads the trie which is created by the TrieWordLoader
     */
    private void lodTrie() throws NullPointerException {
        this.trie = predefinedWordLoader.getTrie().orElseThrow(()-> new NullPointerException("Cannot load Trie"));
    }

    /**
     * Method to math the words and stores it in a file
     * @param inputFile: input file, that contains list of worst to match separated by new line
     * @return the outfile which contains matched words.
     *
     */
    public String matchWords(String inputFile) throws FileNotFoundException, NullPointerException {
        String outFile = "output-"+System.currentTimeMillis();
        matchWords(inputFile,outFile);
        return  outFile;
    }

    /**
     * This method finds the matching words list without writing it into the file.
     * @param inputFile: input file, that contains list of worst to match separated by new line
     * @return List of matched Strings/words.
     */
    public List<String> getMatchingWords(String inputFile) throws FileNotFoundException, NullPointerException {
        File file = new File(inputFile);
        Scanner inputFileScanner =  new Scanner(file);

        lodTrie();

        List<String> result = new ArrayList<>();

        while (inputFileScanner.hasNextLine()){
            String searchWord = inputFileScanner.nextLine();
            if(trie.search(searchWord)){
                result.add(searchWord);
            }
        }
        inputFileScanner.close();
        return result;
    }


    /**
     * Method to match the words and stores matched words in the given file.
     * @param inputFile: input file, that contains list of worst to match separated by new line
     * @param matchedOutputFile: output file, that stores the list of matched words.
     */
    public void matchWords(String inputFile, String matchedOutputFile) throws FileNotFoundException, NullPointerException {
        File file = new File(inputFile);
        Scanner inputFileScanner =  new Scanner(file);

        lodTrie();

        PrintWriter outWriter = new PrintWriter(matchedOutputFile);

        while (inputFileScanner.hasNextLine()){
            String searchWord = inputFileScanner.nextLine();
            if(trie.search(searchWord)){
                outWriter.println(searchWord);
            }
        }
        inputFileScanner.close();
        outWriter.close();
    }


}

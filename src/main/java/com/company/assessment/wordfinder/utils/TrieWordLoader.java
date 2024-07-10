package com.company.assessment.wordfinder.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 * The following class will be used to load the predefined words
 */
public class TrieWordLoader {

    //variable to store the predefined words file path
    private String predefinedWordsFilePath;

    //boolean flag is used to check if the file is loaded,
    //this will reduce multiple read on the same file
    private boolean isWordsLoaded;

    //WordTrie data structure that actually stores words.
    private Trie trie;

    /**
     * parameterized constructor uses dependency inversion principle (constructor injection/loose coupling)
     * @param predefinedWordsFilePath: complete path to the predefined words file
     * @param trie: reference to the object that has implemented Trie interface
     *             If a null object is passed it creates StandardTrie object
     */
    public TrieWordLoader(String predefinedWordsFilePath, Trie trie){
        if(trie == null)
            this.trie = new StandardTrie();
        else
            this.trie = trie;
        this.predefinedWordsFilePath = predefinedWordsFilePath;
        isWordsLoaded=false;
    }

    /**
     * Loads the predefined words from the file if not loaded.
     */
    public void loadPredefinedWords() throws FileNotFoundException{
        if(isWordsLoaded)
                return;
        readFileAndLoadWords();
        isWordsLoaded = true;
    }

    /**
     * Reloads the pre predefined words
     */
    public void reLoadPredefinedWords() throws FileNotFoundException{
        this.isWordsLoaded = false;
        loadPredefinedWords();
    }

    /*
    private method which will be used to read the file and store the word in the trie datastructure
    */
    private void readFileAndLoadWords() throws FileNotFoundException {
        File predefinedWordFile =  new File(this.predefinedWordsFilePath);
        Scanner fileScanner =  new Scanner(predefinedWordFile);
        while(fileScanner.hasNextLine()){
            String word = fileScanner.nextLine();
            trie.insert(word.trim().toString());
        }
        fileScanner.close();
    }

    /**
     * Creates a predefined words trie only if the trie is null.
     * @return Optional of predefined words trie
     */
    public Optional<Trie> getTrie() {
        try{
            loadPredefinedWords();
        }catch (FileNotFoundException e){
            return Optional.empty();
        }
        return Optional.of(trie);
    }
}

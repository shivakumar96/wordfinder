package com.company.assessment;

import com.company.assessment.wordfinder.WordMatcher;
import com.company.assessment.wordfinder.utils.StandardTrie;
import com.company.assessment.wordfinder.utils.Trie;
import com.company.assessment.wordfinder.utils.TrieWordLoader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NullPointerException {

        String predefinedWords =  "src/main/resources/predefinedWords.txt";
        String inputFile =  "src/main/resources/sampleInput.txt";

        Trie trie = new StandardTrie();
        TrieWordLoader wordLoader = new TrieWordLoader(predefinedWords, trie);
        WordMatcher wordMatcher = new WordMatcher(wordLoader);

        //wordMatcher.getMatchingWords(inputFile);
        System.out.println(wordMatcher.getMatchingWords(inputFile).size());

    }
}
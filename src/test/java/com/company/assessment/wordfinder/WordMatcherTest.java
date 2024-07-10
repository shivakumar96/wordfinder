package com.company.assessment.wordfinder;

import com.company.assessment.wordfinder.utils.Trie;
import com.company.assessment.wordfinder.utils.TrieWordLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordMatcherTest {

    String inputFile ;
    String inputNoMatchFile ;
    String preDefinedWordsFile;

    Trie trie;

    List<String> matches;

    @BeforeEach
    void setup() throws IOException {
        File tempFile = File.createTempFile("predefinedWords", ".txt");
        tempFile.deleteOnExit();
        FileWriter writer = new FileWriter(tempFile);
        writer.write("hello\n");
        writer.write("hi\n");
        writer.write("his\n");
        writer.close();
        preDefinedWordsFile = tempFile.getAbsolutePath();

        File tempInputFile = File.createTempFile("predefinedWords", ".txt");
        tempInputFile.deleteOnExit();
        writer = new FileWriter(tempInputFile);
        writer.write("he\n");
        writer.write("hi\n");
        writer.write("his\n");
        writer.write("help\n");
        writer.close();
        inputFile = tempInputFile.getAbsolutePath();

        matches = new ArrayList<>();
        matches.add("hi");
        matches.add("his");

        File tempInputFile2 = File.createTempFile("predefinedWords", ".txt");
        tempInputFile.deleteOnExit();
        writer = new FileWriter(tempInputFile2);
        writer.write("he\n");
        writer.write("help\n");
        writer.close();
        inputNoMatchFile = tempInputFile2.getAbsolutePath();

        trie = new Trie() {
            Set<String> set = new HashSet<>();
            @Override
            public void insert(String word) {
                set.add(word);
            }

            @Override
            public boolean search(String word) {
                return set.contains(word);
            }
        };
    }


    @Test
    void getMatchingWordsShouldContainMatches(){
        WordMatcher wordMatcher = new WordMatcher(new TrieWordLoader(preDefinedWordsFile,trie));
        List<String> result;
        try {
            result = wordMatcher.getMatchingWords(inputFile);
        } catch (FileNotFoundException e) {
            result = null;
        }
        assertTrue(result != null && result.size() == matches.size()
                        && result.containsAll(matches) && matches.containsAll(result));
    }

    @Test
    void getMatchingWordsShouldContainNoMatches(){
        WordMatcher wordMatcher = new WordMatcher(new TrieWordLoader(preDefinedWordsFile,trie));
        List<String> result;
        try {
            result = wordMatcher.getMatchingWords(inputNoMatchFile);
        } catch (FileNotFoundException e) {
            result = null;
        }
        assertTrue(result != null && result.size() == 0);
    }

}
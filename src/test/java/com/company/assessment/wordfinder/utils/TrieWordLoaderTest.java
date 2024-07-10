package com.company.assessment.wordfinder.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;


class TrieWordLoaderTest {

    Trie trie;

    String filePath;

    @BeforeEach
    void setup() throws IOException {
        File tempFile = File.createTempFile("predefinedWords", ".txt");
        tempFile.deleteOnExit();
        FileWriter writer = new FileWriter(tempFile);
        writer.write("hello\n");
        writer.write("hi\n");
        writer.write("his\n");
        writer.close();
        filePath = tempFile.getAbsolutePath();
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
    void loadWillNotThrowExceptionOnValidFile(){
        boolean noException = true;
        TrieWordLoader loader = new TrieWordLoader(filePath,trie);

        try{
            loader.loadPredefinedWords();
        }catch (FileNotFoundException e){
            noException = false;
        }
        assertEquals(noException,true);
    }

    @Test
    void loadWillThrowExceptionOnInvalidFile(){
        boolean noException = true;
        TrieWordLoader loader = new TrieWordLoader("",trie);

        try{
            loader.loadPredefinedWords();
        }catch (FileNotFoundException e){
            noException = false;
        }
        assertEquals(noException,false);
    }

    @Test
    void reWillNotThrowExceptionOnValidFile(){
        boolean noException = true;
        TrieWordLoader loader = new TrieWordLoader(filePath,trie);

        try{
            loader.reLoadPredefinedWords();
        }catch (FileNotFoundException e){
            noException = false;
        }
        assertEquals(noException,true);
    }

    @Test
    void getTrieShouldReturnTrieOrEmptyOption(){
        TrieWordLoader loader = new TrieWordLoader(filePath,trie);
        assertEquals(loader.getTrie().get(),trie);
    }

    @Test
    void getTrieShouldReturnDifferentTrieOnEmptyTrie(){
        TrieWordLoader loader = new TrieWordLoader(filePath,null);
        assertNotEquals(loader.getTrie().get(),trie);
    }

}
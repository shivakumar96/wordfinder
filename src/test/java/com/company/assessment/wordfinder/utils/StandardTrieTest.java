package com.company.assessment.wordfinder.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardTrieTest {
    StandardTrie trie;
    @BeforeEach
    void setup(){
        trie = new StandardTrie();
    }
    @Test
    void emptyTrieShouldReturnFalse(){
        assertEquals(trie.search("hello"),false);
        assertEquals(trie.search(""),false);
        assertEquals(trie.search(null),false);
    }

    @Test
    void nonEmptyTrieShouldReturnFalseOnEmptyStringOrNull(){
        trie.insert("hello");
        assertEquals(trie.search(""),false);
        assertEquals(trie.search(null),false);
    }

    @Test
    void nonEmptyTrieShouldReturnTrueOnExactMatchOnly(){
        trie.insert("hello");
        trie.insert("hi");
        assertEquals(trie.search("hello"),true);
        assertEquals(trie.search("hi"),true);
        assertEquals(trie.search("he"),false);
    }


}
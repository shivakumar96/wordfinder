package com.company.assessment.wordfinder.utils;


import java.util.Map;

/**
 * This class implements the Trie operations and provides two methods
 * 1. insert: adds the word to the existing trie
 * 2. search: finds if the word is present in the data structure.
 */
public class StandardTrie implements Trie{

    //variable that stores the root trie node
    private StandardTrieNode rootTrieNode;

    /**
     * This constructor initializes the root trie
     */
    public StandardTrie(){
        rootTrieNode = new StandardTrieNode();
    }

    /**
     * Adds a new word to the trie memory (similar to english word dictionary),
     * ignores if it is already present
     * @param word : new word to be added
     */
    @Override
    public void insert(String word){
        if(word == null)
            return;
        char[] wordChars = word.toCharArray();
        StandardTrieNode next = rootTrieNode;
        for(int i=0; i<wordChars.length;i++){
            Map<Character, StandardTrieNode> children = next.getChildren();
            if(!children.containsKey(wordChars[i])){
                children.put(wordChars[i],new StandardTrieNode());
            }
            next = children.get(wordChars[i]);
        }
        next.setEnd(true);
    }

    /**
     * This method checks if the given word is present in the trie.
     * @param word : the search word
     * @return ture if the word is found else false
     */
    @Override
    public boolean search(String word){
        if (word == null)
            return false;
        char[] wordChars = word.toCharArray();
        StandardTrieNode next = rootTrieNode;
        for(int i=0; i<wordChars.length;i++){
            Map<Character, StandardTrieNode> children = next.getChildren();
            if(!children.containsKey(wordChars[i]))
                return false;
            next = children.get(wordChars[i]);
        }
        return next.isEnd();
    }
}

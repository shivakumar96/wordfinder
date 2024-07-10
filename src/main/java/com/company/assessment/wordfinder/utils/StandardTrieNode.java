package com.company.assessment.wordfinder.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the primitive Trie DataStructure, used to store and search words quickly
 * eg:  If we wanted to store words [have,has, him, had, cat ]
 *                      [  h  ,  c ]
 *                        |      |->[a]
 *                     [  a , i ]    |->[t]
 *            [ v , s ]<-|   |->[m]
 *              |->[e]
 */
public class StandardTrieNode {

    //Map variable children represents the next set of characters.
    private Map<Character, StandardTrieNode> children;

    // boolean variable isEnd represents the end of word, which indicates that the word is present in the word.
    private boolean isEnd ;

    /*
     * Default constructor that initialize children object and sets the isEnd variable:
     */
    public StandardTrieNode(){
        isEnd = false;
        children = new HashMap<>();
    }

    /* Getters and Setters */

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Map<Character, StandardTrieNode> getChildren() {
        return children;
    }
}

package com.company.assessment.wordfinder.utils;

/**
 * Basic Trie interface without deletion
 */
public interface Trie {
    public void insert(String word);
    public boolean search(String word);
}

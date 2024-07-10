# Assessment


**_Author Details:_** <br>
**Name: Shivakumar Suresh** <br>

## Task

**Task 1: Description: Write a program that reads a file and finds matches against a predefined set of words. There can be up to 10K entries in the list of predefined words.**

**_Requirement details:_**

- Input file is a plain text (ascii) file, every record separated by a new line.
- For this exercise, assume English words only
- The file size can be up to 20 MB
- The predefined words are defined in a text file, every word separated by a newline. Use a sample file of your choice for the set of predefined keywords for the exercise.


**Solution:**

The solution provided in this project makes use of the Trie data structure.
Here, I have used the Trie data structure to store the predefined words; doing this will allow efficient search.

In this project I have incorporated SOLID principles to implement the solution.

**Note: This is a Maven project, so to run load it as Maven project.**

- The code is present in the package
```
src/main/java/com/company/assessment
```

- The Core logic is present in the package
```
src/main/java/com/comapny/assessment/wordfinder
```

- I have also created test cases using Junit for the same under the folder
```
src/test/java/com/company/assessment
```


### Space and Time complexity:

**Time Complexity:**
- The time Complexity of predefined words Trie creation is O(n*l) <br>
  where, <br>
  n =  number of words present in the predefined words file.<br>
  l = average word size in the predefined word file. <br>
  This is because the average insertion cost is O(l) over n words.

<br>

- The time Complexity of matching input words is O(m*k) <br>
  where, <br>
  m =  number of words present in the input file. <br>
  k = average word size in the input file.<br>
  This is because the average cost of the search is O(k) over m words.

The total time complexity of reading predefined words and searching for input words is
```
O(n*l + m*k)
```

**Space Complexity:** <br>

we need to store only the predefined words, so,
The worst/Average time complexity will be:
```
O(n*l)
```

### Usage:

The Main class shows the usage of implementation of this project.
```
src/main/java/com/company/assessment/Main.java
```

I have created a sample of input and predefined word files in the resources directory
```
src/main/resources
```
- predefinedWords.txt : predefined words file.
- sampleInput.txt : input words file.


The usage of the code will be like :
```
import wordfinder.com.company.assessment.WordMatcher;
import utils.wordfinder.com.company.assessment.StandardTrie;
import utils.wordfinder.com.company.assessment.Trie;
import utils.wordfinder.com.company.assessment.TrieWordLoader;


String predefinedWords =  "src/main/resources/predefinedWords.txt";
String inputFile =  "src/main/resources/sampleInput.txt";

//here, Trie is an Interface
Trie trie = new StandardTrie();
TrieWordLoader wordLoader = new TrieWordLoader(predefinedWords, trie);
WordMatcher wordMatcher = new WordMatcher(wordLoader);

String outputMatchedWords file = "op1.txt";
wordMatcher.matchWords(inputFile,outputMatchedWords);
System.out.println(wordMatcher.getMatchingWords(inputFile));
```

#### Note:

- In this project, all File I/O operations will be performed line by line instead of reading the entire file and storing
  in memory.
  As a result, it will not cause any memory issues when a large number of words are present in the input file.<br>


- Here, I'm storing only predefined words; based on requirements, the maximum value it can have is 10K
  Assuming the average word length is 10, this project consumes a maximum of around 100KB of memory usage.


package com.company;

import java.util.*;

/*
 * Your task is to implement a part of a text processing library.
 *
 * The following are assumptions and definitions that limit the scope of the task:
 * *Word: To simplify, a word is represented by a sequence of one or more characters between „a‟ and „z‟ or between „A‟ and „Z‟). For example “agdfBh”.
 * Letter Case: When counting frequencies, we are interested in the case insensitive frequency (i.e. in the text “The sun shines over the lake”,
 * the library should count 2 occurrences for any of the words “the” or “The” or “tHE” etc).
 * Input Text: The input text contains words separated by various separator characters. Note that the characters from „a‟ and „z‟ and „A‟ and „Z‟ can only appear within words.
 * Available Memory: There is enough memory to store the whole input text.
 */

public class WordCounter extends UserInput implements WordFrequency, WordFrequencyAnalyzer {
    private String word;
    private String[] wordsArr;
    private int frequency;


    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public int calculateHighestFrequency(String text) {
        int highestFrequency = 0;
        setTextToArray(text);

        for (String x : wordsArr) {
            int counter = 0;
            for (String y : wordsArr) {
                if (x.equalsIgnoreCase(y)) {
                    counter++;
                }
                if (counter > highestFrequency) {
                    highestFrequency = counter;
                }
            }
        }
        return highestFrequency;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        frequency = 0;
        setTextToArray(text);

        for (String x : wordsArr) {
            if (x.equalsIgnoreCase(word)) {
                this.word = word;
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        setTextToArray(text);
        ArrayList<WordFrequency> wordFrequencyList = new ArrayList<WordFrequency>();


        loop:
        for (String word : wordsArr) {
            calculateFrequencyForWord(text, word);
            for (WordFrequency wf : wordFrequencyList) {
                if (wf.getWord().equalsIgnoreCase(word)) {
                    continue loop;
                }
            }
            wordFrequencyList.add(new WordCounter(word.toLowerCase(), frequency));
        }

        //sort list in alphabetical order
        Collections.sort(wordFrequencyList, new Comparator<WordFrequency>() {
            @Override
            public int compare(WordFrequency o1, WordFrequency o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        });

        //sort list by frequency (highest to lowest)
        Collections.sort(wordFrequencyList, new Comparator<WordFrequency>() {
            @Override
            public int compare(WordFrequency o1, WordFrequency o2) {
                return o2.getFrequency() - o1.getFrequency();
            }
        });

        return wordFrequencyList.subList(0, n);
    }


    public void setTextToArray(String text) {
        wordsArr = text.split("\\s+");
        for (int x = 0; x < wordsArr.length; x++) {
            wordsArr[x] = wordsArr[x].replaceAll("[^a-zA-Z]", "");
        }

    }

    @Override
    public String toString() {
        return "(\"" + getWord() + "\", " + getFrequency() + ")";
    }

    WordCounter() {
    }

    WordCounter(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

}




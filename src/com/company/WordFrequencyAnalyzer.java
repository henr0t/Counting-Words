package com.company;

import java.util.List;

public interface WordFrequencyAnalyzer {

    // CalculateHighestFrequency should return the highest frequency in the text (several words might have this frequency)
    int calculateHighestFrequency(String text);

    // CalculateFrequencyForWord should return the frequency of the specified word
    int calculateFrequencyForWord(String text, String word);

    // CalculateMostFrequentNWords should return a list of the most frequent „n‟ words in the input text, all the words returned in lower case.
    List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}


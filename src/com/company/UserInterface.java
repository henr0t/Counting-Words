package com.company;

public class UserInterface {

    public void start() {
        System.out.println("Word Count program:");

        WordCounter wordCounter = new WordCounter();
        String text = wordCounter.textInput();

        System.out.println("Highest Frequency of a word is: " + wordCounter.calculateHighestFrequency(text));


        System.out.println("Calculate frequency for word:");
        wordCounter.calculateFrequencyForWord(text, wordCounter.textInput());

        System.out.println("\"" + wordCounter.getWord() + "\"" + " is " + wordCounter.getFrequency() + "x in the text");

        System.out.println("List the top [insert int n] most frequent words:");
        for (WordFrequency object : wordCounter.calculateMostFrequentNWords(text, wordCounter.numberInput())) {
            System.out.println(object);
        }
    }
}

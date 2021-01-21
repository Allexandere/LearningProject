package com.example.translator.demo;

public class Translation {
    private final String firstWord;
    private final String secondWord;
    private final String firstLanguage;
    private final String secondLanguage;

    public Translation(String firstWord, String secondWord, String firstLanguage, String secondLanguage) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
    }

    public String requestTranslation(String from){
        if(from.equals(firstLanguage))
            return secondWord;
        return firstWord;
    }

    public boolean contains(String word){
        return word.equals(firstWord) || word.equals(secondWord);
    }
}

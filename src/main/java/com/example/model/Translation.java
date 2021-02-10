package com.example.model;

public class Translation {
    private final String fromWord;
    private final String toWord;
    private final String fromLanguage;
    private final String toLanguage;

    public Translation(String fromWord, String toWord, String fromLanguage, String toLanguage) {
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public String translate(String from) {
        if (from.equals(fromLanguage))
            return toWord;
        return fromWord;
    }

    public boolean contains(String word) {
        return word.equals(fromWord) || word.equals(toWord);
    }
}

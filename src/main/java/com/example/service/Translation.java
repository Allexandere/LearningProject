package com.example.service;

public class Translation {
    //TODO: старайся давать осмысленные имена переменным и методам. В данном случае лучше назвать переменные fromWord и toWord и тд
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

    //можно назвать проще translate(String from), будет лаконичнее, не нужно много букав
    //TODO: используй форматирование кода, чтобы было красиво и читабельно, можещь использовать google code style
    public String translate(String from) {
        if (from.equals(fromLanguage))
            return toWord;
        return fromWord;
    }

    public boolean contains(String word) {
        return word.equals(fromWord) || word.equals(toWord);
    }
}

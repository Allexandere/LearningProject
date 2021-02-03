package com.example.translator.demo;

public class Translation {
    //TODO: старайся давать осмысленные имена переменным и методам. В данном случае лучше назвать переменные fromWord и toWord и тд
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

    //можно назвать проще translate(String from), будет лаконичнее, не нужно много букав
    //TODO: используй форматирование кода, чтобы было красиво и читабельно, можещь использовать google code style
    public String requestTranslation(String from){
        if(from.equals(firstLanguage))
            return secondWord;
        return firstWord;
    }

    public boolean contains(String word){
        return word.equals(firstWord) || word.equals(secondWord);
    }
}

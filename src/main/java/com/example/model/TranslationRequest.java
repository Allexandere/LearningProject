package com.example.model;

import lombok.Data;

@Data
public class TranslationRequest {
    private String word;
    private String fromLanguage;
    private String toLanguage;


    public TranslationRequest(String someWord, String fromLanguage, String toLanguage) {
        this.word = someWord;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public TranslationRequest() {
    }
}

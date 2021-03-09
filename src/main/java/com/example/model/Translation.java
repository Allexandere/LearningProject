package com.example.model;

import lombok.Data;

@Data
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
}

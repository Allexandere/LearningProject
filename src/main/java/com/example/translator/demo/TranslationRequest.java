package com.example.translator.demo;

public class TranslationRequest {
    private final String translate;

    public TranslationRequest(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}

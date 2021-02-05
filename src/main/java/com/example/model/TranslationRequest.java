package com.example.model;

import lombok.Getter;

public class TranslationRequest {
    @Getter
    private final String translate;

    public TranslationRequest(String translate) {
        this.translate = translate;
    }

}

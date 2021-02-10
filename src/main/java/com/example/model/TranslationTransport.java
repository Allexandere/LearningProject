package com.example.model;

import lombok.Getter;

public class TranslationTransport {
    @Getter
    private final String translate;

    public TranslationTransport(String translate) {
        this.translate = translate;
    }

}

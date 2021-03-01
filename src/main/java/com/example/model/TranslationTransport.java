package com.example.model;

import lombok.Data;

@Data
public class TranslationTransport {
    private final String translate;
    public TranslationTransport(String translate) {
        this.translate = translate;
    }
}

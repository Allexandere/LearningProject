package com.example.translator.demo;

public class TranslationRequest {
    private final String translate;

    public TranslationRequest(String translate) {
        this.translate = translate;
    }

    //TODO: не пиши гетерры и сеттеры, упрости себе жизнь, используй lambook аннотации @Getter, @Setter, @Data
    public String getTranslate() {
        return translate;
    }
}

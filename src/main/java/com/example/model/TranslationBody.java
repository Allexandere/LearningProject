package com.example.model;

import lombok.Setter;

public class TranslationBody {
    @Setter
    private String from_word;
    @Setter
    private String to_word;

    public String getFrom_word() {
        return from_word;
    }

    public String getTo_word() {
        return to_word;
    }

}

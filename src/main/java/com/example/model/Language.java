package com.example.model;

import java.util.stream.Stream;

public enum Language {
    EN("en"),
    RU("ru"),
    FR("fr");

    private String language;

    Language(String language){this.language = language;}

    public String getLanguage(){return language;}

    public static Language decode(final String language) {
        return Stream.of(Language.values()).filter(targetEnum -> targetEnum.getLanguage().equals(language)).findFirst().orElse(null);
    }
}

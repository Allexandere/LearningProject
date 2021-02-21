package com.example.model;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
public class Translation {
    @Setter
    @Getter
    private String fromWord;
    @Setter
    @Getter
    private String toWord;
    @Setter
    @Getter
    private String fromLanguage;
    @Setter
    @Getter
    private String toLanguage;
    @Getter
    @Setter
    @Id
    @SequenceGenerator(
            name = "translation_sequence",
            sequenceName = "translation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "translation_sequence"
    )
    private Long id;


    public Translation(String fromWord, String toWord, String fromLanguage, String toLanguage) {
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public Translation() {
    }
}

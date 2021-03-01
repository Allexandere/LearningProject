package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Data
public class Translation {
    private String fromWord;
    private String toWord;
    private String fromLanguage;
    private String toLanguage;
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

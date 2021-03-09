package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Translation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromWord;
    private String toWord;
    private String fromLanguage;
    private String toLanguage;


    public Translation(String fromWord, String toWord, String fromLanguage, String toLanguage) {
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public Translation() {
    }
}

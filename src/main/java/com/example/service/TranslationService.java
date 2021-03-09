package com.example.service;

import com.example.model.Language;
import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class TranslationService {
    @Autowired
    private TranslationRepository translationRepository;

    public Translation addTranslation(TranslationBody translationBody, Language from, Language to){
        HashSet<Language> key = new HashSet<>(List.of(from, to));

        Translation newTranslation = new Translation(translationBody.getFrom_word(),
                translationBody.getTo_word(),
                from.getLanguage(),
                to.getLanguage());

        return translationRepository.createTranslation(key, newTranslation);
    }

    public Translation getTranslation(Language from, Language to, String word){
        HashSet<Language> key = new HashSet<>(List.of(from, to));

        return translationRepository.getTranslation(key, word);
    }
}

package com.example.service;

import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.repository.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TranslateService {

    private final TranslateRepository translateRepository;

    @Autowired
    public TranslateService(TranslateRepository translateRepository) {
        this.translateRepository = translateRepository;
    }

    public String findTranslation(String from, String to, String word) {
        Optional<Translation> translation = translateRepository.findTranslationByFromLanguageAndToLanguageAndFromWord(from, to, word);
        return translation.map(Translation::getToWord).orElse(null);
    }

    public TranslationBody addTranslation(TranslationBody translation, String from, String to) {
        translateRepository.save(new Translation(translation.getFrom_word(), translation.getTo_word(), from, to));
        translateRepository.save(new Translation(translation.getTo_word(), translation.getFrom_word(), to, from));
        return translation;
    }
}

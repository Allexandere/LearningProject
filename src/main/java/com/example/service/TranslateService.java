package com.example.service;

import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.model.TranslationTransport;
import com.example.repository.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TranslateService {

    private final TranslateRepository translateRepository;

    @Autowired
    public TranslateService(TranslateRepository translateRepository) {
        this.translateRepository = translateRepository;
    }

    public ResponseEntity<TranslationTransport> translating(String from, String to, String word) {
        Optional<Translation> translation = translateRepository.findTranslationByFromLanguageAndToLanguageAndFromWord(from, to, word);
        return translation.map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(new TranslationTransport(value.getToWord())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public TranslationBody addTranslation(TranslationBody translation, String from, String to) {
        translateRepository.save(new Translation(translation.getFrom_word(), translation.getTo_word(), from, to));
        translateRepository.save(new Translation(translation.getTo_word(), translation.getFrom_word(), to, from));
        return translation;
    }
}

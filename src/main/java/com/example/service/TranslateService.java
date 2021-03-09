package com.example.service;

import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.model.TranslationRequest;
import com.example.repository.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TranslateService {

    @Autowired
    private TranslateRepository translateRepository;

    public Translation findTranslation(TranslationRequest translationRequest) {
        return translateRepository.getTranslation(translationRequest);
    }

    public Translation addTranslation(TranslationBody translationBody, String from, String to) {
        /*
        1)т.к. не знаю как реализовать поиск перевода, имея только одну запись в словаре нужного типа
        2)т.к. не знаю как не добовлять новую запись, когда она уже присутствует
         */
        Translation translation = new Translation(translationBody.getFrom_word(), translationBody.getTo_word(), from, to);
        Translation reversedTranslation = new Translation(translationBody.getTo_word(), translationBody.getFrom_word(), to, from);
        translateRepository.createTranslation(reversedTranslation);
        return translateRepository.createTranslation(translation);
    }
}

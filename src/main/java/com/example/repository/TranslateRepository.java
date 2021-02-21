package com.example.repository;

import com.example.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateRepository extends JpaRepository<Translation, Long> {
    Optional<Translation> findTranslationByFromLanguageAndToLanguageAndFromWord(String fromLanguage, String toLanguage, String fromWord);
}

package com.example.repository;

import com.example.model.Language;
import com.example.model.Translation;
import org.springframework.stereotype.Repository;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TranslationRepository {
    private final AbstractMap<HashSet<Language>, HashSet<Translation>> dictionary = new ConcurrentHashMap<>();

    public Translation createTranslation(HashSet<Language> key, Translation translation) {
        if (dictionary.containsKey(key) && dictionary.get(key).contains(translation))
            return null;
        else if (dictionary.containsKey(key))
            dictionary.get(key).add(translation);
        else
            dictionary.put(key, new HashSet<>(List.of(translation)));
        return translation;
    }

    public Translation getTranslation(HashSet<Language> key, String word) {
        if (!dictionary.containsKey(key))
            return null;

        for (Translation translation : dictionary.get(key))
            if (translation.getFromWord().equals(word) || translation.getToWord().equals(word))
                return translation;

        return null;
    }
}

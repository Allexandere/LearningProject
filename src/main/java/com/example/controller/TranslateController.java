package com.example.controller;

//P.S все, что помечено как TODO, нужно сделать

/* TODO
* Почитай про паттерн MVC, мы будем его использовать и следуя этому паттерну тебе нужно создать пакеты:
    * controller
    * service
    * repository
    * model
и разместить классы в них
Используй java 8 в проекте
* */

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.model.TranslationTransport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    public static final AbstractMap<HashSet<Language>, HashSet<Translation>> dictionary =
            new ConcurrentHashMap<>();

    enum Language {
        en,
        ru,
        fr
    }

    @GetMapping("/{from}/{to}/{word}")
    public ResponseEntity<TranslationTransport> translating(@PathVariable Language from, @PathVariable Language to, @PathVariable String word) {
        HashSet<Language> request = new HashSet<>();
        request.add(from);
        request.add(to);
        if (dictionary.containsKey(request)) {
            for (Translation translation : dictionary.get(request))
                if (translation.contains(word))
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new TranslationTransport(translation.translate(from.toString())));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{from}/{to}/")
    @ResponseBody
    public TranslationBody addPair(TranslationBody translation,
                                   @PathVariable Language from,
                                   @PathVariable Language to) {
        HashSet<Language> request = new HashSet<>();
        request.add(from);
        request.add(to);
        Translation newTranslation = new Translation(translation.getFrom_word(),
                translation.getTo_word(),
                from.toString(),
                to.toString());
        if (dictionary.containsKey(request)) {
            dictionary.get(request).add(newTranslation);
        } else {
            HashSet<Translation> tmp = new HashSet<>();
            tmp.add(newTranslation);
            dictionary.put(request, tmp);
        }
        return translation;
    }
}

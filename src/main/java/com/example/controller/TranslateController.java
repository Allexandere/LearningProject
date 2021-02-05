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

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import com.example.service.Translation;
import com.example.model.TranslationBody;
import com.example.model.TranslationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    public static final ConcurrentHashMap<HashSet<String>, HashSet<Translation>> dictionary =
            new ConcurrentHashMap<HashSet<String>, HashSet<Translation>>();

    @GetMapping("/{from}/{to}/{word}")
    public Object translating(@PathVariable String from, @PathVariable String to, @PathVariable String word) {
        //TODO: Идеалогически, ты возвращаешь ответ в этом методе, то есть это будет response, тогда правильнее было бы назвать не
        // TranslationRequest а TranslationResponse, но мы будем использовать паттерт <Entity>Transport, то есть если сущность Trsnsaltion, то для нее DTO класс
        // будет TranslationTransport
        /*TODO: Сделаем рефакторинг. Добавим
        enum Language {
            EN("eng"),
            RU("rus"),
            FR("fr");
        }

        и теперь мы будем работать не со строками, а с типом Language. String from = "eng" будет маппиться в Language EN
        */


        HashSet<String> request = new HashSet<String>();
        request.add(from);
        request.add(to);
        if (dictionary.containsKey(request)) {
            for (Translation translation : dictionary.get(request))
                if (translation.contains(word))
                    return new TranslationRequest(translation.translate(from));
        }
        //TODO: Для того, чтобы возвращать сущности с кодами ошибок используй ResponseEntity<T>
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{from}/{to}/")
    @ResponseBody
    public TranslationBody addPair(TranslationBody translation,
                                   @PathVariable String from,
                                   @PathVariable String to) {
        HashSet<String> request = new HashSet<String>();
        request.add(from);
        request.add(to);
        if (dictionary.contains(request)) {
            dictionary.get(request).add(new Translation(translation.getFrom_word()
                    , translation.getTo_word()
                    , from,
                    to));
            return translation;
        } else {
            Translation newTranslation = new Translation(translation.getFrom_word(),
                    translation.getTo_word(),
                    from,
                    to);
            HashSet<Translation> tmp = new HashSet<>();
            tmp.add(newTranslation);
            dictionary.put(request, tmp);
            return translation;
        }
    }
}

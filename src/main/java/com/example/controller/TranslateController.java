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

import com.example.model.TranslationBody;
import com.example.model.TranslationTransport;
import com.example.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final TranslateService translateService;

    @Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/{from}/{to}/{word}")
    public ResponseEntity translating(@PathVariable String from,
                                      @PathVariable String to,
                                      @PathVariable String word) {
        String translation = translateService.findTranslation(from, to, word);
        if(translation != null)
            return ResponseEntity.status(HttpStatus.OK).body(new TranslationTransport(translation));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/{from}/{to}/")
    @ResponseBody
    public ResponseEntity addTranslation(TranslationBody translation,
                                          @PathVariable String from,
                                          @PathVariable String to) {
        TranslationBody translationBody = translateService.addTranslation(translation, from, to);
        return ResponseEntity.status(HttpStatus.OK).body(translationBody);
    }
}

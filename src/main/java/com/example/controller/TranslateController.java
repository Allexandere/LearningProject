package com.example.controller;

import com.example.model.Translation;
import com.example.model.TranslationBody;
import com.example.model.TranslationRequest;
import com.example.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/{from}/{to}/{word}")
    public ResponseEntity<?> translating(@PathVariable String from,
                                         @PathVariable String to,
                                         @PathVariable String word)
    {
        Translation translation = translateService.findTranslation(new TranslationRequest(word, from, to));

        if(translation != null)
            return ResponseEntity.status(HttpStatus.OK).body(translation.getToWord());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/{from}/{to}/")
    public ResponseEntity<?> addTranslation(@RequestBody TranslationBody translationBody,
                                            @PathVariable String from,
                                            @PathVariable String to)
    {
        Translation addedTranslation = translateService.addTranslation(translationBody, from, to);
        if(addedTranslation == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Translation already exists.");

        return ResponseEntity.status(HttpStatus.OK).body(addedTranslation);
    }
}

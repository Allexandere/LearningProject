package com.example.controller;

import com.example.model.Language;
import com.example.service.TranslationService;
import com.example.model.Translation;
import com.example.model.TranslationBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslationService translationService;

    @GetMapping("/{from}/{to}/{word}")
    public ResponseEntity<?> getTranslation(@PathVariable String from,
                                            @PathVariable String to,
                                            @PathVariable String word) {
        Translation foundTranslation = translationService.getTranslation(Language.decode(from), Language.decode(to), word);

        if (foundTranslation == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Translation not found.");

        String fromWord = foundTranslation.getFromWord();
        String toWord = foundTranslation.getToWord();
        return ResponseEntity.status(HttpStatus.OK).body(toWord.equals(word) ? fromWord : toWord);
    }

    @PostMapping(value = "/{from}/{to}/")
    public ResponseEntity<?> createTranslation(@RequestBody TranslationBody translationBody,
                                               @PathVariable String from,
                                               @PathVariable String to) {
        Translation createdTranslation = translationService.addTranslation(translationBody, Language.decode(from), Language.decode(to));

        if (createdTranslation == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Translation already exists.");

        return ResponseEntity.status(HttpStatus.OK).body(createdTranslation);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> createTranslation() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

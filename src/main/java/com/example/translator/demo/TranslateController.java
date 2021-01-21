package com.example.translator.demo;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    public static final ConcurrentHashMap<HashSet<String>, HashSet<Translation>>  dictionary =
            new ConcurrentHashMap<HashSet<String>,  HashSet<Translation>>();

    @GetMapping("/{from}/{to}/{word}")
    public TranslationRequest translating(@PathVariable String from, @PathVariable String to, @PathVariable String word) {
        HashSet<String> request = new HashSet<String>();
        request.add(from);
        request.add(to);
        if(dictionary.containsKey(request)){
            for(Translation translation : dictionary.get(request))
                if(translation.contains(word))
                    return new TranslationRequest(translation.requestTranslation(from));
        }
        return new TranslationRequest("404");
    }

    @PostMapping(value = "/{from}/{to}/")
    @ResponseBody
    public TranslationBody addPair(TranslationBody translation,
                                   @PathVariable String from,
                                   @PathVariable String to){
        HashSet<String> request = new HashSet<String>();
        request.add(from);
        request.add(to);
        if(dictionary.contains(request)){
            dictionary.get(request).add(new Translation(translation.getFrom_word()
                    , translation.getTo_word()
                    , from,
                    to));
            return translation;
        }
        else{
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

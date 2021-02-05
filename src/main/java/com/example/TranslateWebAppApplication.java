package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslateWebAppApplication {

    public static void main(String[] args) {
		/*
		Translation newTranslation = new Translation("milk","молоко","en","ru");
		Translation newTranslation1 = new Translation("cow","корова","en","ru");
		Translation newTranslation2 = new Translation("cheese","сыр","en","ru");

		HashSet<Translation> tmp = new HashSet<>();
		tmp.add(newTranslation);
		tmp.add(newTranslation1);
		tmp.add(newTranslation2);
		HashSet<String> request = new HashSet<String>();
		request.add("en");
		request.add("ru");
		TranslateController.dictionary.put(request, tmp);
		System.out.println(TranslateController.dictionary);
		 */
        SpringApplication.run(TranslateWebAppApplication.class, args);
    }
}

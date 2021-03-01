package com.github.ahenteti.dictionary.app;

import com.github.ahenteti.dictionary.api.DictionaryService;
import com.github.ahenteti.dictionary.api.IDictionaryService;

import java.util.Optional;

public class DictionaryDemo {

    public static void main(String[] args) {
        IDictionaryService dictionaryService = DictionaryService.getInstance();
        System.out.println(DictionaryDemo.lookup(dictionaryService, "book"));
        System.out.println(DictionaryDemo.lookup(dictionaryService, "editor"));
        System.out.println(DictionaryDemo.lookup(dictionaryService, "xml"));
        System.out.println(DictionaryDemo.lookup(dictionaryService, "REST"));
    }

    public static String lookup(IDictionaryService dictionary, String word) {
        StringBuilder res = new StringBuilder(word);
        res.append(": ");
        Optional<String> definition = dictionary.getDefinition(word);
        if (definition.isPresent()) {
            res.append(definition.get());
        } else {
            res.append("Cannot find definition for this word.");
        }
        return res.toString();
    }
}

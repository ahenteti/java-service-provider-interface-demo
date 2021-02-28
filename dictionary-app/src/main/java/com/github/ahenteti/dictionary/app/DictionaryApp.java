package com.github.ahenteti.dictionary.app;

import com.github.ahenteti.dictionary.api.DictionaryService;
import com.github.ahenteti.dictionary.api.IDictionaryService;

import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class DictionaryApp {

    public static void main(String[] args) {
        IDictionaryService dictionaryService = DictionaryService.getInstance();
        System.out.println(DictionaryApp.lookup(dictionaryService, "book"));
        System.out.println(DictionaryApp.lookup(dictionaryService, "editor"));
        System.out.println(DictionaryApp.lookup(dictionaryService, "xml"));
        System.out.println(DictionaryApp.lookup(dictionaryService, "REST"));
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

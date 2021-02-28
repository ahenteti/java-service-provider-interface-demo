package com.github.ahenteti.dictionary.impl;

import com.github.ahenteti.dictionary.api.IDictionaryService;

import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class TechnicalDictionary implements IDictionaryService {

    private SortedMap<String, String> map;

    public TechnicalDictionary() {
        map = new TreeMap<>();
        map.put("xml", "a document standard often used in web services, among other things");
        map.put("REST", "an architecture style for creating, reading, updating, and deleting data that attempts to use the common vocabulary of the HTTP protocol; Representational State Transfer");
    }

    @Override
    public Optional<String> getDefinition(String word) {
        return Optional.ofNullable(map.get(word));
    }
}

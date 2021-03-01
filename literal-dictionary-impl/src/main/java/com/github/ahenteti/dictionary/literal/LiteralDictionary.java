package com.github.ahenteti.dictionary.literal;

import com.github.ahenteti.dictionary.api.IDictionaryService;

import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class LiteralDictionary implements IDictionaryService {

    private SortedMap<String, String> map;

    public LiteralDictionary() {
        map = new TreeMap<>();
        map.put("book", "a set of written or printed pages, usually bound with a protective cover");
        map.put("editor", "a person who edits");
    }

    @Override
    public Optional<String> getDefinition(String word) {
        return Optional.ofNullable(map.get(word));
    }
}

package com.github.ahenteti.dictionary.api;

import java.util.Optional;

public interface IDictionaryService {
    Optional<String> getDefinition(String word);
}

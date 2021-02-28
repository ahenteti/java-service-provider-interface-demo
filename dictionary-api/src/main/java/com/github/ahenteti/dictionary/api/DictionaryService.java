package com.github.ahenteti.dictionary.api;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

public class DictionaryService implements IDictionaryService {

    private static DictionaryService service;
    private ServiceLoader<IDictionaryService> loader;

    private DictionaryService() {
        loader = ServiceLoader.load(IDictionaryService.class);
    }

    public static synchronized DictionaryService getInstance() {
        if (service == null) {
            service = new DictionaryService();
        }
        return service;
    }

    @Override
    public Optional<String> getDefinition(String word) {
        Iterator<IDictionaryService> services = loader.iterator();
        while (services.hasNext()) {
            IDictionaryService service = services.next();
            Optional<String> definition = service.getDefinition(word);
            if (definition.isPresent()) return definition;
        }
        return Optional.empty();
    }
}

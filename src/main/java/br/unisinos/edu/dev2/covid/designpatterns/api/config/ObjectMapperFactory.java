package br.unisinos.edu.dev2.covid.designpatterns.api.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    public enum CreationType {
        DEFAULT_CONFIGS,
        JACKSON_DEFAULT_CONFIGS
    }


    public static ObjectMapper create(CreationType type) {
        var objectMapper = new ObjectMapper();

        if(type == CreationType.DEFAULT_CONFIGS) {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
            objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        }

        return objectMapper;
    }
}

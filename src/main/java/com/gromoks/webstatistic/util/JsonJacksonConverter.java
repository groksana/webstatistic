package com.gromoks.webstatistic.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonJacksonConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <K> String toJson(K list) {
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error in Json convert", e);
        }
    }
}

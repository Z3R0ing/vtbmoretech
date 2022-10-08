package ru.wherebackend.vtbmoretech.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T mapJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.toString());
        }
    }

}

package io.deeplay.internship.java.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Parser {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T processInputStream(InputStream is, Class<T> clazz) throws IOException {
        var mapper = new ObjectMapper();
        return mapper.readValue(is, clazz);
    }
}

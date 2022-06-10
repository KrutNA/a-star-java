package io.deeplay.internship.java.parser.data;

import java.util.Map;

public record CostInput (
        Map<String, Map<Character, Integer>> data
        ) {
}

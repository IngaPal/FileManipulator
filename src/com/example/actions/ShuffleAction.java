package com.example.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleAction implements Action {
    public static List<String> execute(List<String> lines) {
        List<String> shuffledLines = new ArrayList<>(lines);
        Collections.shuffle(shuffledLines);
        return shuffledLines;
    }
}
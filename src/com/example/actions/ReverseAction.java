package com.example.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseAction implements Action {
    public static List<String> execute(List<String> lines) {
        List<String> reversedLines = new ArrayList<>(lines);
        Collections.reverse(reversedLines);
        return reversedLines;
    }
}
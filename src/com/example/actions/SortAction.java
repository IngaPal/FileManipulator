package com.example.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAction implements Action {
    public static List<String> execute(List<String> lines) {
        List<String> sortedLines = new ArrayList<>(lines);
        Collections.sort(sortedLines);
        return sortedLines;
    }
}
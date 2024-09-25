package com.example.actions;

import java.util.List;

public interface Action {
    static List<String> execute(List<String> lines) {
        throw new UnsupportedOperationException("This method should be implemented in concrete actions");
    }
}
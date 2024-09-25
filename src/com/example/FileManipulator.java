package com.example;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java FileManipulator <input_file> <output_file> <action>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String action = args[2];

        try {
            List<String> lines = readFile(inputFile);
            List<String> manipulatedLines = performAction(lines, action);
            writeFile(outputFile, manipulatedLines);
            System.out.println("File manipulation completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static List<String> readFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void writeFile(String filename, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static List<String> performAction(List<String> lines, String actionName) throws Exception {
        String className = "com.example.actions." +
                actionName.substring(0, 1).toUpperCase() +
                actionName.substring(1) + "Action";

        Class<?> actionClass = Class.forName(className);
        Method method = actionClass.getMethod("execute", List.class);
        return (List<String>) method.invoke(null, lines);
    }
}
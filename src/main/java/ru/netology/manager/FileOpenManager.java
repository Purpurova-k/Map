package ru.netology.manager;

import java.util.*;

public class FileOpenManager {

    private Map<String, String> programsForFiles = new HashMap<>();

    // Добавить новое приложение для открытия файлов с определённым расширением
    public void addProgram(String extension, String program) {
        if (!programsForFiles.containsKey(extension)) {
            programsForFiles.put(extension.toLowerCase(), program);
        } else {
            throw new RuntimeException("Приложение " + program + " уже существует");
        }
    }


    // Получить название приложения, предназначенного для открытия файла с определённым расширением
    public String getProgram(String extension) {
        if (programsForFiles.containsKey(extension.toLowerCase())) {
            return programsForFiles.get(extension.toLowerCase());
        } else {
            throw new RuntimeException("Приложения для открытия файла с расширением " + extension.toLowerCase() + " не существует");
        }
    }


    // Удалить привязку приложения к определённому расширению
    public void deleteProgram(String extension) {
        if (programsForFiles.containsKey(extension.toLowerCase())) {
            programsForFiles.remove(extension.toLowerCase());
        } else {
            throw new RuntimeException("Приложения для файла с расширением " + extension.toLowerCase() + " не существует");
        }
    }


    // Получить список всех зарегистрированных расширений, к которым привязаны приложения для открытия
    // Сортирован по алфавиту
    public Set<String> getAllExtensions() {
        TreeSet<String> listExtensions = new TreeSet<>(programsForFiles.keySet());
        return listExtensions;
    }


    // Получить список всех приложений, которые привязаны к каким-либо расширениям
    // Уникальные значения с сортировкой по алфавиту
    public Set<String> getAllPrograms() {
        TreeSet<String> listPrograms = new TreeSet<>(programsForFiles.values());
        return listPrograms;
    }
}

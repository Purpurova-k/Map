package ru.netology.manager;

import java.util.*;
import java.util.stream.Collectors;

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
    // Неудачный вариант
//    public HashSet<String> getAllExtensions() {
//        HashSet<String> setExtensions = new HashSet<>(programsForFiles.keySet());
//        List<String> sortedListExtensions = new ArrayList<>(setExtensions);
//
//        Collections.sort(sortedListExtensions);
//
//        HashSet<String> newSetExtensions = new HashSet<>(sortedListExtensions);
//
//        return newSetExtensions;
//    }



     // Второй неудачный вариант
//    public List<String> getAllExtensions() {
//        Set<String> listExtensions = new HashSet<>(programsForFiles.keySet());
//        return (List<String>) listExtensions.stream().sorted();
//    }



    // Удачный варинат, но без сортировки по алфавиту
    public Set<String> getAllExtensions() {
        return programsForFiles.keySet();
    }




    // Получить список всех приложений, которые привязаны к каким-либо расширениям
    // Возвращает уникальные значения (программы), но без сортировки по алфавиту
    public Set<String> getAllPrograms() {
       return new HashSet<>(programsForFiles.values());
    }
}

package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    private FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    public void setUp() {
        manager.addProgram(".jpg", "Adobe Photoshop");
        manager.addProgram(".pdf", "Adobe Acrobat Reader");
        manager.addProgram(".doc", "Microsoft Office Word");
        manager.addProgram(".ppt", "Microsoft PowerPoint");
        manager.addProgram(".rar", "WinZip");
        manager.addProgram(".zip", "WinZip");
    }


    @Test
    public void shouldNotAddExistingExtension() {
        assertThrows(RuntimeException.class, () -> manager.addProgram(".jpg", "Paint"));
    }


    @Test
    public void shouldGetProgram() {
        String expected = "Adobe Acrobat Reader";
        String actual = manager.getProgram(".pdf");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldGetProgramUpperCase() {
        String expected = "Adobe Acrobat Reader";
        String actual = manager.getProgram(".PDF");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldNotGetNotExistingProgram() {
        assertThrows(RuntimeException.class, () -> manager.getProgram(".jar"));
    }


    @Test
    public void shouldDeleteProgram() {
        manager.deleteProgram(".doc");
        manager.deleteProgram(".ppt");

        TreeSet<String> expected = new TreeSet<>(Set.of(".jpg", ".pdf", ".rar", ".zip"));
        Set<String> actual = manager.getAllExtensions();

        assertIterableEquals(expected, actual);
    }


    @Test
    public void shouldNotDeleteNotExistingProgram() {
        assertThrows(RuntimeException.class, () -> manager.deleteProgram(".jar"));
    }


    @Test
    public void shouldGetAllExtensions() {
        TreeSet<String> expected = new TreeSet<>(Set.of(".doc", ".jpg", ".pdf", ".ppt", ".rar", ".zip"));
        Set<String> actual = manager.getAllExtensions();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }


    @Test
    public void shouldGetAllPrograms() {
        TreeSet<String> expected = new TreeSet<>(Set.of
                ("Adobe Acrobat Reader", "Adobe Photoshop", "Microsoft Office Word", "Microsoft PowerPoint", "WinZip"));
        Set<String> actual = manager.getAllPrograms();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
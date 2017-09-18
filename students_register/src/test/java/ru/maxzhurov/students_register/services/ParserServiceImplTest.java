package ru.maxzhurov.students_register.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.maxzhurov.students_register.dto.Group;

import java.util.*;

public class ParserServiceImplTest extends Assert {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ParserService parserService;

    public ParserServiceImplTest() {
        parserService = new ParserServiceImpl();
    }

    @Before
    public void setup() {

    }

    @Test
    public void testForGetLinesFromNullText() {
        assertNull(parserService.getLines(null));
    }

    @Test
    public void testForGetLinesFromEmptyText() {
        assertNull(parserService.getLines(""));
    }

    @Test
    public void testForGetLinesCheckSizeForFilledText() {
        final String text = "a" + System.lineSeparator() + "b";

        assertNotNull(parserService.getLines(text));
        assertEquals(2, parserService.getLines(text).size());
    }

    @Test
    public void testForGetGroupsFromNullLines() {
        assertEquals(new HashMap<String, Group>(), parserService.getGroups(null));
    }

    @Test
    public void testForGetGroupsFromEmptyLines() {
        assertEquals(new HashMap<String, Group>(), parserService.getGroups(Collections.emptyList()));
    }

    @Test
    public void testForGetGroupsFromCheckSizeForFilledLines() {
        final List<String> lines = Arrays.asList("1:aaa", "2:bbb");

        assertNotNull(parserService.getGroups(lines));
        assertEquals(lines.size(), parserService.getGroups(lines).size());
    }

    @Test
    public void testForGetStudentFromNullLines() {
        assertNull(parserService.getStudents(null));
    }

    @Test
    public void testForGetStudentsFromEmptyLines() {
        assertNull(parserService.getStudents(Collections.emptyList()));
    }

    @Test
    public void testForGetStudentsCheckSizeFromFilledLines() {
        final List<String> lines = Arrays.asList(":Muhammad_Ali ", ":Alibaba ");

        assertNotNull(parserService.getStudents(lines));
        assertEquals(lines.size(), parserService.getStudents(lines).size());
    }

    @Test
    public void testForGetTasksFromNullLine() {
        assertNull(parserService.getTasks(null));
    }

    @Test
    public void testForGetTasksFromEmptyLine() {
        assertNull(parserService.getTasks(""));
    }

    @Test
    public void testForGetTasksCheckSizeFromFilledLine() {
        final String string = "not_passed/passed/not_passed";

        assertNotNull(parserService.getTasks(string));
    }
}

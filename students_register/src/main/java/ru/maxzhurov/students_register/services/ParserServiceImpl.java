package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.Group;
import ru.maxzhurov.students_register.dto.Student;
import ru.maxzhurov.students_register.dto.Task;

import java.util.*;

public class ParserServiceImpl implements ParserService {

    final String PASSED = "passed";
    final String NOTPASSED = "not_passed";

    @Override
    public List<String> getLines(final String text) {
        if (text != null && !text.isEmpty() && text.contains(System.lineSeparator())) {
            final String[] lines = text.split(System.lineSeparator());

            return Arrays.asList(lines);
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Group> getGroups(final List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Group> groupMap = new HashMap<>();

        for (String line : lines) {
            line = line.trim();

            if (line.contains(Separators.GROUP.toString())) {
                final String groupName = getSubString(line, 0, Separators.GROUP);

                groupMap.put(groupName, new Group());
            }
        }

        return groupMap;
    }

    @Override
    public List<Student> getStudents(final List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            return null;
        }

        List<Student> studentList = new ArrayList<>();

        for (String line : lines) {
            final Student student = parseStudent(line);

            if (student != null) {
                studentList.add(parseStudent(line));
            }
        }

        return studentList;
    }

    @Override
    public List<Task> getTasks(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        List<Task> taskList = new ArrayList<>();

        line = line.replaceFirst(Separators.STUDENT.toString(), Separators.REPLACEMENT.toString());
        line = line.trim();

        final int count = getTasksCount(line);

        for (int i = 0; i < count; i++) {

            final String subString = line.contains(Separators.TASK.toString()) ?
                    getSubString(line, 0, Separators.TASK)
                    : line;
            line = line.substring(line.indexOf(Separators.TASK.toString()) + 1);

            final Task task = parseTask(subString);

            if (task != null) {
                taskList.add(task);
            }
        }

        return taskList;
    }

    private Student parseStudent(final String line) {

        if (line.contains(Separators.STUDENT.toString())) {
            final String nameAndSurname = getSubString(line, Separators.GROUP, Separators.STUDENT);
            final String name = nameAndSurname.contains(Separators.NAME.toString()) ?
                    getSubString(nameAndSurname, Separators.GROUP, Separators.NAME)
                    : getSubString(nameAndSurname, Separators.GROUP, nameAndSurname.length());
            final String surname = nameAndSurname.contains(Separators.NAME.toString()) ?
                    getSubString(nameAndSurname, Separators.NAME, nameAndSurname.length()) : null;

            return new Student(name, surname);
        } else {
            return null;
        }
    }

    private String getSubString(final String string, final int startIndex, final Separators endSeparator) {
        return string.substring(startIndex, string.indexOf(endSeparator.toString()));
    }

    private String getSubString(final String string, final Separators startSeparator, final Separators endSeparator) {
        return string.substring(string.indexOf(startSeparator.toString()) + 1, string.indexOf(endSeparator.toString()));
    }

    private String getSubString(final String string, final Separators startSeparator, final int endIndex) {
        return string.substring(string.indexOf(startSeparator.toString()) + 1, endIndex);
    }

    private int getTasksCount(String line) {
        int count = 0;

        while (line.contains(Separators.TASK.toString())) {
            count++;

            line = line.replaceFirst(Separators.TASK.toString(), Separators.REPLACEMENT.toString());
        }

        count += (count > 0) ? 1 : 0;

        return count;
    }

    private Task parseTask(final String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        final boolean passed = getSubString(line.toLowerCase(), Separators.STUDENT, line.length()).equals(PASSED);

        return new Task(passed);
    }
}

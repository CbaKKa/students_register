package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.Group;
import ru.maxzhurov.students_register.dto.Student;
import ru.maxzhurov.students_register.dto.Task;

import java.util.List;
import java.util.Map;

public interface ParserService {
    List<String> getLines(final String text);
    Map<String, Group> getGroups(final List<String> lines);
    List<Student> getStudents(final List<String> lines);
    List<Task> getTasks(final String line);
}

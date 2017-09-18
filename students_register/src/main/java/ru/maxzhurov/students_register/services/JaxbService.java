package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.Group;

import java.util.List;

public interface JaxbService {
    public void saveList(final List<Group> groupList, final String path);

    public List<Group> loadList(final String path);
}

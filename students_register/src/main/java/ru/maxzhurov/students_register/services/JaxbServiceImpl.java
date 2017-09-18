package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.Group;

import java.util.List;

public class JaxbServiceImpl implements JaxbService {
    private final String FILE_NAME = "groups.xml";

    @Override
    public void saveList(final List<Group> groupList, final String path) {

    }

    @Override
    public List<Group> loadList(final String path) {
        return null;
    }
}

package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.GroupList;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface JAXBService {
    void saveList(final GroupList groupList, final String path) throws JAXBException;

    GroupList loadList(final String path) throws JAXBException, FileNotFoundException;

    void createFile(final String path) throws JAXBException;

    void showData(final String path) throws JAXBException, FileNotFoundException;
}

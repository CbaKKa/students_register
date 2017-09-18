package ru.maxzhurov.students_register.services;

import java.io.File;

public interface ReaderService {
    File getFile(final String path);

    String getText(final File file);

    String getText(final String path);
}

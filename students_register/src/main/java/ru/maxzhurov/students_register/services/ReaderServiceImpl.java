package ru.maxzhurov.students_register.services;

import java.io.*;

public class ReaderServiceImpl implements ReaderService {

    public ReaderServiceImpl() {
    }

    @Override
    public File getFile(final String path) {
        return new File(path);
    }

    @Override
    public String getText(final File file) {
        if (file == null || file.isDirectory()) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           String currentLine;

           while ((currentLine = bufferedReader.readLine()) != null) {
               stringBuilder.append(currentLine);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    @Override
    public String getText(final String path) {
        return path == null || path.isEmpty() ? null : getText(getFile(path));
    }
}

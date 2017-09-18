package ru.maxzhurov.students_register.services;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

public class ReaderServiceImplTest extends Assert {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private ReaderService readerService;

    public ReaderServiceImplTest() {
        this.readerService = new ReaderServiceImpl();
    }

    @Before
    public void setup(){

    }

    @Test
    public void testForGetFileByNull() throws NullPointerException {
        exception.expect(NullPointerException.class);

        final File file = readerService.getFile(null);
    }

    @Test
    public void testForGetFileByEmptyPath() {
        assertNotNull(readerService.getFile(""));
    }

    @Test
    public void testForGetTextByEmptyPath() {
        assertNull(readerService.getText(""));
    }

    @Test
    public void testForGetTextByNullPath() {
        final String path = null;
        assertNull(readerService.getText(path));
    }

    @Test
    public void testForGetTextByNullFile() {
        assertNull(readerService.getText((File) null));
    }

    @Test
    public void testForGetTextByEmptyFile() {
        assertNotNull(readerService.getText(new File("")));
    }
}

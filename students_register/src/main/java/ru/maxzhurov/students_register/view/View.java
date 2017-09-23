package ru.maxzhurov.students_register.view;

import ru.maxzhurov.students_register.dto.GroupList;
import ru.maxzhurov.students_register.services.JAXBService;
import ru.maxzhurov.students_register.services.JAXBServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Scanner;

abstract class View {
    private static final String GREETING_MESSAGE = "Students' register started";
    private static final String FILE_LOADED = "File loaded";

    private Scanner scanner = new Scanner(System.in);

    private JAXBService jaxbService;
    private GroupList groupList;

    public View() {
        jaxbService = new JAXBServiceImpl();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void execute() throws IOException {
        System.out.println(GREETING_MESSAGE + "\n");

        while (true) {
            final String command = scanner.next().toLowerCase();

            switch (command) {
                case Commands.LOAD_FILE:
                    try {
                        groupList = jaxbService.loadList(null);

                        System.out.println(FILE_LOADED + "\n");
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    break;
//                case Commands.ADD_GROUP
            }
        }
    }
}

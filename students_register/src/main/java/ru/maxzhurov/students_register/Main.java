package ru.maxzhurov.students_register;

import ru.maxzhurov.students_register.dto.*;
import ru.maxzhurov.students_register.services.JAXBService;
import ru.maxzhurov.students_register.services.JAXBServiceImpl;

import javax.xml.bind.JAXBException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        ConsoleView.execute();

        TaskList taskList = new TaskList(Arrays.asList(true, false));

        Student firstStudent = new Student("first", "student", taskList);

        taskList = new TaskList(Arrays.asList(false, false));

        Student secondStudent = new Student("second", "student", taskList);

        Student thirdStudent = new Student("as", "as");
        Student fourthStudent = new Student("da", "da");

        Group firstGroup = new Group(Arrays.asList(firstStudent, secondStudent), "1 группа");
        Group secondGroup = new Group(Arrays.asList(thirdStudent, fourthStudent), "2 группа");

        GroupList groupList = new GroupList(Arrays.asList(firstGroup, secondGroup));

        JAXBService jaxbService = new JAXBServiceImpl();

        try {
            jaxbService.saveList(groupList, null);

            Thread.sleep(500);

            System.out.println("\n------------------\n");

            jaxbService.loadList(null);
        } catch (JAXBException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

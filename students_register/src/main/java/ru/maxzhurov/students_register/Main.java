package ru.maxzhurov.students_register;

import ru.maxzhurov.students_register.view.ConsoleView;
import ru.maxzhurov.students_register.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            View view = new ConsoleView();

            view.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        TaskList taskList = new TaskList(Arrays.asList(true, false));
//
//        Student firstStudent = new Student("first", "student", taskList);
//
//        taskList = new TaskList(Arrays.asList(false, false));
//
//        Student secondStudent = new Student("second", "student", taskList);
//
//        Student thirdStudent = new Student("as", "as");
//        Student fourthStudent = new Student("da", "da");
//
//        Group firstGroup = new Group("1 группа", Arrays.asList(firstStudent, secondStudent));
//        Group secondGroup = new Group("2 группа", Arrays.asList(thirdStudent, fourthStudent));
//
//        GroupList groupList = new GroupList(Arrays.asList(firstGroup, secondGroup));
//
//        JAXBService jaxbService = new JAXBServiceImpl();
//
//        try {
//            jaxbService.saveList(groupList, null);
//
//            Thread.sleep(500);
//
//            System.out.println("\n------------------\n");
//
//            jaxbService.loadList(null);
//        } catch (JAXBException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

package ru.maxzhurov.students_register;

import ru.maxzhurov.students_register.dto.*;
import ru.maxzhurov.students_register.view.ConsoleView;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.FactoryConfigurationError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        try {
            File file = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(GroupList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(groupList, System.out);
            jaxbMarshaller.marshal(groupList, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

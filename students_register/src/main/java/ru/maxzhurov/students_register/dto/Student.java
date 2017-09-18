package ru.maxzhurov.students_register.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = XMLTags.STUDENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {

    private String name;
    private String surname;

    @XmlElement(name = XMLTags.TASK)
    private TaskList taskList;

    public Student() {

    }

    public Student(String name, String surname, TaskList taskList) {
        this.name = name;
        this.surname = surname;
        this.taskList = taskList;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}

package ru.maxzhurov.students_register.dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = XMLTags.GROUP)
@XmlAccessorType(XmlAccessType.FIELD)
public class Group implements Serializable {

    private String id;

    @XmlElement(name = XMLTags.STUDENT)
    private List<Student> studentList;

    public Group() {

    }

    public Group(List<Student> students, String id) {
        this.studentList = students;
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> students) {
        this.studentList = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

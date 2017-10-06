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

    public Group(final String id, final List<Student> students) {
        this.studentList = students;
        this.id = id;
    }

    public Group(String id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(final List<Student> students) {
        this.studentList = students;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Group)
        {
            final Group group = (Group) obj;

            return group.getId().equals(getId());
        } else {
            return false;
        }
    }
}

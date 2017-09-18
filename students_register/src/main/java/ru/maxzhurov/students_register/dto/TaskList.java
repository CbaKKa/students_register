package ru.maxzhurov.students_register.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = XMLTags.TASKS)
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskList implements Serializable {

    @XmlElement(name = XMLTags.TASK)
    private List<Boolean> taskList;

    public TaskList() {
    }

    public TaskList(List<Boolean> taskList) {
        this.taskList = taskList;
    }

    public List<Boolean> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Boolean> taskList) {
        this.taskList = taskList;
    }
}

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
    private List<Boolean> tasks;

    public TaskList() {
    }

    public TaskList(final List<Boolean> tasks) {
        this.tasks = tasks;
    }

    public List<Boolean> getTasks() {
        return tasks;
    }

    public void setTasks(final List<Boolean> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (final boolean task : getTasks()) {
            stringBuilder.append(task).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}

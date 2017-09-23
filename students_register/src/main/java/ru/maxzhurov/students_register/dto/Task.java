package ru.maxzhurov.students_register.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = XMLTags.TASK)
@XmlAccessorType(XmlAccessType.FIELD)
public class Task implements Serializable {

    @XmlElement
    private boolean passed;

    public Task() {

    }

    public Task(final boolean passed) {
        this.passed = passed;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(final boolean passed) {
        this.passed = passed;
    }
}

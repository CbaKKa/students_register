package ru.maxzhurov.students_register.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = XMLTags.GROUPS)
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupList implements Serializable {

    @XmlElement(name = XMLTags.GROUP)
    private List<Group> groups;

    public GroupList() {
    }

    public GroupList(final List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (getGroups() == null) {
            return "";
        }

        for (final Group group : getGroups()) {
            if (group.getStudentList() == null) {
                stringBuilder.append(group.getId()).append(" | empty").append("\n");
                continue;
            } else {
                if (group.getStudentList().isEmpty()) {
                    stringBuilder.append(group.getId()).append(" | empty").append("\n");

                    continue;
                }
            }

            for (final Student student : group.getStudentList()) {
                stringBuilder.append(group.getId()).append(" | ")
                        .append(student.toString()).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    public Group getGroupById(final String id) {
        for (final Group group : getGroups()) {
            if (group.getId().equals(id)) {
                return group;
            }
        }

        return null;
    }
}

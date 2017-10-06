package ru.maxzhurov.students_register.view;

public enum Notifications {
    GREETING_MESSAGE("\nStudents' register started\n"),
    FILE_LOADED("\nFile loaded\n"),
    FILE_NOT_FOUND("\nFile not found\n"),
    FILE_HAS_BEEN_CREATED("\nFile has been created\n"),
    FILE_HAS_BEEN_SAVED("\nFile has been saved\n"),
    STUDENT_ADDED("\nStudent has been added\n"),
    LIST_OF_GROUPS("\nList of groups:\n"),
    GROUP_SELECTED("\nGroup has been selected \n"),
    NO_GROUPS("\nNo groups\n"),
    PLS_SELECT_GROUP("\nPlease, select group\n"),
    UNKNOWN_COMMAND("\nUnknown command\n"),
    GROUP_HAS_BEEN_ADDED("\nGroup has been added\n"),
    GROUP_HAS_BEEN_DELETED("\nGroup has been deleted\n"),
    NO_GROUP("\nNo group\n"),
    NO_STUDENT("\nNo student\n"),
    STUDENT_HAS_BEEN_DELETED("\nStudent has been deleted\n"),
    PATH_SET("\nPath set\n");

    private String string;

    Notifications(final String string) {
        this.string = string;
    }


    @Override
    public String toString() {
        return string;
    }
}

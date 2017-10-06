package ru.maxzhurov.students_register.view;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import ru.maxzhurov.students_register.dto.Group;
import ru.maxzhurov.students_register.dto.GroupList;
import ru.maxzhurov.students_register.dto.Student;
import ru.maxzhurov.students_register.dto.TaskList;
import ru.maxzhurov.students_register.services.JAXBService;
import ru.maxzhurov.students_register.services.JAXBServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class View {
    private static final String GREETING_MESSAGE = Colors.ANSI_YELLOW.toString() + Notifications.GREETING_MESSAGE +
            Colors.ANSI_YELLOW.toString();

    private static final String FILE_LOADED = Colors.PANSI_RESET.toString() + Notifications.FILE_LOADED +
            Colors.PANSI_RESET.toString();
    private static final String FILE_NOT_FOUND = Colors.ANSI_RED.toString() + Notifications.FILE_NOT_FOUND +
            Colors.ANSI_RED.toString();
    private static final String FILE_HAS_BEEN_CREATED = Colors.PANSI_RESET.toString() +
            Notifications.FILE_HAS_BEEN_CREATED + Colors.PANSI_RESET.toString();
    private static final String FILE_HAS_BEEN_SAVED = Colors.PANSI_RESET.toString() +
            Notifications.FILE_HAS_BEEN_SAVED + Colors.PANSI_RESET.toString();

    private static final String STUDENT_ADDED = Colors.PANSI_RESET.toString() + Notifications.STUDENT_ADDED +
            Colors.PANSI_RESET.toString();
    private static final String LIST_OF_GROUPS = Colors.PANSI_RESET.toString() + Notifications.LIST_OF_GROUPS +
            Colors.PANSI_RESET.toString();
    private static final String GROUP_HAS_BEEN_ADDED = Colors.PANSI_RESET.toString() +
            Notifications.GROUP_HAS_BEEN_ADDED + Colors.PANSI_RESET.toString();
    private static final String GROUP_HAS_BEEN_DELETED = Colors.ANSI_RED.toString() +
            Notifications.GROUP_HAS_BEEN_DELETED + Colors.ANSI_RED.toString();
    private static final String NO_GROUP = Colors.ANSI_RED.toString() + Notifications.NO_GROUP
            + Colors.ANSI_RED.toString();
    private static final String STUDENT_HAS_BEEN_DELETED = Colors.ANSI_RED.toString() +
            Notifications.STUDENT_HAS_BEEN_DELETED + Colors.ANSI_RED.toString();
    private static final String PATH_SET = Colors.ANSI_YELLOW.toString() + Notifications.PATH_SET +
            Colors.ANSI_YELLOW.toString();
    private String GROUP_SELECTED = Colors.ANSI_YELLOW.toString() + Notifications.GROUP_SELECTED +
            Colors.ANSI_YELLOW.toString();

    private static final String NO_GROUPS = Colors.PANSI_RESET.toString() + Notifications.NO_GROUPS +
            Colors.PANSI_RESET.toString();
    private static final String PLS_SELECT_GROUP = Colors.ANSI_RED.toString() + Notifications.PLS_SELECT_GROUP +
            Colors.ANSI_RED.toString();
    private static final String UNKNOWN_COMMAND = Colors.ANSI_RED.toString() + Notifications.UNKNOWN_COMMAND +
            Colors.ANSI_RED.toString();
    private static final String COMMANDS = "\nCommands:\n";

    private Scanner scanner = new Scanner(System.in);

    private JAXBService jaxbService;
    private GroupList groupList;

    @SuppressWarnings("WeakerAccess")
    public View() {
        jaxbService = new JAXBServiceImpl();
        groupList = new GroupList();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void execute() throws IOException {
        // TODO: 23.09.2017 make show data

        String path = null;

        String lastGroupId = null;

        System.out.println(GREETING_MESSAGE + "\n");
        System.out.print(Colors.PANSI_RESET.toString());
        System.out.println(COMMANDS);
        System.out.println(Commands.LOAD_FILE);
        System.out.println(Commands.CREATE_FILE);
        System.out.println(Commands.SAVE);
        System.out.println(Commands.SHOW_INFO);
        System.out.println(Commands.ADD_GROUP);
        System.out.println(Commands.SELECT_GROUP);
        System.out.println(Commands.ADD_STUDENT);
        System.out.println(Commands.DELETE_GROUP);
        System.out.println(Commands.EXIT);

        while (true) {
            final String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            final String[] commands = input.split(" ");
            final String command = getCommand(commands);
            final List<String> commandArgs = getCommandArgs(commands);

            if (command == null) {
                continue;
            }

            switch (command) {
                case Commands.LOAD_FILE:
                    try {
                        groupList = jaxbService.loadList(path);

                        System.out.println(FILE_LOADED);
                    } catch (JAXBException | FileNotFoundException e) {
                        System.out.println(FILE_NOT_FOUND);
                    }
                    break;

                case Commands.CREATE_FILE:
                    try {
                        jaxbService.createFile(commandArgs != null ? commandArgs.get(0) : null);

                        System.out.println(FILE_HAS_BEEN_CREATED);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    break;

                case Commands.SAVE:
                    try {
                        jaxbService.saveList(groupList, path);

                        System.out.println(FILE_HAS_BEEN_SAVED);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    break;

                case Commands.SHOW_INFO:
                    final String output = LIST_OF_GROUPS + groupList.toString();

                    System.out.println(output.isEmpty() ? NO_GROUPS : output);
                    break;

                case Commands.ADD_GROUP:
                    final String id = getGroupId(commandArgs != null ? commandArgs.get(0) : null);

                    try {
                        addGroup(id);

                        System.out.println(GROUP_HAS_BEEN_ADDED);
                    } catch (IllegalArgumentException ignored) {

                    }
                    break;

                case Commands.SELECT_GROUP:
                    lastGroupId = getSelectedGroupId(commandArgs != null ? commandArgs.get(0) : null);

                    if (lastGroupId == null) {
                        System.out.println(PLS_SELECT_GROUP);
                    } else {
                        System.out.println(GROUP_SELECTED);
                    }
                    break;

                case Commands.DELETE_GROUP:
                    deleteGroup(commandArgs != null ? commandArgs.get(0) : null);

                    System.out.println(GROUP_HAS_BEEN_DELETED);
                    break;

                case Commands.ADD_STUDENT:
                    addStudent(commandArgs, lastGroupId);

                    System.out.println(STUDENT_ADDED);
                    break;

                case Commands.DELETE_STUDENT:
                    deleteStudent(commandArgs, lastGroupId);

                    System.out.println(STUDENT_HAS_BEEN_DELETED);
                    break;

                case Commands.LAST_GROUP:
                    System.out.println(lastGroupId);
                    break;

                case Commands.SET_PATH:
                    path = setPath(commandArgs != null ? commandArgs.get(0) : null);

                    System.out.println(PATH_SET);
                    break;

//                case Commands.SHOW_DATA:
//                    try {
//                        jaxbService.showData(path);
//                    } catch (JAXBException e) {
//                        e.printStackTrace();
//                    }
//                    break;

                case Commands.EXIT:
                    return;

                default:
                    System.out.println(UNKNOWN_COMMAND);
                    break;
            }
        }
    }

    @Nullable
    private String getCommand(final String[] commands) {
        if (commands.length != 0) {
            return commands.length >= 2 ? commands[0].toLowerCase() + " "
                    + commands[1].toLowerCase() : commands[0].toLowerCase();
        } else {
            return null;
        }
    }

    @Nullable
    private List<String> getCommandArgs(final String[] commands) {
        if (commands.length > 2) {
            final List<String> commandList = new ArrayList<>();
            commandList.addAll(Arrays.asList(commands).subList(2, commands.length));

            return commandList;
        } else {
            return null;
        }
    }

    private void addGroup(final String id) {
        if (id == null) {
            return;
        }

        if (id.isEmpty()) {
            return;
        }

        if (groupList.getGroups() == null) {
            groupList.setGroups(new ArrayList<>());
        }

        List<Group> groups = groupList.getGroups();

        if (groups.isEmpty()) {
            groups.add(new Group(id, new ArrayList<>()));
        } else {
            if (!groups.contains(new Group(id))) {
                groups.add(new Group(id, new ArrayList<>()));
            } else {
                throw new IllegalArgumentException("Unable to add group");
            }
        }
    }

    @Contract("null -> null")
    @SuppressWarnings("ConstantConditions")
    private String getGroupId(final String commandArgs) {
        return (commandArgs != null && !commandArgs.isEmpty()) ? commandArgs.trim() : null;
    }

    @Contract(pure = true)
    private String getSelectedGroupId(final String commandArgs) {
        return commandArgs;
    }

    private void addStudent(final List<String> commandArgs, final String groupId) {
        final Student student = getStudent(commandArgs);

        if (student == null) {
            return;
        }

        final Group group = groupList.getGroupById(groupId);

        if (group == null) {
            System.out.println(PLS_SELECT_GROUP);
            return;
        }

        if (group.getStudentList() == null) {
            group.setStudentList(new ArrayList<>());
        }

        group.getStudentList().add(student);
    }

    @Nullable
    private Student getStudent(final List<String> commandArgs) {
        if (commandArgs.isEmpty()) {
            return null;
        }

        final String name = commandArgs.get(0);
        final String surname = commandArgs.get(1);

        final Student student = new Student(name, surname);

        if (commandArgs.isEmpty()) {
            return student;
        }

        final TaskList taskList = new TaskList();

        if (commandArgs.size() <= 2) {
            return student;
        }

        final List<String> tasks = commandArgs.subList(2, commandArgs.size() - 1);
        final List<Boolean> list = new ArrayList<>();

        for (final String task : tasks) {
            list.add(Boolean.valueOf(task));
        }

        taskList.setTasks(list);
        student.setTaskList(taskList);

        return student;
    }

    private void deleteGroup(final String groupId) {
        final Group group = groupList.getGroupById(groupId);

        if (group == null) {
            System.out.println(NO_GROUP);
            return;
        }

        groupList.getGroups().remove(group);
    }

    private void deleteStudent(final List<String> commandArgs, final String groupId) {
        final Group group = groupList.getGroupById(groupId);

        if (group == null) {
            System.out.println(NO_GROUP);

            return;
        }

        final Student student = getStudent(commandArgs);

        if (group.getStudentList() != null) {
            group.getStudentList().remove(student);
        }
    }

    @Contract(pure = true)
    private String setPath(final String commandArgs) {
        return commandArgs;
    }
}

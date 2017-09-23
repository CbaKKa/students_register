package ru.maxzhurov.students_register.services;

import ru.maxzhurov.students_register.dto.GroupList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBServiceImpl implements JAXBService {
    private final String FILE_NAME = "groups.xml";

    @Override
    public void saveList(final GroupList groupList, final String path) throws JAXBException {
        final File file = getFile(path == null ? FILE_NAME : path);

        final Marshaller jaxbMarshaller = getMarshaller();

        jaxbMarshaller.marshal(groupList, System.out);
        jaxbMarshaller.marshal(groupList, file);
    }

    @Override
    public GroupList loadList(final String path) throws JAXBException {
        final File file = getFile(path == null ? FILE_NAME : path);

        Unmarshaller unmarshaller = getUnmarshaller();
        GroupList groupList = (GroupList) unmarshaller.unmarshal(file);

        System.out.println(groupList);

        return groupList;
    }

    private File getFile(final String path) {
        return new File(path);
    }

    private Marshaller getMarshaller() throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(GroupList.class);
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        return jaxbMarshaller;
    }

    private Unmarshaller getUnmarshaller() throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(GroupList.class);
        return jaxbContext.createUnmarshaller();
    }
}

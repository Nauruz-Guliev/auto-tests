package ru.kpfu.itis.provider;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import ru.kpfu.itis.model.TestData;

import java.io.File;

import static ru.kpfu.itis.TextColorizer.*;

public class TestDataProvider {

    public TestData getUserData(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(TestData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (TestData) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException exception) {
            System.out.println(makeRed(exception.getMessage()));
            return null;
        }
    }
}

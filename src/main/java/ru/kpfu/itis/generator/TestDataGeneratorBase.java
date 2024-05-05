package ru.kpfu.itis.generator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import ru.kpfu.itis.model.TestData;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static ru.kpfu.itis.TextColorizer.*;

public class TestDataGeneratorBase {

    private Scanner scanner;
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public TestDataGeneratorBase() {
        scanner = new Scanner(System.in);
        try {
            context = JAXBContext.newInstance(TestData.class);
            marshaller = context.createMarshaller();
            unmarshaller = context.createUnmarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }
    }

    protected static void println(String message) {
        System.out.println(message);
    }

    protected static String generateRandomString(int length) {
        return new Random().ints(48, 122 + 1)
                .filter(i -> (i <= 57 || (i >= 65 && i <= 90) || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    protected String readUserInput(String message) {
        String userInput;
        do {
            System.out.println(makeBlue(message));
            userInput = scanner.nextLine();
            if (!isValidInput(userInput)) {
                System.out.println(makeRed("Введите корректное значение!"));
            }
        } while (!isValidInput(userInput));
        return userInput;
    }

    protected int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, 20);
    }

    protected static boolean isValidInput(String input) {
        return !input.isEmpty() && !input.isBlank() && !input.matches("^\\s+$");
    }

    protected boolean save(TestData testData, String fileName) {
        try {
            File file = new File(fileName);
            marshaller.marshal(testData, file);
            return true;
        } catch (JAXBException exception) {
            return false;
        }
    }

    protected void read(String fileName) {
        try {
            println(makeGreen("Создан и сохранен xml-объект: \n"));
            TestData person = (TestData) unmarshaller.unmarshal(new File(fileName));
            println(makePurple(person.toString()));
        } catch (JAXBException exception) {
            println(makeRed("Не удалось прочитать файл. " + exception.getMessage()));
        }
    }
}

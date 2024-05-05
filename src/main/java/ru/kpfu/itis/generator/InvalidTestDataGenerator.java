package ru.kpfu.itis.generator;

import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.TestData;

import static ru.kpfu.itis.TextColorizer.*;

public class InvalidTestDataGenerator extends TestDataGeneratorBase {

    public static void main(String[] args) {
        new InvalidTestDataGenerator();
    }

    public InvalidTestDataGenerator() {
        super();
        run();
    }

    private void run() {
        println(makeCyan("*** Генератор НЕвалидных тестовых данных ***"));
        TestData testData = TestData.builder()
                .baseUrl(Constants.BASE_URL)
                .email(generateRandomString(getRandomInt()))
                .password(generateRandomString(getRandomInt()))
                .noteTitle(generateRandomString(getRandomInt()))
                .noteText(generateRandomString(getRandomInt()))
                .build();
        if(!save(testData, Constants.INVALID_FILE_NAME)) {
            println(makeRed("Не удалось сохранить файл"));
        } else {
            read(Constants.INVALID_FILE_NAME);
        }
    }
}
package ru.kpfu.itis.generator;

import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.TestData;

import static ru.kpfu.itis.TextColorizer.*;

public class ValidTestDataGenerator extends TestDataGeneratorBase {

    public static void main(String[] args) {
        new ValidTestDataGenerator();
    }

    public ValidTestDataGenerator() {
        super();
        run();
    }

    private void run() {
        println(makeCyan("*** Генератор валидных тестовых данных ***"));
        TestData testData = TestData.builder()
                .baseUrl(Constants.BASE_URL)
                .email(readUserInput("Введите логин:"))
                .password(readUserInput("Введите пароль:"))
                .noteTitle(readUserInput("Введите заголовок заметки:"))
                .noteText(readUserInput("Введите текст заметки:"))
                .build();
        if(!save(testData, Constants.VALID_FILE_NAME)) {
            println(makeRed("Не удалось сохранить файл"));
        } else {
            read(Constants.VALID_FILE_NAME);
        }
    }
}
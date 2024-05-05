package ru.kpfu.itis.generator;

import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.UserData;
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
        UserData userData = UserData.builder()
                .baseUrl(Constants.BASE_URL)
                .email(readUserInput("Введите логин:"))
                .password(readUserInput("Введите пароль:"))
                .noteText(readUserInput("Введите текст заметки:"))
                .build();
        if(!save(userData, Constants.VALID_FILE_NAME)) {
            println(makeRed("Не удалось сохранить файл"));
        } else {
            read(Constants.VALID_FILE_NAME);
        }
    }
}
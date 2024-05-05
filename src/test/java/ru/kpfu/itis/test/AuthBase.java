package ru.kpfu.itis.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.TestData;
import ru.kpfu.itis.provider.TestDataProvider;

import static ru.kpfu.itis.app.AppManager.*;

public class AuthBase extends TestBase {

    @BeforeAll
    public static void doBeforeAll() {
        app = getInstance();
        TestDataProvider testDataProvider= new TestDataProvider();
        try {
            TestData testDataObject = testDataProvider.getUserData(Constants.VALID_FILE_NAME);
            app.getNavigationHelper().goMainPage(testDataObject.getBaseUrl());
            app.getAuthHelper().login(testDataObject);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @AfterAll
    public static void closeApp() {
        app.close();
    }
}

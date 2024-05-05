package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kpfu.itis.app.AppManager;
import ru.kpfu.itis.model.TestData;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager app) {
        super(app);
    }


    public void login(TestData testData) {
        if (isLoggedIn()) {
            if (isLoggedIn(testData.getEmail())) {
                return;
            }
        //    logout(testData.getAccountCode());
        }
    }

    public void logout() {
        getElementByLinkText("Выйти").click();
    }

    public boolean isLoggedIn() {
        // проверка наличия кнопки "Войти"
        return app.getDriver().findElements(By.name("commit")).isEmpty();
    }

    public boolean isLoggedIn(String nickname) {
        // проверка наличия кнопки пользователя, текст кнопки совпадает с ником
        return !app.getDriver().findElements(By.linkText(nickname)).isEmpty();
    }
}

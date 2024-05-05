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
            logout();
        }
        getElementByLinkText("Log In").click();
        getElementByName("username").sendKeys(testData.getEmail());
        getElementByName("password").sendKeys(testData.getPassword());
        getElementByCssSelector(".ui-button-text").click();
    }

    public WebElement getUsername() {
        return getElementByName("username");
    }

    public void logout() {
        getElementByLinkText("Sign Out").click();
    }

    public boolean isLoggedIn() {
        return checkElementExistsLinkText("My Account");
    }
}

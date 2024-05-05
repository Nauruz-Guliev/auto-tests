package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kpfu.itis.app.AppManager;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager app) {
        super(app);
    }

    public void goMainPage(String baseUrl) {
        app.getDriver().get(baseUrl);
        getElementByCssSelector("img").click();
    }

    public void openNote(String noteTitle) {
        getElementByLinkText(noteTitle).click();
    }
}

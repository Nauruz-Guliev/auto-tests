package ru.kpfu.itis.helper;

import org.openqa.selenium.WebElement;
import ru.kpfu.itis.app.AppManager;

public class CreateHelper extends HelperBase {

    public CreateHelper(AppManager app) {
        super(app);
    }

    public void createNote(String text, String title) {
        WebElement textArea = getElementById("textarea");
        WebElement titleArea = getElementByName("notetitle");
        titleArea.click();
        titleArea.sendKeys(title);
        textArea.click();
        textArea.sendKeys(text);
        getElementByCssSelector(".ui-button-text").click();
    }

    public WebElement getNote() {
        return getElementByCssSelector(".text6");
    }
}

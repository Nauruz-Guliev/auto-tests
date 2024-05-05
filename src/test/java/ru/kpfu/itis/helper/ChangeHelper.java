package ru.kpfu.itis.helper;

import org.openqa.selenium.WebElement;
import ru.kpfu.itis.app.AppManager;

public class ChangeHelper extends HelperBase {

    public ChangeHelper(AppManager app) {
        super(app);
    }

    public void changeNote(String text) {
        getElementByLinkText("Edit Note").click();
        WebElement textarea = getElementById("textarea");
        textarea.click();
        textarea.clear();
        textarea.sendKeys(text);
        getElementByCssSelector(".ui-button-text").click();
    }

    public WebElement getNote() {
        return getElementByCssSelector(".text6");
    }
}

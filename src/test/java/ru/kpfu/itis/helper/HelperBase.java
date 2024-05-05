package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kpfu.itis.app.AppManager;

import java.time.Duration;

public class HelperBase {

    protected final AppManager app;

    public HelperBase(AppManager app) {
        this.app = app;
    }

    protected WebElement getElementById(String id) {
        return app.getDriver().findElement(By.id(id));
    }

    protected WebElement getElementByName(String name) {
        return app.getDriver().findElement(By.name(name));
    }

    protected WebElement getElementByLinkText(String linkText) {
        return app.getDriver().findElement(By.linkText(linkText));
    }

    protected WebElement getElementByCssSelector(String cssSelector) {
        return app.getDriver().findElement(By.cssSelector(cssSelector));
    }

    protected WebElement getElementByClassName(String className) {
        return app.getDriver().findElement(By.className(className));
    }

    protected void wait(int seconds) {
        app.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public boolean checkElementExistsByName(String name) {
        return !app.getDriver().findElements(By.name(name)).isEmpty();
    }

    public boolean checkElementExistsLinkText(String name) {
        return !app.getDriver().findElements(By.linkText(name)).isEmpty();
    }
}

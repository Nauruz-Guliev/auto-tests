package ru.kpfu.itis.helper;


import ru.kpfu.itis.app.AppManager;

public class DeleteHelper extends HelperBase {

    public DeleteHelper(AppManager app) {
        super(app);
    }

    public void deleteNote() {
        getElementByLinkText("Delete Note").click();
        app.getDriver().switchTo().alert().accept();
    }
}

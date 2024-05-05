package ru.kpfu.itis.helper;

import ru.kpfu.itis.app.AppManager;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager app) {
        super(app);
    }

    public void goMainPage(String baseUrl) {
        app.getDriver().get(baseUrl);
    }
}

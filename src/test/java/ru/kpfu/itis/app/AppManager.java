package ru.kpfu.itis.app;


import lombok.Data;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.kpfu.itis.helper.CreateHelper;
import ru.kpfu.itis.helper.DeleteHelper;
import ru.kpfu.itis.helper.LoginHelper;
import ru.kpfu.itis.helper.NavigationHelper;

@Data
public class AppManager {

    private final ChromeDriver driver;
    private static final ThreadLocal<AppManager> app = new ThreadLocal<>();

    private final CreateHelper createHelper;
    private final DeleteHelper deleteHelper;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;


    public AppManager() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.createHelper = new CreateHelper(this);
        this.deleteHelper = new DeleteHelper(this);
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new LoginHelper(this);
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }

    public static AppManager getInstance() {
        if(app.get() == null) {
            app.set(new AppManager());
        }
        return app.get();
    }
}

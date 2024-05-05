package ru.kpfu.itis.app;


import lombok.Data;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kpfu.itis.helper.*;

@Data
public class AppManager {

    private final ChromeDriver driver;
    private static final ThreadLocal<AppManager> app = new ThreadLocal<>();

    private final CreateHelper createHelper;
    private final ChangeHelper changeHelper;
    private final DeleteHelper deleteHelper;
    private final NavigationHelper navigationHelper;
    private final AuthHelper authHelper;


    public AppManager() {
        //      ChromeOptions chromeOptions = new ChromeOptions();
        //      chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.changeHelper = new ChangeHelper(this);
        this.createHelper = new CreateHelper(this);
        this.deleteHelper = new DeleteHelper(this);
        this.navigationHelper = new NavigationHelper(this);
        this.authHelper = new AuthHelper(this);
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

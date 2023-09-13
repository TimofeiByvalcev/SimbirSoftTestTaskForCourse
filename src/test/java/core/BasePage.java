package core;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {

    protected static WebDriver driver;

    public static void SetDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}


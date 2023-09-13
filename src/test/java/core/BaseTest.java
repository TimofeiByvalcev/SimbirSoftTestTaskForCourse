package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Timofei//Downloads//chromedriver-win64//chromedriver.exe");

        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(320, 1512));
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        BasePage.SetDriver(driver);

    }

    @After
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}

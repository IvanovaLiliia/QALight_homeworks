package aqa_lecture_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void driverInit() {
        driver = new ChromeDriver();
        driver.get("https://www.metro.ua/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void driverQuit() {
        driver.quit();
    }
}

package aqa_lecture_10.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    private WebDriver driver;
    private WebDriverWait waiter;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void login(String login, String password) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_id']")));

        driver.findElement(By.xpath("//input[@id='user_id']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    public String getMessage() {

        By toastLocator = By.xpath("//span[@class='user-business']");
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(toastLocator)).getText();
    }

    public String getErrorMessage() {

        By toastLocator = By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')]");
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(toastLocator)).getText();
    }
}

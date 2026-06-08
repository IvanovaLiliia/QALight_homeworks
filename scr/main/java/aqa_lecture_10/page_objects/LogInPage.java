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
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void login () {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Створити акаунт']")));
        driver.findElement(By.xpath("//input[@id='user_id']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }
}

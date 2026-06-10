package aqa_lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void EnterEmail(String password) {
        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type='text' and contains(@class,'field')]")
                )
        );

        searchField.sendKeys(password, Keys.ENTER);

    }

    public void clickOnForgetPassword() {
        WebElement RemindButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/ua/reminder/']"))
        );
        RemindButton.click();
    }

}

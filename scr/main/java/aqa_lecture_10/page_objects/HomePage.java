package aqa_lecture_10.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait waiter;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnLogInButton() {

        WebElement loginButton = waiter.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'field-button-text') and @href='/metro/services/idamstream/login']")
                )
        );
        loginButton.click();
    }
}

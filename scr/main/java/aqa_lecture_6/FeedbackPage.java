package aqa_lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeedbackPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnShopOption() {
        WebElement OptionButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='store-existing']"))
        );
        OptionButton.click();
    };

    public void enterName (String searchWord) {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='name']"))
        );
        nameInput.sendKeys(searchWord, Keys.ENTER);
    };

    public void enterMail (String searchWord) {
        WebElement mailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='name']"))
        );
        mailInput.sendKeys(searchWord, Keys.ENTER);
    };



}

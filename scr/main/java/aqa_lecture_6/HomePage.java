package aqa_lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterSearchWord(String searchWord) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Знайти товар, магазин, бренд']"))
        );
        searchField.sendKeys(searchWord, Keys.ENTER);
    };

    public void clickOnLogInPage() {
        WebElement LogIn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='user-button__image flex middle-xs center-xs']"))
        );
        LogIn.click();
    }
}

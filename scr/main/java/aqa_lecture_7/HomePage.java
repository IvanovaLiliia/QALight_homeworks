package aqa_lecture_7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;

    private final By searchInput =
            By.xpath("//input[contains(@placeholder,'Знайти товар')]");

    private final By productCards =
            By.xpath("//div[contains(@class,'list-item')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Search product: {productName}")
    public SearchResultPage searchProduct(String productName) {

        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productCards)
        );

        return new SearchResultPage(driver);
    }
}
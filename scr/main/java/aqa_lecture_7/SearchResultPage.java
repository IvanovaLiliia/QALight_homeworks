package aqa_lecture_7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    private final WebDriver driver;

    private final By productCards =
            By.xpath("//div[contains(@class,'list-item')]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get products count")
    public int getProductsCount() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productCards)
        );

        return driver.findElements(productCards).size();
    }
}
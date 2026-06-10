package aqa_lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchResultPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnProduct() {
        WebElement searchProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Samsung Galaxy S25 Ultra')]"))
        );
        searchProduct.click();
    }
}



package aqa_lecture_7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeedbackPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By searchSection =
            By.xpath("//span[normalize-space()='Пошук відгука в розділі']");

    private final By homeAppliancesSection =
            By.xpath("//p[contains(@class,'custom-select__body-item') and @title='Побутова техніка']");

    private final By searchCatalogue =
            By.xpath("//span[normalize-space()='Пошук відгуку в каталозі']");

    private final By searchKitchen =
            By.xpath("//p[normalize-space()='Аксесуари для кухонної техніки']");

    private final By ShowButton =
            By.xpath("//button[normalize-space()='Показати']");

    private final By ItemFeedback =
            By.xpath("//div[contains(@class,'review__criteria-rating-name')]");

    @Step("Select section")
    public FeedbackPage openSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(searchSection)).click();
        return new FeedbackPage(driver);
    }

    @Step("Appliances section")
    public FeedbackPage selecthomeItems() {
        wait.until(ExpectedConditions.elementToBeClickable(homeAppliancesSection)).click();
        return new FeedbackPage(driver);


}
    @Step("Catalogue section")
    public FeedbackPage openCatalogue() {
        wait.until(ExpectedConditions.elementToBeClickable(searchCatalogue)).click();
        return new FeedbackPage(driver);
}

    @Step("Kitchen section")
    public FeedbackPage openKitchenSection() {
        wait.until(ExpectedConditions.elementToBeClickable(searchKitchen)).click();
        return new FeedbackPage(driver);
}
    @Step("ShowButton")
    public FeedbackPage clickShowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ShowButton)).click();
        return new FeedbackPage(driver);
}
    @Step("First product evaluation")
    public String getFirstvaluatedProduct() {
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ItemFeedback)
        );
        return price.getText();
}
}

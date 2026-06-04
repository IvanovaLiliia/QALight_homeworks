package aqa_lecture_7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By categoryPhone =
            By.xpath("//div[contains(text(),'Смартфони та мобільні телефони')]");

    private final By sortButton =
            By.xpath("//div[contains(text(),'популярністю')]");

    private final By sortCheapToExpensive =
            By.xpath("//div[contains(text(),'зростанням ціни')]");

    private final By firstProductPrice =
            By.xpath("(//a[contains(@class,'item-title') and contains(.,'2E S180 2024 DualSim Black')])[2]");





    @Step("ClickOnPhoneCategory")
    public CategoryPage clickOnPhoneCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryPhone)).click();
        return this;
    }

    @Step("Open sort menu")
    public CategoryPage openSortMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(sortButton)).click();
        return this;
    }

    @Step("Sort by price: ascending")
    public CategoryPage sortByPriceAsc() {
        wait.until(ExpectedConditions.elementToBeClickable(sortCheapToExpensive)).click();
        return this;
    }


    @Step("Get first product price")
    public String getFirstProductPrice() {
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstProductPrice)
        );
        return price.getText();
    }
}

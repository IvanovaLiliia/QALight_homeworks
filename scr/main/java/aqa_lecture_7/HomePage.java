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
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------- SEARCH ----------------

    private final By searchInput =
            By.xpath("//input[contains(@placeholder,'Знайти товар')]");

    private final By productCards =
            By.xpath("//div[contains(@class,'list-item')]");

    @Step("Search product: {productName}")
    public SearchResultPage searchProduct(String productName) {

        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));

        return new SearchResultPage(driver);
    }

    // ---------------- CATALOG ----------------

    private final By catalogButton =
            By.xpath("//div[contains(@class,'button-menu-main') and contains(.,'Каталог')]");

    private final By smartphonesCategory =
            By.xpath("//a[contains(@href,'smartfony') or contains(text(),'Смартф')]");

    @Step("Open catalog")
    public HomePage openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogButton)).click();
        return this;
    }

    @Step("Open smartphones category")
    public CategoryPage openSmartphonesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(smartphonesCategory)).click();
        return new CategoryPage(driver);
    }
}
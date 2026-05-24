package aqa_lecture_5;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;

public class DataProviderTest extends BaseTest {
    @Test(dataProvider = "searchProducts",
            dataProviderClass = SearchData.class)
    public void searchProductTest(String productName, String ExpectedTitle) {

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(10)
        );

        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='search']")
                )
        );
        searchInput.sendKeys(productName);

        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit']")
                )
        );
        searchButton.click();

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(@class,'b-crumbs__link--active')]")
                )
        );
        String TitleText = title.getText();

        Assertions.assertEquals(
                TitleText,
                ExpectedTitle,
                String.format("Title page is incorrect. It should equal to <%s>", ExpectedTitle)
        );




}
}

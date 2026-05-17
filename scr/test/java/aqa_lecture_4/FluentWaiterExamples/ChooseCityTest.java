package aqa_lecture_4.FluentWaiterExamples;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class ChooseCityTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementNotInteractableException.class);

        try {
            String City = "Киев";
            int ExpectedNumberOfElements = 21;
            driver.get("https://auto.ria.com/");
            driver.manage().window().maximize();



            WebElement CloseBanner = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Понимаю и разрешаю']]")));
            CloseBanner.click();

            WebElement searchButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//input[@type='search' and contains(@class,'select-head')]")
                    )
            );
            searchButton.click();

            WebElement inputField = waiter.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[@type='search' and contains(@class,'select-head')]")
                    )
            );
            inputField.sendKeys(City);

            WebElement CityButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//label[.//span[normalize-space(.)='Киев']]")
                    )
            );
            CityButton.click();

            WebElement ApplyButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[.//span[normalize-space(.)='Применить']]")
                    )
            );
            ApplyButton.click();

            WebElement SearchButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[.//span[normalize-space(.)='Искать']]")
                    )
            );
            SearchButton.click();

            By ProductsXPath = By.xpath("//div[contains(@class,'structure-row') and .//span[contains(@class,'body') and normalize-space(.)='Киев']]");
            waiter.until(ExpectedConditions.numberOfElementsToBe(ProductsXPath,21));
            List<WebElement> CityName = driver.findElements(ProductsXPath);

            for (WebElement element : CityName) {
                Assertions.assertTrue(element.getText().contains(City));
            }

        }
        finally {
            driver.quit();
        }
    }
}

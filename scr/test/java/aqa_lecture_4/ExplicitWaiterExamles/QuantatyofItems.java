package aqa_lecture_4.ExplicitWaiterExamles;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QuantatyofItems {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            int ExpectedCountOfCars = 20;

            driver.get("https://auto.ria.com/");
            driver.manage().window().maximize();

            WebElement CloseBanner = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Понимаю и разрешаю']]")));
            CloseBanner.click();

            WebElement NewCars = waiter.until(ExpectedConditions.elementToBeClickable (
             By.xpath("//span[text()='Новые']")));
            NewCars.click();

            WebElement ModelAuto = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.//span[contains(text(),'Марка, Модель')]]")));
            ModelAuto.click();

            WebElement HondaOption  = waiter.until (ExpectedConditions.elementToBeClickable(By.xpath("//label[.//span[text()='Honda']]")));
            HondaOption.click();

            WebElement ApplyButton = waiter.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Применить']]")));
            ApplyButton.click();

            WebElement SearchButton = waiter.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Искать']]")));
            SearchButton.click();

            By productsXpath = By.xpath("//h3[@data-test='searchPage-itemContainerTitle']");

            waiter.until(ExpectedConditions.numberOfElementsToBe(productsXpath, ExpectedCountOfCars));

            List<WebElement> products = driver.findElements(productsXpath);

            Assertions.assertEquals(ExpectedCountOfCars, products.size());

        }
        finally {
            driver.quit();
        }
    }
}

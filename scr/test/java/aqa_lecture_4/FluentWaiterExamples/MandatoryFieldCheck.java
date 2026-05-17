package aqa_lecture_4.FluentWaiterExamples;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static java.lang.String.format;

public class MandatoryFieldCheck {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementNotInteractableException.class);

        try {
            String MandatoryFieldReminder = "Поле \"Тип транспорта\" обязательно для заполнения";

            driver.get("https://auto.ria.com/");
            driver.manage().window().maximize();

            WebElement CloseBanner = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Понимаю и разрешаю']]")));
            CloseBanner.click();

            WebElement SellButton = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[text()='Продать авто']]")));
            SellButton.click();

            WebElement SellCar = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='addAutoButton']")));
            SellCar.click();

            WebElement ModelAuto = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='model.idAutocompleteInput-0' and @data-text='Выберите']")));
            ModelAuto.click();

            WebElement Error = waiter.until(
                    ExpectedConditions.visibilityOfElementLocated
                            (By.xpath("//span[text()='Поле \"Тип транспорта\" обязательно для заполнения']")));
            String ErrorText = Error.getText();

            String ErrorMessage = format("Error massage doesnt appeared. It doesn`t contains <%S> reminder of a mandatory field ", MandatoryFieldReminder);
            Assertions.assertTrue(ErrorText.contains(MandatoryFieldReminder), ErrorMessage);



        }
        finally {
            driver.quit();
        }

    }
}

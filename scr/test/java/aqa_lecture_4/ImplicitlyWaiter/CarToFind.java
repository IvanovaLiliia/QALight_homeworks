package aqa_lecture_4.ImplicitlyWaiter;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.String.format;

public class CarToFind {

    public static void main(String[] args) {

        String searchCar = "BMW";
        WebDriver driver = new ChromeDriver();

    try {
        driver.get("https://auto.ria.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement CloseBanner = driver.findElement(By.xpath("//button[.//span[text()='Понимаю и разрешаю']]"));
        CloseBanner.click();

        WebElement ModelAuto = driver.findElement(By.xpath("//label[.//span[contains(text(),'Марка, Модель')]]"));
        ModelAuto.click();

        WebElement BMWButton = driver.findElement(By.xpath("//label[.//span[text()='BMW']]//label[contains(@class,'label-radio')]"));
        BMWButton.click();

        WebElement ApplyButton = driver.findElement(By.xpath("//button[.//span[text()='Применить']]"));
        ApplyButton.click();

        WebElement SearchButton = driver.findElement(By.xpath("//button[.//span[text()='Искать']]"));
        SearchButton.click();

        WebElement title = driver.findElement(By.xpath("//span[contains(@class,'footnote') and text()='BMW']"));
        String TitleText = title.getText();

        String ErrorMessage = format("Car is not fount.", searchCar);
        Assertions.assertTrue(TitleText.contains(searchCar), ErrorMessage);

    }
    finally {
        driver.quit();
    }
    }
}

package aqa_lecture_2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class ChangeCityTest {
    public static void main(String[] args) {
        String city = "Одеса";
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            WebElement cityButton = driver.findElement(By.xpath("//div[@title=\"Київ\"]"));
            cityButton.click();

            sleep(3000);

            WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Почніть вводити назву']"));
            inputField.sendKeys(city);

            sleep (3000);

            WebElement OdesaCity = driver.findElement(By.xpath("//div[contains(@class, 'flex') and contains(text(), 'Одеса')]"));
            OdesaCity.click();

            sleep (5000);

            WebElement title = driver.findElement(By.xpath("//div[@title=\"Одеса\"]"));
            String TitleText = title.getText();

            String ErrorMessage = format("City is incorrect. It doesn`t contains <%S> search word", city);
            Assertions.assertTrue(TitleText.contains(city), ErrorMessage);


        } finally {
            driver.quit();
        }
    }
}

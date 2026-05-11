package aqa_lecture_3;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.List;


import static java.lang.Thread.sleep;

public class BuyersGuide {

    public static void main(String[] args) throws InterruptedException {

        String searchWord = "Телевізори";
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            WebElement GuideButton = driver.findElement(By.xpath("//a[contains(text(),'Гід покупця')]"));
            GuideButton.click();
            sleep (5000);

            WebElement inputField = driver.findElement(By.xpath("//input[contains(@placeholder,'Що вибираєте?')]"));
            inputField.click();
            sleep (3000);

            WebElement TVOption = driver.findElement(By.xpath("//a[@href='/guides/av/televizory/']"));
            TVOption.click();
            sleep (3000);

            WebElement AllOptions = driver.findElement(By.xpath("//button[.//span[text()='Всі рубрики']]"));
            AllOptions.click();
            sleep (3000);

            WebElement Top10Button = driver.findElement(By.xpath("//a[contains(text(),'ТОП-10')]"));
            Top10Button.click();
            sleep (3000);

            List<WebElement> Top10Products = driver.findElements(By.xpath("//small[contains(text(),'ТОП-10')]"));
            for (WebElement Top10Product : Top10Products) {
                String productRank = Top10Product.getText();
                Assertions.assertTrue(productRank.contains("ТОП-10"));
            }

        }
        finally {
            driver.quit();
        }
    }
}

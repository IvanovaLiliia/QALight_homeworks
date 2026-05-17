package aqa_lecture_4.ExplicitWaiterExamles;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;

public class AddtoFavorite {
    public static void main(String[] args) {

        String searchCar = "Cabrio";
        String FavoriteCar = "Mercedes-Benz C-Class 2016";
        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://auto.ria.com/");
            driver.manage().window().maximize();


            WebElement searchButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@aria-label='Поиск']")
                    )
            );
            searchButton.click();

            WebElement inputField = waiter.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[contains(@class,'ai-search-input')]")
                    )
            );
            inputField.sendKeys(searchCar, Keys.ENTER);

            WebElement likeButton = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@aria-label='Поділитися']")
                    )
            );
            likeButton.click();

            WebElement Wishlist = waiter.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[@aria-label='Додати в обране']")
                    )
            );
            Wishlist.click();

            WebElement title = waiter.until(
                    ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//a[contains(@href,'mercedes-benz_c-class') and contains(text(),'Mercedes-Benz C-Class')]")));
            String TitleText = title.getText();

            String ErrorMessage = format("Car is not fount. It doesn`t contains <%S> favorite Car", FavoriteCar);
            Assertions.assertTrue(TitleText.contains(FavoriteCar), ErrorMessage);



        } finally {
            driver.quit();
        }
    }
}
package aqa_lecture_3;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class AddToWishList {

    public static void main(String[] args) throws InterruptedException {

        String searchWord = "LEGO";
        String ItemtoBuy = "LEGO Technic McLaren P1 (42172)";
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            WebElement inputField = driver.findElement(By.xpath("//input"));
            inputField.sendKeys(searchWord);
            sleep (3000);

            WebElement searchButton = driver.findElement(By.xpath("//button[@title =\"Поиск\"]"));
            searchButton.click();
            sleep (5000);

            WebElement WishProduct  = driver.findElement(By.xpath("//img[@alt='LEGO Technic McLaren P1 (42172)']"));
            WishProduct.click();
            sleep (3000);

            WebElement LikeButton = driver.findElement(By.xpath("//div[@title='Додати товар в особисті списки']"));
            LikeButton.click();
            sleep (3000);

            WebElement RedirectToList = driver.findElement(By.xpath("//a[@href='/ua/profile/guest/lists/bookmarks/']"));
            RedirectToList.click();
            sleep (3000);

            WebElement Wishlist  = driver.findElement(By.xpath("//div[contains(@class, 'list-item') and .//a[@href='/ua/deti-detskie-konstruktory/lego-maklaren-p1-42172/']]"));
            String TitleText = Wishlist.getText();

            String ErrorMessage = format("Product is not found. It doesn`t contains <%S> search word", ItemtoBuy);
            Assertions.assertTrue(TitleText.contains(ItemtoBuy), ErrorMessage);

        }
        finally {
            driver.quit();
        }
    }
}

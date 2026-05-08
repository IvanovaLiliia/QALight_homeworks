package aqa_lecture_2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.lang.Thread.sleep;

public class WishPopUpVisibilityVerification {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            WebElement wishListButton = driver.findElement(By.xpath("//div[@class =\"popover my-lists\"]//div[@class=\"button__icon flex\"]"));
            wishListButton.click();

            sleep(3000);

            WebElement wishListPopUp = driver.findElement(By.xpath("//div[contains(@class, \"my-lists__section\")]"));

            boolean isWishListPopUpDisplayed = wishListPopUp.isDisplayed();

            Assertions.assertTrue(wishListPopUp.isDisplayed(), "WishList PopUp isn`t displayed");

        } finally {
            driver.quit();
        }
    }
}

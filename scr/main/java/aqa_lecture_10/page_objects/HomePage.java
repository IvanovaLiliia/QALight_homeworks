package aqa_lecture_10.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogInButton() {
        driver.findElement(By.xpath("//a[contains(@class,'field-button-text') and @href='/metro/services/idamstream/login']")).click();
    }
}

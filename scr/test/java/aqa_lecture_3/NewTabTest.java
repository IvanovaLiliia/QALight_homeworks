package aqa_lecture_3;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class NewTabTest {

    public static void main(String[] args) throws InterruptedException {

        String SearchWord = "4 роки тому";
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            WebElement YouTubeButton = driver.findElement(By.xpath("//a[@title='Youtube']"));
            YouTubeButton.click();
            sleep (5000);

            String LastTabID = driver.getWindowHandles().stream().toList().get(1);
            driver.switchTo().window(LastTabID);

            WebElement Video = driver.findElement(By.xpath("//div[text()='Відео']"));
            Video.click();
            sleep (3000);

            WebElement OldVideo = driver.findElement(By.xpath("//button[contains(.,'Найстаріші')]"));
            OldVideo.click();
            sleep (3000);

            WebElement TimeDescription  = driver.findElement(By.xpath("//span[contains(text(),'4 роки тому')]"));
            String TitleText = TimeDescription.getText();


            String ErrorMessage = format("Video is not found. It doesn`t contains <%S> search word", SearchWord);
            Assertions.assertTrue(TitleText.contains(SearchWord), ErrorMessage);

        }
        finally {
            driver.quit();
        }
    }
}

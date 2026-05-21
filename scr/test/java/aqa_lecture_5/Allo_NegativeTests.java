package aqa_lecture_5;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.String.format;

public class Allo_NegativeTests extends BaseTest {

    @Test
    public void authNegativeTest() {
        String phoneNumber = "+380635653561";
        String ErrorMessage = "Це поле є обов'язковим для заповнення.";

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(20)
        );

        WebElement authButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Профіль']")
                )
        );
        authButton.click();

        WebElement LogIn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Логін та пароль')]")
                )
        );
        LogIn.click();

        WebElement inputField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='phoneEmail']")
                )
        );
        inputField.sendKeys(phoneNumber);

        WebElement EnterButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Увійти')]")
                )
        );
        EnterButton.click();

        WebElement MandatoryMassage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),\"Це поле є обов'язковим для заповнення.\")]")
                )
        );

        String MessageText = MandatoryMassage.getText();

        Assert.assertEquals(
                MessageText,
                ErrorMessage,
                "The error text doesnt match the expected one."
        );
}

    @Test
    public void addItemNegativeTest() {
        String PersonName = "Liliia";
        String PersonSurname = "Ivanova";
        String ExpectedMessage = "Це поле є обов'язковим для заповнення.";

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(10)
        );

        WebElement authButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@title='Купити']")
                )
        );
        authButton.click();

        WebElement CheckoutButton  = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-proceed-to-checkout]")
                )
        );
        CheckoutButton.click();

        WebElement InputName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='firstname']")
                )
        );
        InputName.sendKeys(PersonName);

        WebElement InputSurname = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='lastname']")
                )
        );
        InputSurname.sendKeys(PersonSurname);

        WebElement PaymentMethod  = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Вибрати доставку і оплату')]")
                )
        );
        PaymentMethod.click();

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),\"Це поле є обов'язковим для заповнення.\")]")
                )
        );
        String TitleText = title.getText();

        Assertions.assertEquals(
                TitleText,
                ExpectedMessage,
                String.format("The error text doesnt match the expected one.", ExpectedMessage)
        );



    }
}

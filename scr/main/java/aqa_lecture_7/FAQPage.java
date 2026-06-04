package aqa_lecture_7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By FAQSection =
            By.xpath("//div[normalize-space()='Відгуки та відповіді на запитання']");

    private final By firstQuestion =
            By.xpath("//div[normalize-space()='Як залишити відгук про магазин?']");

    private final By getText =
            By.xpath("//div[normalize-space()='Ця можливість доступна лише для зареєстрованих користувачів.']");

    @Step("Answers section")
    public FAQPage openAnswersSection() {
        wait.until(ExpectedConditions.elementToBeClickable(FAQSection)).click();
        return new FAQPage(driver);
    }

    @Step("FirstQuestion")
    public FAQPage openFirstQuestion() {
        wait.until(ExpectedConditions.elementToBeClickable(firstQuestion)).click();
        return new FAQPage(driver);
    }

    @Step("FirstAnswer")
    public String getFirstAnswer() {
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getText)
        );
        return price.getText();
    }
}

package aqa_lecture_5;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveTests extends BaseTest{

    @Test
    public void AddtoCompareList() {

        String InputWord = "Велосипеди";
        String ExpectedTitle = "Додано товарів: 2";
        String ExpectedTitleTwo = "Всі характеристики";
        String ExpectedTitleThree = "Відмінності";

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(20)
        );


        WebElement inputField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@id='search-form__input']")
                )
        );
        inputField.sendKeys(InputWord);

        WebElement SearchButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'search-form__submit-button-text') and normalize-space()='Знайти']")
                )
        );
        SearchButton.click();

        WebElement SortButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='a-select__toggle']")
                )
        );
        SortButton.click();

        WebElement SortPrice = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[@data-value='price:desc']")
                )
        );
        SortPrice.click();

        WebElement FirstOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//img[contains(@src,'6947802323089184')]/ancestor::div[.//button[contains(@class,'compare')]][1]//button[contains(@class,'compare')]")
                )
        );
        FirstOption.click();

        WebElement SecondOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//img[contains(@src,'6826356910324070.webp')]\n" +
                                "/ancestor::*[.//button[contains(@class,'compare')]][1]\n" +
                                "//button[contains(@class,'compare')]")
                )
        );
        SecondOption.click();

        WebElement CompareButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@aria-label='Порівняти']")
                )
        );
        CompareButton.click();

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'products-layout__item--count') and contains(.,'Додано товарів')]")
                )
        );
        String AddedItems = title.getText();

        String[] lines = title.getText().split("\n");

        Assertions.assertEquals(ExpectedTitle, lines[0].trim());
        Assertions.assertEquals(ExpectedTitleTwo, lines[1].trim());
        Assertions.assertEquals(ExpectedTitleThree, lines[2].trim());
};

    @Test
    public void AddressVerify() {

        String StreetName = "Корольова";
        String ExpectedAddress = "вул. Корольова Академіка, 76/1, Навпроти \"Південного\" ринку, маг. Алло";

        WebDriverWait wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(40)
        );

        WebElement ShopButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'mh-button__title') and normalize-space()='Магазини']")
                )
        );
        ShopButton.click();

        WebElement CityButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'a-button__text') and contains(.,'Одеса')]")
                )
        );
        CityButton.click();

        WebElement inputField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='street']")
                )
        );
        inputField.sendKeys(StreetName);

        WebElement ShopAddress = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'store-item__address')]")
                )
        );
        String MessageText = ShopAddress.getText();

        Assert.assertEquals(
                MessageText,
                ExpectedAddress,
                "You have entered wrong address"
        );



}
};

package aqa_lecture_6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiveFeedbackTest extends BaseTest {
    @Test
    public void testGiveFeedback() {

        String name = "Liliia";
        String ShopName = "MyShop.com";
        String ErrorMessage = "Поле «Тема» не може бути порожнім.";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnFeedbackPage();

        FeedbackPage feedbackPage = new FeedbackPage(getDriver());
        feedbackPage.clickOnShopOption();
        feedbackPage.enterName(name);
        feedbackPage.enterShopName (ShopName);
        feedbackPage.enterShopName (ShopName);
        feedbackPage.clickOnSendFeedback();
        String actualResultValue = feedbackPage.getErrorMessage();

        System.out.println("Title on product page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(ErrorMessage),
                "Product title does not contain the search word!");
    }

    }


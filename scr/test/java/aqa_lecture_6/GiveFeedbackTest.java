package aqa_lecture_6;

import aqa_lecture_5.BaseTest;
import org.testng.annotations.Test;

public class GiveFeedbackTest extends BaseTest {
    @Test
    public void testGiveFeedback() {

        String name = "Liliia";
        String ShopName = "MyShop.com";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnFeedbackPage();

        FeedbackPage feedbackPage = new FeedbackPage(getDriver());
        feedbackPage.clickOnShopOption();
        feedbackPage.enterName(name);

    }
}

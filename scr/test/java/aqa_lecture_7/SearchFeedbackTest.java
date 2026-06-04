package aqa_lecture_7;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Hotline")
@Feature("GetFeedback")
public class SearchFeedbackTest extends BaseTest{

    String searchWord = "Оцінка товара";
    @Test
    @Story("Feedback_availability")
    @Severity(SeverityLevel.NORMAL)
    @Description("CheckFeedbackPage")
    public void sortByPriceTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.openFeedbackPage();

        FeedbackPage feedbackPage = new FeedbackPage(getDriver());
        feedbackPage.openSelector();
        feedbackPage.selecthomeItems();
        feedbackPage.openCatalogue();
        feedbackPage.openKitchenSection();
        feedbackPage.clickShowButton();

        String actualResultValue = feedbackPage.getFirstvaluatedProduct();

        System.out.println("Title on product page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(searchWord),
                "Product title does not contain the search word!");

}
}

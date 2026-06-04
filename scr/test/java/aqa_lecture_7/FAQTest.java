package aqa_lecture_7;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAQTest extends BaseTest{

    String Answer = "Ця можливість доступна лише для зареєстрованих користувачів.";
    @Test
    @Story("FAQTestCheck")
    @Severity(SeverityLevel.MINOR)
    @Description("CheckFeedbackPage")
    public void checkfaqTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.openFAQPage();

        FAQPage faqPage = new FAQPage(getDriver());
        faqPage.openAnswersSection();
        faqPage.openFirstQuestion();

        String actualResultValue = faqPage.getFirstAnswer();

        System.out.println("Title on product page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(Answer),
                "Product title does not contain the search word!");


    }

}

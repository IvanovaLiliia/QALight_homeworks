package aqa_lecture_6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void LogInExampleTest() {

        String email = "admin@test.com";
        String RemindText = "Зміна паролю";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInPage();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.EnterEmail(email);
        logInPage.clickOnForgetPassword();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        String actualResultValue = changePasswordPage.getTitle();

        System.out.println("Title on the  page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(RemindText),
                "Page title does not contain the search word!");

    }

}

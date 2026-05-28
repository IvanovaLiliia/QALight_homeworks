package aqa_lecture_6;

import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void LogInNegative() {

        String email = "admin@test.com";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInPage();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.EnterEmail(email);
        logInPage.clickOnForgetPassword();

    }

}

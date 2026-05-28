package aqa_lecture_6;

import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class LogInNegativeTest extends BaseTest {

    @Test
    public void LogInNegative() {

        String password = "admin12345";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInPage();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.enterPassword(password);
    }

}

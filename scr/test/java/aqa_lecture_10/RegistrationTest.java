package aqa_lecture_10;

import aqa_lecture_10.page_objects.HomePage;
import aqa_lecture_10.page_objects.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;


import java.util.Map;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyUserCanBeRegistered() {
        Pair<String, String> userCredentials = DBDataProvider.getUserInfo();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInButton();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.login(userCredentials.first(), userCredentials.second());

        Assert.assertEquals(
                logInPage.getMessage(),
                "Недійсні дані! Друга невдала спроба входу"
        );

    }

@Test
    public void verifyInvalidPasswordShowsError() {
        Pair<String, String> userCredentials = DBDataProvider.getUserInfo();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInButton();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.login(userCredentials.first(), "WrongPassword123");

        Assert.assertEquals(
                logInPage.getErrorMessage(),
                "Недійсні дані! Друга невдала спроба входу"
        );

    }
}

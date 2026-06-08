package aqa_lecture_10;

import aqa_lecture_10.page_objects.HomePage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyUserCanBeRegistered() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInButton();



    }
}

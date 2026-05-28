package aqa_lecture_6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void verifyUserNavigatesToCorrectPage() {
        String searchWord = "Samsung";

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSearchWord(searchWord);

        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        searchResultPage.clickOnProduct();

        ProductPage productPage = new ProductPage(getDriver());
        String actualResultValue = productPage.getTitle();

        System.out.println("Title on product page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(searchWord),
                "Product title does not contain the search word!");
    }
}

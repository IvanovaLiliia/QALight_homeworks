package aqa_lecture_7;

import aqa_lecture_7.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import aqa_lecture_7.HomePage;
import aqa_lecture_7.SearchResultPage;

@Epic("Hotline")
@Feature("Search")
public class SearchProductTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search product on Hotline")
    @Story("Search product")
    @Owner("QA Liliia")
    public void searchProductTest() {

        HomePage homePage = new HomePage(getDriver());

        SearchResultPage resultPage =
                homePage.searchProduct("iPhone 15");

        Assert.assertTrue(
                resultPage.getProductsCount() > 0,
                "Products were not found"
        );
    }
}
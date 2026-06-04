package aqa_lecture_7;

import aqa_lecture_7.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import aqa_lecture_7.HomePage;
import aqa_lecture_7.CategoryPage;

@Epic("Hotline UI")
@Feature("Sorting products")
public class SortByPriceTest extends BaseTest {

    String searchWord = "2E S180 2024 DualSim Black";
    @Test
    @Story("Sort by price ascending")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка сортировки товаров по цене (от дешевых к дорогим)")
    public void sortByPriceTest() {

        HomePage homePage = new HomePage(getDriver());

        CategoryPage categoryPage = homePage
                .openCatalog()
                .openSmartphonesCategory();

        categoryPage.clickOnPhoneCategory();
        categoryPage.openSortMenu();
        categoryPage.sortByPriceAsc();

        String actualResultValue = categoryPage.getFirstProductPrice();

        System.out.println("Title on product page: " + actualResultValue);
        Assert.assertTrue(actualResultValue.contains(searchWord),
                "Product title does not contain the search word!");


    }
}
package aqa_lecture_5;

import org.testng.annotations.DataProvider;

public class SearchData {

    @DataProvider(name = "searchProducts")
    public Object[][] getData() {

        return new Object[][]{

                {"Ноутбук", "Результати пошуку для 'ноутбук'. Знайдено товарів: 117666"},
                {"Телефон", "Результати пошуку для 'телефон'. Знайдено товарів: 47368" },
                {"Годинник", "Результати пошуку для 'годинник'. Знайдено товарів: 95032"}

        };
    }
}


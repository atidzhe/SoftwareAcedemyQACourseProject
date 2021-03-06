package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import seleniumTesting.YahooFinancePOM.*;
import seleniumTesting.base.TestUtils;
import seleniumTesting.utils.CsvReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckStatisticsForCompanyStockTest extends TestUtils {

    @DataProvider(name = "companyStatistics-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companyStatistics-data.csv");
    }

    @Test(dataProvider = "companyStatistics-data")
    public void checkStatistics(String company, String companyDevs, String priceBook) throws InterruptedException {
        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceStatisticsPage statisticsPage = new YahooFinanceStatisticsPage(driver);

        homePage.cookiesClick();
        homePage.searchCompany(company);
        homePage.searchBtn();

        statisticsPage.goToStatistics();
        String companyDevsValue = statisticsPage.getDividendsInfo().getText();
        String priceBookValue = statisticsPage.getPriceBook().getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceBookValue, priceBook);
        softAssert.assertEquals(companyDevsValue, companyDevs);


    }

}

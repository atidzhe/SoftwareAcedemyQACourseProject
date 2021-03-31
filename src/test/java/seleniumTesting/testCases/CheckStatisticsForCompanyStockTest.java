package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTesting.SignUpForYahooFinancePOM.*;
import seleniumTesting.base.TestUtils;
import seleniumTesting.utils.CsvReader;

import java.io.IOException;

public class CheckStatisticsForCompanyStockTest extends TestUtils {

    @DataProvider(name = "companyStatistics-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companyStatistics-data.csv");
    }
    @Test(dataProvider = "companyStatistics-data")
    public void checkStatistics(String company)throws InterruptedException{
        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceAmazonStatisticsPage amazonPage = new YahooFinanceAmazonStatisticsPage(driver);
       // YahooFinanceAppleStatisticsPage applePage = new YahooFinanceAppleStatisticsPage(driver);

        homePage.cookiesClick();
        homePage.searchCompany(company);
        homePage.searchBtn();

        String valueAmazon = amazonPage.



    }

}

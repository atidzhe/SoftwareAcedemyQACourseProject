package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
    public void checkStatistics(String company, String dividents, String priceBookValue) throws InterruptedException {
        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceStatisticsPage amazonPage = new YahooFinanceStatisticsPage(driver);


        homePage.cookiesClick();
        homePage.searchCompany(company);
        homePage.searchBtn();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // иключваме първо
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Statistics')]")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// включваме обратно

        amazonPage.verifyDividents(dividents);
        amazonPage.goToStatistics();
        amazonPage.verifyPriceBook(priceBookValue);

       /* String priceBookValue = driver.findElement(By.xpath("//td[contains(text(),'17.02')]']")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceBookValue, );
        softAssert.assertAll();*/

    }

}

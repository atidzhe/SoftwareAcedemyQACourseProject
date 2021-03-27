package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTesting.SignUpForYahooFinancePOM.YahooFinanceHomePage;
import seleniumTesting.SignUpForYahooFinancePOM.YahooFinanceLoginPage;
import seleniumTesting.SignUpForYahooFinancePOM.YahooFinanceSignUpPage;
import seleniumTesting.base.TestUtils;
import seleniumTesting.utils.CsvReader;

import java.io.IOException;

public class YahooFinanceSignUpNegativeDataTest extends TestUtils {
    @DataProvider(name = "signUp-negativeData")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signUp-negativeData.csv");
    }


    @Test(dataProvider = "signUp-negativeData")
    public void NegativeDataSignUp(String firstName, String lastName, String email, String password, String phoneNum, String day, String year) throws InterruptedException {

        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceLoginPage loginPage = new YahooFinanceLoginPage(driver);
        YahooFinanceSignUpPage signUpPage = new YahooFinanceSignUpPage(driver);

        homePage.login();
        loginPage.signUp();


}}
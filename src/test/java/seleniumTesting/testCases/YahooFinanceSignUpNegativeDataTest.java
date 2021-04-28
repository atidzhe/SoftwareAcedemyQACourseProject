package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import seleniumTesting.YahooFinancePOM.YahooFinanceHomePage;
import seleniumTesting.YahooFinancePOM.YahooFinanceLoginPage;
import seleniumTesting.YahooFinancePOM.YahooFinanceSignUpPage;
import seleniumTesting.base.TestUtils;
import seleniumTesting.utils.CsvReader;
import java.io.IOException;


public class YahooFinanceSignUpNegativeDataTest extends TestUtils {

    @DataProvider(name = "signUp-negativeData")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signUp-negativeData.csv");
    }


    @Test(dataProvider = "signUp-negativeData")
    public void NegativeDataSignUp(String firstName, String lastName, String email, String password, String phoneNum, String day, String year, String gender) throws InterruptedException {

        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceLoginPage loginPage = new YahooFinanceLoginPage(driver);
        YahooFinanceSignUpPage signUpPage = new YahooFinanceSignUpPage(driver);

        homePage.cookiesClick();
        homePage.signInClick();
        loginPage.signUp();
        signUpPage.enterName(firstName, lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.enterPhoneNumber(phoneNum);
        signUpPage.enterBirthDate(day, year);
        signUpPage.enterGender(gender);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.emailError(), signUpPage.emailErrMsg());
        softAssert.assertEquals(signUpPage.passwordError(), signUpPage.passErrMsg());
        softAssert.assertEquals(signUpPage.phoneError(), signUpPage.phoneErrMsg());
        softAssert.assertEquals(signUpPage.birthDayError(), signUpPage.birthDateErrMsg());

        softAssert.assertAll();


    }
}
package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
    public void NegativeDataSignUp(String firstName, String lastName, String email, String password, String phoneNum,String day, String year) throws InterruptedException {

        YahooFinanceHomePage homePage = new YahooFinanceHomePage(driver);
        YahooFinanceLoginPage loginPage = new YahooFinanceLoginPage(driver);
        YahooFinanceSignUpPage signUpPage = new YahooFinanceSignUpPage(driver);

        homePage.cookiesClick();
        homePage.signInClick();
        loginPage.signUp();
        signUpPage.enterData(firstName, lastName, email, password, phoneNum, day, year);
        signUpPage.submitRegistration();

        String emailError = driver.findElement(By.id("reg-error-yid")).getText();
        String passwordError = driver.findElement(By.id("reg-error-password")).getText();
        String phoneError = driver.findElement(By.id("reg-error-phone")).getText();
        String birthDateError = driver.findElement(By.id("reg-error-birthDate")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emailError, "This email address is not available for sign up, try something else");
        softAssert.assertEquals(passwordError, "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(phoneError, "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(birthDateError, "That doesn’t look right, please re-enter your birthday.");

        softAssert.assertAll();




}}
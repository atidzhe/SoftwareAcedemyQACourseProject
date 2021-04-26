package seleniumTesting.testCases;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import seleniumTesting.YahooFinancePOM.YahooFinanceHomePage;
import seleniumTesting.YahooFinancePOM.YahooFinanceLoginPage;
import seleniumTesting.YahooFinancePOM.YahooFinanceSignUpPage;
import seleniumTesting.base.TestUtils;
import seleniumTesting.utils.CsvReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
      // signUpPage.submitRegistration();



        String emailError = driver.findElement(By.id("reg-error-yid")).getText();
        String passwordError = driver.findElement(By.id("reg-error-password")).getText();
        String phoneError = driver.findElement(By.id("reg-error-phone")).getText();
       // String birthDateError = driver.findElement(By.id("reg-error-birthDate")).getText();
       driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement birthDayErr = driver.findElement(By.id("reg-error-birthDate"));
        wait.until(ExpectedConditions.visibilityOf(birthDayErr));
        String birthDateError = birthDayErr.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emailError, "This email address is not available for sign up, try something else" );
        softAssert.assertEquals(passwordError, "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(phoneError, "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(birthDateError, "That doesn’t look right, please re-enter your birthday.");

       softAssert.assertAll();


    }
}
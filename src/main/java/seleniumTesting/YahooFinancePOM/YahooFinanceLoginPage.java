package seleniumTesting.YahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceLoginPage extends BasePage {

    @FindBy(id = "createacc")
    private WebElement signUpBtn;


    public YahooFinanceLoginPage(WebDriver driver) {
        super(driver);
    }


    public YahooFinanceSignUpPage signUp() {
        signUpBtn.click();
        return new YahooFinanceSignUpPage(driver);
    }
}
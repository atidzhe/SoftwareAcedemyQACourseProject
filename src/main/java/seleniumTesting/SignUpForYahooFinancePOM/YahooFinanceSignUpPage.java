package seleniumTesting.SignUpForYahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceSignUpPage extends BasePage{


    @FindBy(id = "createacc")
    private WebElement signUpBtn;


    public YahooFinanceSignUpPage(WebDriver driver){
        super(driver);
    }


    public YahooFinanceSignUpPage login(){
        signUpBtn.click();
        return new YahooFinanceSignUpPage(driver);
    }
}
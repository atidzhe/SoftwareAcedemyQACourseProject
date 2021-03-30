package seleniumTesting.SignUpForYahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceHomePage extends BasePage{



    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;
    @FindBy(xpath = "//div[@class='con-wizard']//ancestor::div[@class='wizard-body']//ancestor::div[@class='actions couple']//button")
    private WebElement acceptBtn;


    public YahooFinanceHomePage(WebDriver driver){
            super(driver);
        }


        public YahooFinanceLoginPage cookiesClick(){
            acceptBtn.click();
            return new YahooFinanceLoginPage(driver); }

        public YahooFinanceLoginPage signInClick(){
            signInBtn.click();
            return new YahooFinanceLoginPage(driver);
        }
}
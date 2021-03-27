package seleniumTesting.SignUpForYahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceHomePage extends BasePage{



    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;
    @FindBy(xpath = "//body/div[@id='consent-page']/div[1]/div[1]/div[1]/form[1]")
    private WebElement acceptBtn;


    public YahooFinanceHomePage(WebDriver driver){
            super(driver);
        }


        public YahooFinanceLoginPage login(){
            acceptBtn.click();
            signInBtn.click();
            return new YahooFinanceLoginPage(driver);
    }
}
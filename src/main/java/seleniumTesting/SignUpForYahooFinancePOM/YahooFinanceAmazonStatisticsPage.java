package seleniumTesting.SignUpForYahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceAmazonStatisticsPage extends BasePage{

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsInfo;

    public YahooFinanceAmazonStatisticsPage(WebDriver driver){
        super(driver);
    }

    public YahooFinanceAmazonStatisticsPage verifyDividends() {

    }
}

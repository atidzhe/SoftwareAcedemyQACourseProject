package seleniumTesting.YahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YahooFinanceStatisticsPage extends BasePage {



    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsInfo;
    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticBtn;
    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    private WebElement priceBook;


    public YahooFinanceStatisticsPage(WebDriver driver) {
        super(driver);
    }

    public YahooFinanceStatisticsPage goToStatistics() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(statisticBtn), 4);
        statisticBtn.click();
        return new YahooFinanceStatisticsPage(driver);
    }

    public WebElement getDividendsInfo() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(dividendsInfo), 4);
        return dividendsInfo;
    }

    public WebElement getPriceBook() {
        return priceBook;
    }

}

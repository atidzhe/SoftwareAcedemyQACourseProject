package seleniumTesting.YahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceStatisticsPage extends BasePage {


    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsInfo;
    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticBtn;
    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td\n")
    private WebElement priceBook;

    public YahooFinanceStatisticsPage(WebDriver driver) {
        super(driver);
    }

    public YahooFinanceStatisticsPage goToStatistics() {
        statisticBtn.click();
        return new YahooFinanceStatisticsPage(driver);
    }

    public WebElement getDividendsInfo() {
        return dividendsInfo;
    }

    public WebElement getPriceBook() {
        return priceBook;
    }

}

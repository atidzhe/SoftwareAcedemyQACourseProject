package seleniumTesting.YahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceStatisticsPage extends BasePage {


    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsInfo;
    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticBtn;
    @FindBy(xpath = "//td[contains(text(),'17.02')]")
    private WebElement priceBook;

    public YahooFinanceStatisticsPage(WebDriver driver) {
        super(driver);
    }

    public YahooFinanceStatisticsPage goToStatistics() {
        statisticBtn.click();
        return new YahooFinanceStatisticsPage(driver);
    }

    public YahooFinanceStatisticsPage verifyDividents(String dividents) {
        if (dividents.equalsIgnoreCase("N/A (N/A)")) {
            System.out.println("The company is not giving dividents");
        } else {
            System.out.println("The company is giving dividents");
        }
        return new YahooFinanceStatisticsPage(driver);
    }

    public YahooFinanceStatisticsPage verifyPriceBook(String priceBookValue) {

        if (priceBookValue.equalsIgnoreCase("17.02")) {
            System.out.println("The expected price match with actual");
        } else if (priceBookValue.equalsIgnoreCase("31.25")) {
            System.out.println("The expected price match with actual");
        } else {
            System.out.println("The expected price does not match with actual");
        }
        return new YahooFinanceStatisticsPage(driver);
    }

}

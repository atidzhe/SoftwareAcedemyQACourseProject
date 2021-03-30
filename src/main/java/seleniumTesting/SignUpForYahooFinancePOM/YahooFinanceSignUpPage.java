package seleniumTesting.SignUpForYahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class YahooFinanceSignUpPage extends BasePage{


    @FindBy(id = "usernamereg-firstName")
    private WebElement firstName;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastName;

    @FindBy(id = "usernamereg-yid")
    private WebElement email;

    @FindBy(id = "usernamereg-password")
    private WebElement password;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNum;

    @FindBy(id = "usernamereg-month")
    private WebElement dropdown;

    @FindBy(id = "usernamereg-day")
    private WebElement day;

    @FindBy(id = "usernamereg-year")
    private WebElement year;

    @FindBy(id = "reg-submit-button")
    private WebElement submitBtn;

    public YahooFinanceSignUpPage(WebDriver driver){
        super(driver);
    }


    public void enterData(String firstName, String lastName, String email, String password, String phoneNum,String day, String year){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);

        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.phoneNum.clear();
        this.phoneNum.sendKeys(phoneNum);

        Select drop = new Select(dropdown);
        drop.selectByIndex(3);

        this.day.clear();
        this.day.sendKeys(day);

        this.year.clear();
        this.year.sendKeys(year);
    }


    public YahooFinanceSignUpPage submitRegistration(){
        submitBtn.click();
        return new YahooFinanceSignUpPage(driver);
    }
}
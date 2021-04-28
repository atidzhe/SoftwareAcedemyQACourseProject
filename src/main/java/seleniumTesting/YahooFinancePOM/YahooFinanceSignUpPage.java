package seleniumTesting.YahooFinancePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class YahooFinanceSignUpPage extends BasePage {



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

    @FindBy(id = "usernamereg-freeformGender")
    private WebElement gender;

    @FindBy(id = "reg-submit-button")
    private WebElement submitBtn;

    @FindBy(id = "reg-error-yid")
    private WebElement emailErr;

    @FindBy(id = "reg-error-password")
    private WebElement passwordErr;

    @FindBy(id = "reg-error-phone")
    private WebElement phoneErr;

    @FindBy(id = "reg-error-birthDate")
    private WebElement birthDayErr;

    public YahooFinanceSignUpPage(WebDriver driver) {
        super(driver);
    }


    public void enterName(String firstName, String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void enterPhoneNumber(String phoneNum) {
        this.phoneNum.clear();
        this.phoneNum.sendKeys(phoneNum);
    }

    public void enterBirthDate(String day, String year) {
        Select drop = new Select(dropdown);
        drop.selectByIndex(3);

        this.day.clear();
        this.day.sendKeys(day);

        this.year.clear();
        this.year.sendKeys(year);
    }

    public void enterGender(String gender) {
        this.gender.clear();
        this.gender.sendKeys(gender);
    }
    public YahooFinanceSignUpPage submitRegistration() {
        submitBtn.click();
        return new YahooFinanceSignUpPage(driver);
    }

    public String emailError() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(emailErr), 4);
        return emailErr.getText();
    }

    public String passwordError() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(passwordErr), 4);
        return passwordErr.getText();
    }

    public String phoneError() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(phoneErr), 4);
        return phoneErr.getText();
    }

    public String birthDayError() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(birthDayErr), 4);
        return birthDayErr.getText();
    }

    public String emailErrMsg(){
        String emailErrorMessage = "This email address is not available for sign up, try something else";
        return emailErrorMessage;
    }

    public String passErrMsg(){
        String passErrMsg = "Your password isn’t strong enough, try making it longer.";
        return passErrMsg;
    }

    public String phoneErrMsg(){
        String phoneErrMsg = "That doesn’t look right, please re-enter your phone number.";
        return phoneErrMsg;
    }

    public String birthDateErrMsg(){
        String birthDateErrMsg = "That doesn’t look right, please re-enter your birthday.";
        return birthDateErrMsg;
    }


}
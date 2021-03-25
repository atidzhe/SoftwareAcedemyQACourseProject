package seleniumTesting.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import seleniumTesting.seleniumDriver.DriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

    public WebDriver driver;
    private String url;
    private int implicitlyWait;
    private String browser;

    @BeforeSuite
    public void readConfigProperties() throws IOException {
        try{
            FileInputStream configFile = new FileInputStream("src/test/resources/config.properties");
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitlyWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            browser = config.getProperty("browser");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setUp() throws InterruptedException{
        setUpBrowserDriver();
        loadUrl();
    }
    private void loadUrl(){
        driver.get(url);
    }
    private void setUpBrowserDriver()throws InterruptedException{
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitlyWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitlyWait);
                break;
            default:
                //  log.error("Unsupported browser type");
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}

package seleniumTesting.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import seleniumTesting.seleniumDriver.DriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

    public WebDriver driver;
    private String url;
    private int implicitlyWait;
    private String browser;


    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void setupBrowserDriver() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitlyWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            // browser to be taken from property file
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        // chrome implementation
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


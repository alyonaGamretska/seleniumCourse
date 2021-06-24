package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverFactory {
    private static final String DRIVER_PATH = "src/test/resources/";
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public DriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver getDriver() {
        File file;
        switch (browser) {
            case "chrome":
                file = new File(DRIVER_PATH + "chromedriver");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                file = new File(DRIVER_PATH + "geckodriver");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver.set(new FirefoxDriver());
                break;
            default:
                //file = new File(DRIVER_PATH + "chromedriver");
                //System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                //driver = new ChromeDriver();
                //break;
        }
        if (PropertyReader.getIsWindowMaximize()) {
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }
}

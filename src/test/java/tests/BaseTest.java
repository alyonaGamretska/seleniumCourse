package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;

public abstract class BaseTest {

    protected WebDriver driver;
    SearchSteps steps;


    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) {
        //driver = DriverFactory.getDriver(browser);
        DriverFactory driverFactory = new DriverFactory(browser);
        driver = driverFactory.getDriver();
        driver.navigate().to(PropertyReader.getBaseUrl());
        steps = new SearchSteps(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        PropertyReader.getBrowser().name();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().to(PropertyReader.getBaseUrl());
    }

    @DataProvider(name = "annotatedDataProvider")
    public Object[][] DataProviderMethod() {
        return new Object[][]{{"selenium"}, {"copy"}};
    }

}

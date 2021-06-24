package steps;

import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }
}

package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(css = "input[class=\"gLFyf gsfi\"]")
    private WebElement searchField;

    @FindBy(css = "div.FPdoLc.lJ9FBc input.gNO89b")
    private WebElement searchButton;

    @FindBy(css = ".gb_Se .gb_Ve ")
    private WebElement googleAppsIcon;

    @FindBy(css = "iframe[role=\"presentation\"]")
    private WebElement googleAppsIframe;

    @FindBy(css = "a[href*=\"youtube\"]")
    private WebElement youtubeIconInIframe;

    @FindBy(css = ".gb_f[href*=\"imghp\"]")
    private WebElement googleImagesIcon;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void fillInSearchField(String keyword) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void fillInSearchFieldUsingJS(String keyword) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        builder.click(searchField).build().perform();
        executor.executeScript("arguments[0].value = '" + keyword + "'",
                searchField);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickOnSearchButton() {
        assertThat(searchButton.isDisplayed()).as("The search button has not been displayed").isTrue();
        builder.click(searchButton).build().perform();
    }

    public void clickOnTheGoogleAppsIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(googleAppsIcon));
        builder.click(googleAppsIcon).build().perform();
        wait.until(ExpectedConditions.visibilityOf(googleAppsIframe));
    }

    public void clickOnTheYoutubeIconInIframe() {
        driver.switchTo().frame(googleAppsIframe);
        wait.until(ExpectedConditions.elementToBeClickable(youtubeIconInIframe));
        builder.click(youtubeIconInIframe).build().perform();
    }

    public void clickOnTheGoogleImageButton() {
        assertThat(googleImagesIcon.isDisplayed()).as("The google images button has not been displayed").isTrue();
        builder.click(googleImagesIcon).build().perform();
    }


}

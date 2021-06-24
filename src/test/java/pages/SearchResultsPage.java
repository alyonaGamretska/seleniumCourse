package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']//h3")
    private WebElement firstResultRow;

    @FindBy(css = "h3[class=\"LC20lb DKV0Md\"]") //same locator as firstResultRow;
    private List<WebElement> resultsRows;

    @FindBy(css = "img.WZ5ib")
    private WebElement imageResultPreview;

    @FindBy(css = "div.chip_text")
    private WebElement imageResultName;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void assertValuePresentsInTheSearchResults(String expectedValue) {
        wait.until(ExpectedConditions.visibilityOf(firstResultRow));
        for (int i = 0; i < resultsRows.size(); i++) {
            if (resultsRows.get(i).isDisplayed()) {
                assertThat(resultsRows.get(i).getText()).as("No expected search text").containsIgnoringCase(expectedValue);
            }
        }
    }

    /*public void assertThatResultsHaveCorrectText(String expected) {
        assertThat(resultsRows.get(0).isDisplayed()).as("Result row has not been displayed").isTrue();
        assertThat(resultsRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed").contains(expected);
    }*/

    public void assertThatSearchedImagePreviewDisplayed(String filename) {
        wait.until(ExpectedConditions.visibilityOf(imageResultPreview));
        assertThat(imageResultName.getText()).as("No founded searched image preview").contains(filename);
    }

}
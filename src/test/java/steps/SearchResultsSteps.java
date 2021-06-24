package steps;

import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;

public class SearchResultsSteps extends BaseSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public SearchResultsSteps(WebDriver driver) {
        super(driver);
    }

    public SearchResultsSteps verifyThatGivenValuePresentsInSearchResults(String expectedValue) {
        searchResultsPage.assertValuePresentsInTheSearchResults(expectedValue);
        return this;
    }

    public SearchResultsSteps verifyThatImageWasFound(String filename) {
        searchResultsPage.assertThatSearchedImagePreviewDisplayed(filename);
        return this;
    }
}

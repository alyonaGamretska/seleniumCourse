package steps;

import org.openqa.selenium.WebDriver;
import pages.SearchImagePage;
import pages.SearchPage;
import pages.YoutubeHomePage;

public class SearchSteps extends BaseSteps {

    private SearchPage searchPage = new SearchPage(driver);
    private SearchImagePage searchImagePage = new SearchImagePage(driver);

    public SearchSteps(WebDriver driver) {
        super(driver);
    }

    public SearchResultsSteps searchByTheKeywordWithEnterButton(String keyword) {
        searchPage.fillInSearchField(keyword);
        searchPage.pressEnter();
        return new SearchResultsSteps(driver);
    }

    public SearchResultsSteps searchByTheKeywordWithSearchButton(String keyword) {
        searchPage.fillInSearchFieldUsingJS(keyword);
        searchPage.clickOnSearchButton();
        return new SearchResultsSteps(driver);
    }

    public YoutubeHomePage clickOnTheYoutubeInGoogleApps() {
        searchPage.clickOnTheGoogleAppsIcon();
        searchPage.clickOnTheYoutubeIconInIframe();
        return new YoutubeHomePage(driver);
    }

    public SearchResultsSteps searchByImage(String filepath) {
        searchPage.clickOnTheGoogleImageButton();
        searchImagePage.clickOnAddImageIcon();
        searchImagePage.uploadFile(filepath);
        return new SearchResultsSteps(driver);
    }
}

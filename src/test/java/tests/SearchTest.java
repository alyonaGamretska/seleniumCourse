package tests;

import org.testng.annotations.Test;
import utils.CsvDataProvider;

import java.util.Map;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "annotatedDataProvider")
    public void searchTextWithEnterKey(String text) {
        steps.searchByTheKeywordWithEnterButton(text).verifyThatGivenValuePresentsInSearchResults(text);
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void searchTextWithSearchButton(Map<String, String> testData) {
        String text = testData.get("searchString");
        steps.searchByTheKeywordWithSearchButton(text).verifyThatGivenValuePresentsInSearchResults(text);
    }

    @Test
    public void openYoutubeFromGoogleAppsWidgetTest() {
        steps.clickOnTheYoutubeInGoogleApps();
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void searchByImageTest(Map<String, String> testData) {
        String filepath = testData.get("filepath");
        String filename = testData.get("filename");
        steps.searchByImage(filepath).verifyThatImageWasFound(filename);
    }
}

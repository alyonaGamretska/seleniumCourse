package pages;

import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class YoutubeHomePage extends BasePage{
    public YoutubeHomePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle()).as("Youtube Page was not opened").containsIgnoringCase("youtube");
    }

}

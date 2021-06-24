package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchImagePage extends SearchPage {
    public SearchImagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.tdPRye")
    private WebElement addImageIcon;

    @FindBy(css = "div#QDMvGf")
    private WebElement imageSearchPopup;

    @FindBy(css = "input#awyMjb")
    private WebElement fileUploadButton;

    public void clickOnAddImageIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(addImageIcon));
        builder.click(addImageIcon).build().perform();
        wait.until(ExpectedConditions.visibilityOf(imageSearchPopup));
    }

    public void uploadFile(String  filepath){
        assertThat(fileUploadButton.isEnabled()).isTrue();
        fileUploadButton.sendKeys(filepath);
        wait.until(ExpectedConditions.invisibilityOf(imageSearchPopup));

    }

}

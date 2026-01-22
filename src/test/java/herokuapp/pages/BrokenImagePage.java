package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class BrokenImagePage {

    private static final Logger log = LogManager.getLogger(BrokenImagePage.class);
    private WebDriver driver;

    public BrokenImagePage(WebDriver driver) {
        try {
        Reporter.log("Initializing BrokenImagePage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(tagName = "img")
    private List<WebElement> images;

    public int getImagesCount() {
        try {
        Reporter.log("Getting images count", true);
        int count = images.size();
        log.info("Total images: " + count);
        return count;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HoversPage {

    private static final Logger log = LogManager.getLogger(HoversPage.class);
    private WebDriver driver;

    public HoversPage(WebDriver driver) {
        Reporter.log("Initializing HoversPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".figure")
    private List<WebElement> figures;

    @FindBy(css = ".figure:nth-of-type(1) .figcaption a")
    private WebElement viewProfile1;

    public void hoverFirstUser() {
        Reporter.log("Hovering first user image", true);
        WaitUtil.waitForVisibility(driver, figures.get(0));
        new Actions(driver).moveToElement(figures.get(0)).perform();
        log.info("Hovered first user");
    }

    public boolean isViewProfileVisible() {
        Reporter.log("Checking View profile link visibility", true);
        return viewProfile1.isDisplayed();
    }
}

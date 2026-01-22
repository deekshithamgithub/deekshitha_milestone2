package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class EntryAdPage {

    private static final Logger log = LogManager.getLogger(EntryAdPage.class);
    private WebDriver driver;

    public EntryAdPage(WebDriver driver) {
        try{
        Reporter.log("Initializing EntryAdPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
            
    }

    @FindBy(css = ".modal")
    private WebElement modal;

    @FindBy(css = ".modal-footer p")
    private WebElement closeBtn;

    public boolean isModalDisplayed() {
        Reporter.log("Checking modal displayed", true);
        try {
            return modal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeModal() {
        try{
        Reporter.log("Closing modal", true);
        WaitUtil.waitForClick(driver, closeBtn);
        closeBtn.click();
        log.info("Modal closed");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

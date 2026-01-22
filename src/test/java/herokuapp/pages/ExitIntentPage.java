package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ExitIntentPage {

    private static final Logger log = LogManager.getLogger(ExitIntentPage.class);
    private WebDriver driver;

    public ExitIntentPage(WebDriver driver) {
        try{
        Reporter.log("Initializing ExitIntentPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void triggerExitIntent() {
        try{
        Reporter.log("Triggering exit intent", true);
        // Move mouse out of viewport
        new Actions(driver).moveByOffset(0, 0).moveByOffset(-100, -100).perform();
        log.info("Exit intent triggered");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isModalDisplayed() {
        try{
        return driver.findElements(org.openqa.selenium.By.cssSelector(".modal")).size() > 0;
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

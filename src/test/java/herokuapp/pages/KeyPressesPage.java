package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class KeyPressesPage {

    private static final Logger log = LogManager.getLogger(KeyPressesPage.class);
    private WebDriver driver;

    public KeyPressesPage(WebDriver driver) {
        try{
        Reporter.log("Initializing KeyPressesPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "target")
    private WebElement input;

    @FindBy(id = "result")
    private WebElement result;

    public void pressKey(Keys key) {
        try{
        Reporter.log("Pressing key: " + key, true);
        WaitUtil.waitForVisibility(driver, input);
        input.sendKeys(key);
        log.info("Key pressed");
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        try{
        WaitUtil.waitForVisibility(driver, result);
        return result.getText();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

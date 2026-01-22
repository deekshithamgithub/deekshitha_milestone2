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

public class ContextMenuPage {

    private static final Logger log = LogManager.getLogger(ContextMenuPage.class);
    private WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        try{
        Reporter.log("Initializing ContextMenuPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "hot-spot")
    private WebElement box;

    public void rightClickBox() {
        try{
        Reporter.log("Right click context menu box", true);
        WaitUtil.waitForVisibility(driver, box);
        new Actions(driver).contextClick(box).perform();
        log.info("Context click performed");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

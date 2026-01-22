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

public class DragDropPage {

    private static final Logger log = LogManager.getLogger(DragDropPage.class);
    private WebDriver driver;

    public DragDropPage(WebDriver driver) {
        try {
        Reporter.log("Initializing DragDropPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
              } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "column-a")
    private WebElement boxA;

    @FindBy(id = "column-b")
    private WebElement boxB;

    public String getBoxAHeader() {
         try {
        WaitUtil.waitForVisibility(driver, boxA);
        return boxA.findElement(org.openqa.selenium.By.tagName("header")).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dragAtoB() {
         try {
        Reporter.log("Dragging A to B", true);
        new Actions(driver).dragAndDrop(boxA, boxB).perform();
        log.info("Drag A -> B performed");
         } catch (Exception e) {
            e.printStackTrace();
        }    
    }
}

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
        Reporter.log("Initializing DragDropPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "column-a")
    private WebElement boxA;

    @FindBy(id = "column-b")
    private WebElement boxB;

    public String getBoxAHeader() {
        WaitUtil.waitForVisibility(driver, boxA);
        return boxA.findElement(org.openqa.selenium.By.tagName("header")).getText();
    }

    public void dragAtoB() {
        Reporter.log("Dragging A to B", true);
        new Actions(driver).dragAndDrop(boxA, boxB).perform();
        log.info("Drag A -> B performed");
    }
}

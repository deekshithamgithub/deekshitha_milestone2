package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DynamicLoadingPage {

    private static final Logger log = LogManager.getLogger(DynamicLoadingPage.class);
    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        try{
        Reporter.log("Initializing DynamicLoadingPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    private WebElement example2;

    public void openExample2() {
         try{
        Reporter.log("Opening Dynamic Loading Example 2", true);
        example2.click();
        log.info("Example 2 opened");
             } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

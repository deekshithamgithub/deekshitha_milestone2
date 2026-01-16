//package herokuapp.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class HomePage {
//
//    private final WebDriver driver;
//
//    private final By header = By.tagName("h1");
//    private final By subHeader = By.tagName("h2");
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public String getHeaderText() {
//        return driver.findElement(header).getText();
//    }
//
//    public String getSubHeaderText() {
//        return driver.findElement(subHeader).getText();
//    }
//
//    public void openLink(String linkText) {
//        driver.findElement(By.linkText(linkText)).click();
//    }
//}

package herokuapp.pages;

import herokuapp.utility.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriver driver;

    public HomePage(WebDriver driver){
        Reporter.log("Initializing HomePage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(tagName = "h2")
    private WebElement subHeader;

    public String getHeaderText(){
        Reporter.log("Fetching Home header text", true);
        WaitUtil.waitForVisibility(driver, header);
        String text = header.getText();
        log.info("Header Text: " + text);
        return text;
    }

    public String getSubHeaderText(){
        Reporter.log("Fetching Home sub-header text", true);
        WaitUtil.waitForVisibility(driver, subHeader);
        String text = subHeader.getText();
        log.info("SubHeader Text: " + text);
        return text;
    }

    public void openModule(String linkText){
        Reporter.log("Opening module link: " + linkText, true);
        driver.findElement(org.openqa.selenium.By.linkText(linkText)).click();
        log.info("Opened module: " + linkText);
    }
}


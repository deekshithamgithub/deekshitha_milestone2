package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FloatingMenuPage {

    private static final Logger log = LogManager.getLogger(FloatingMenuPage.class);
    private WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        Reporter.log("Initializing FloatingMenuPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu")
    private WebElement menu;

    public void scrollDown() {
        Reporter.log("Scrolling down", true);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");
        log.info("Scrolled down");
    }

    public boolean isMenuDisplayed() {
        return menu.isDisplayed();
    }
}

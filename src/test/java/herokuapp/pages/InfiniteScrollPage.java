package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InfiniteScrollPage {

    private static final Logger log = LogManager.getLogger(InfiniteScrollPage.class);
    private WebDriver driver;

    public InfiniteScrollPage(WebDriver driver) {
        Reporter.log("Initializing InfiniteScrollPage", true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollDown() {
        Reporter.log("Scrolling down in infinite scroll page", true);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        log.info("Scrolled down");
    }

    public boolean hasParagraphs() {
        return driver.findElements(org.openqa.selenium.By.className("jscroll-added")).size() > 0;
    }
}

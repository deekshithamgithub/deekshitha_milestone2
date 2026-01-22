package herokuapp.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BasePageTemplate {

    protected static final Logger log = LogManager.getLogger(BasePageTemplate.class);
    protected WebDriver driver;

    public BasePageTemplate(WebDriver driver){
        try {
        Reporter.log("Initializing Page: " + this.getClass().getSimpleName(), true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

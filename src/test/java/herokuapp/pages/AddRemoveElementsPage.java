package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {

    private final WebDriver driver;

    private final By addElementBtn = By.xpath("//button[text()='Add Element']");
    private final By deleteBtns = By.xpath("//button[text()='Delete']");
    private final By heading = By.tagName("h3");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeading() {
        try {
            return driver.findElement(heading).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;   // return null if not found
        }
    }

    public void clickAddElement() {
        try {
            driver.findElement(addElementBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDeleteButtonsCount() {
        try {
            return driver.findElements(deleteBtns).size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;   // return 0 if any error
        }
    }

    public void clickFirstDelete() {
        try {
            List<WebElement> buttons = driver.findElements(deleteBtns);
            if (!buttons.isEmpty()) {
                buttons.get(0).click();   // click first delete button
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

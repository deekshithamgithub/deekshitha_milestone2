package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        return driver.findElement(heading).getText();
    }

    public void clickAddElement() {
        driver.findElement(addElementBtn).click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteBtns).size();
    }

    public void clickFirstDelete() {
        List<?> buttons = driver.findElements(deleteBtns);
        if (!buttons.isEmpty()) {
            driver.findElements(deleteBtns).get(0).click();
        }
    }
}

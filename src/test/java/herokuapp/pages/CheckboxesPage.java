package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage {

    private final WebDriver driver;
    private final By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public int countCheckboxes() {
        return driver.findElements(checkboxes).size();
    }

    public boolean isChecked(int index) {
        List<WebElement> list = driver.findElements(checkboxes);
        return list.get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        driver.findElements(checkboxes).get(index).click();
    }
}

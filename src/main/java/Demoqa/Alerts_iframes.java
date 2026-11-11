
package Demoqa;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Alerts_iframes extends HomePage {

    // Click first card from HomePage
    public void elements_menu() {

        clickFirstCard();
    }

    // Click Alerts, Frame & Windows menu
    public void Alerts_menu() {

        WebElement alert_menu = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='icon'])[3]")
            )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            alert_menu
        );

        alert_menu.click();
    }

    // Click Browser Windows and open a new tab
    public void Browser_windows() {

        WebElement browser_menu = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Browser Windows']")
            )
        );

        browser_menu.click();

        String parentWindow = driver.getWindowHandle();

        WebElement new_tab = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("tabButton")
            )
        );

        assertEquals(new_tab.getText(), "New Tab");

        new_tab.click();

        // Wait until new tab opens
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println("Switched to new tab successfully");

        // Close new tab and return to parent
        driver.close();

        driver.switchTo().window(parentWindow);
    }

    // Click Alerts menu
    public void alert() {

        WebElement Alerts = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Alerts']")
            )
        );

        Alerts.click();

        String alert_text = Alerts.getText();

        assertEquals(alert_text, "Alerts");

        System.out.println("Alerts text assertion passed");
    }
}

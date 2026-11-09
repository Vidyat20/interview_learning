package Demoqa;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Alerts_iframes extends HomePage {

//    // Locators
//
//    By alertMenu = By.xpath(
//        "//div[contains(text(),'Alerts, Frame & Windows')]"
//    );
//
//    By browserWindow = By.xpath(
//        "//span[normalize-space()='Browser Windows']"
//    );
//
//    By newTab = By.xpath("//button[text()='New Tab']");


    // Methods

    // Click first card from HomePage
    public void elements_menu() {
        clickFirstCard();
    }

    // Click Alerts, Frame & Windows menu
    public void Alerts_menu() {

        WebElement alert_menu = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[@class='icon'])[3]")
            )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 1: Scroll the element into the center of the screen
        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            alert_menu
        );

        // Step 2: Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(alert_menu));

        // Step 3: Click the element
        alert_menu.click();
    }
    // Click Browser Windows and open a new tab
    public void Browser_windows() {

          WebElement browser_menu = driver.findElement(By.xpath("//span[normalize-space()='Browser Windows']"));
          browser_menu.click();
          WebElement new_tab = driver.findElement(By.xpath("//button[@id='tabButton']"));
          new_tab.click();
          String actual_text = new_tab.getText();
          assertEquals(actual_text, "New Tab");
          System.out.println("assertion passed");
    }
    public void alert() {
    	WebElement Alerts = driver.findElement(By.xpath("//span[normalize-space()='Alerts']"));
    	Alerts.click();
    	String alert_text = Alerts.getText();
    	assertEquals(alert_text, "Alerts");
    	System.out.println("Alerts text is matching with the actual text");
    }
    
    
}

package Demoqa;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BaseClass {

    // Home Page Methods

    public void clickFirstCard() {

        WebElement element_card = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='card mt-4 top-card'])[1]")
            )
        );

        element_card.click();
    }

    public void text_box() {

        WebElement click_text_box = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Text Box']")
            )
        );

        click_text_box.click();

        Assert.assertEquals(click_text_box.getText(), "Text Box");
    }

    public void enter_details() {

        driver.findElement(By.id("userName")).sendKeys("Vidya T");

        driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");

        driver.findElement(By.id("currentAddress")).sendKeys("bangalure");

        driver.findElement(By.id("permanentAddress")).sendKeys("BTM");

        WebElement submit = driver.findElement(By.id("submit"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            submit
        );

        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();
    }

    public void checkbox() {

        WebElement click_checkboxMenu = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Check Box']")
            )
        );

        click_checkboxMenu.click();

        assertEquals(click_checkboxMenu.getText(), "Check Box");

        System.out.println("Checkbox assertion passed");
    }

    public void RadioButton() {

        WebElement Click_RadioButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Radio Button']")
            )
        );

        Click_RadioButton.click();

        assertEquals(Click_RadioButton.getText(), "Radio Button");

        WebElement Click_yes = driver.findElement(
            By.xpath("//label[@for='yesRadio']")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            Click_yes
        );

        wait.until(ExpectedConditions.elementToBeClickable(Click_yes));

        Click_yes.click();

        System.out.println("Yes radio button selected");

        Assert.assertTrue(
            driver.findElement(By.id("yesRadio")).isSelected(),
            "Yes radio button was not selected"
        );
    }

    public void Web_Tables() {

        WebElement Click_WebTables = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Web Tables']")
            )
        );

        Click_WebTables.click();

        assertEquals(Click_WebTables.getText(), "Web Tables");

        System.out.println("Web Tables assertion passed");

        WebElement delete_record = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='rt-tr-group'][.//div[text()='Cierra']]//span[@title='Delete']")
            )
        );

        delete_record.click();
    }

    public void Button() {

        WebElement Click_Button = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Buttons']")
            )
        );

        Click_Button.click();

        assertEquals(Click_Button.getText(), "Buttons");

        System.out.println("Button assertion passed");

        Actions action = new Actions(driver);

        WebElement Double_click = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("doubleClickBtn")
            )
        );

        action.doubleClick(Double_click).perform();

        Assert.assertTrue(
            driver.findElement(By.id("doubleClickMessage")).isDisplayed(),
            "Double click message not displayed"
        );

        WebElement Right_click = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("rightClickBtn")
            )
        );

        action.contextClick(Right_click).perform();

        Assert.assertTrue(
            driver.findElement(By.id("rightClickMessage")).isDisplayed(),
            "Right click message not displayed"
        );
    }

    public void Links() {

        WebElement Click_links = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Links']")
            )
        );

        Click_links.click();
    }

    public void Broken_links() {

        WebElement broken_links = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Broken Links - Images']")
            )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            broken_links
        );

        broken_links.click();

        WebElement click_BrokenLinks = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Click Here for Broken Link']")
            )
        );

        String actual_text = click_BrokenLinks.getText();

        System.out.println(actual_text);

        click_BrokenLinks.click();

        driver.navigate().back();
    }

    public void download_upload() {

        WebElement download = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Upload and Download']")
            )
        );

        download.click();

        WebElement click_download = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("downloadButton")
            )
        );

        click_download.click();

        // Verify downloaded file

        String downloadPath = System.getProperty("user.home") + "\\Downloads\\";

        File file = new File(downloadPath + "sampleFile.jpeg");

        int attempts = 0;

        while (attempts < 20 && !file.exists()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            attempts++;
        }

        Assert.assertTrue(
            file.exists(),
            "File was not downloaded successfully!"
        );

        System.out.println("File downloaded successfully: " + file.getName());
    }

    public void Dynamic_properties() {

        WebElement dynamicProperties = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Dynamic Properties']")
            )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            dynamicProperties
        );

        dynamicProperties.click();

        // Verify button becomes enabled after 5 seconds

        WebElement after_5seconds = driver.findElement(
            By.id("enableAfter")
        );

        wait.until(ExpectedConditions.elementToBeClickable(after_5seconds));

        Assert.assertTrue(
            after_5seconds.isEnabled(),
            "Button is still disabled"
        );

        System.out.println("Button enabled successfully");

        // Verify button becomes visible after 5 seconds

        WebElement visible_after_5seconds = driver.findElement(
            By.id("visibleAfter")
        );

        wait.until(ExpectedConditions.visibilityOf(visible_after_5seconds));

        Assert.assertTrue(
            visible_after_5seconds.isDisplayed(),
            "Button is not visible"
        );

        System.out.println("Button displayed successfully");
    }
}

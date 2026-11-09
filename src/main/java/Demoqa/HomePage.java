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
        WebElement element_card = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1]"));
        element_card.click();
    }
    public void text_box() {
    	WebElement click_text_box = driver.findElement(By.xpath("//span[normalize-space()='Text Box']"));
    	click_text_box.click();
    	String title = click_text_box.getText();
    	System.out.println(title);
    }
    public void enter_details() {

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Vidya T");

        WebElement emailId = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailId.sendKeys("abc@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("bangalure");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("BTM");

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));

        // Scroll to the Submit button
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            submit
        );

        // Click Submit
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }
    public void checkbox() {
    	WebElement click_checkboxMenu = driver.findElement(By.xpath("//span[text()='Check Box']"));
    	click_checkboxMenu.click();
    	String actual_text = click_checkboxMenu.getText();
        assertEquals(actual_text, "Check Box");
        System.out.println("Assertion passed");
    }
    public void RadioButton() {

        WebElement Click_RadioButton = driver.findElement(
            By.xpath("//span[normalize-space()='Radio Button']")
        );

        Click_RadioButton.click();

        String actual_text = Click_RadioButton.getText();
        assertEquals(actual_text, "Radio Button");

        System.out.println("Radio assertion passed");

        // Locate the visible Yes label instead of the hidden input
        WebElement Click_yes = driver.findElement(
            By.xpath("//label[@for='yesRadio']")
        );

        // Scroll to the Yes radio button
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            Click_yes
        );

        wait.until(ExpectedConditions.elementToBeClickable(Click_yes));

        Click_yes.click();

        System.out.println("Yes radio button selected");
    
    	
    }
    public void Web_Tables() {
    	WebElement Click_WebTables = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
    	Click_WebTables.click();
    	String actual_text = Click_WebTables.getText();
    	assertEquals(actual_text, "Web Tables");
    	System.out.println("Web Tables assertion passed");
    	WebElement delete_record = driver.findElement(By.xpath("//div[text()='Cierra']/following-sibling::div[6]/div/span[2]"));
    	delete_record.click();
    	
    }
    public void Button() {
    	WebElement Click_Button = driver.findElement(By.xpath("//span[normalize-space()='Buttons']"));
    	Click_Button.click();
    	String actual_text = Click_Button.getText();
    	assertEquals(actual_text, "Buttons");
    	System.out.println("Button assertion passed");
    	WebElement Double_click = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
    	Double_click.isDisplayed();
    	Actions action = new Actions(driver);
    	action.doubleClick(Double_click).perform();
    	WebElement Right_click = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
    	Right_click.isDisplayed();
    	Actions action1 = new Actions(driver);
    	action1.contextClick(Right_click);
    	
    }
    public void Links() {
    	WebElement Click_links = driver.findElement(By.xpath("//span[normalize-space()='Links']"));
    	Click_links.click();
    }
    public void Broken_links() {

        WebElement broken_links = driver.findElement(
            By.xpath("//span[normalize-space()='Broken Links - Images']")
        );

        // Scroll to the menu and click
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            broken_links
        );

        broken_links.click();

        WebElement click_BrokenLinks = driver.findElement(
            By.xpath("//a[normalize-space()='Click Here for Broken Link']")
        );

        // Scroll to the actual link
        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            click_BrokenLinks
        );

        // Get link text
        String actual_text = click_BrokenLinks.getText();
        System.out.println(actual_text);

        // Click the link
        click_BrokenLinks.click();
        driver.navigate().back();
    }
    
    public void download_upload() {
    	WebElement download = driver.findElement(By.xpath("//span[normalize-space()='Upload and Download']"));
    	download.click();
    	WebElement click_downlaod = driver.findElement(By.xpath("//span[normalize-space()='Upload and Download']"));
    	click_downlaod.click();
    	 // Wait for the file to download
        String downloadPath = System.getProperty("user.home") + "\\Downloads\\";
        File file = new File(downloadPath + "sampleFile.jpeg");

        int attempts = 0;

        while (attempts < 20 && !file.exists()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            attempts++;
        }

        Assert.assertTrue(file.exists(), "File was not downloaded successfully!");

        System.out.println("File downloaded successfully: " + file.getName());
    
    }
    public void Dynamic_properties() throws Throwable {
    	WebElement dynamicProperties = driver.findElement(By.xpath("//span[normalize-space()='Dynamic Properties']"));
    	dynamicProperties.click();
    	WebElement after_5seconds = driver.findElement(By.xpath("//button[@id='enableAfte']"));
    	after_5seconds.isDisplayed();
    	Thread.sleep(5000);
    	after_5seconds.isEnabled();
    	WebElement visible_after_5seconds = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
    	Thread.sleep(5000);
    }
    
    }

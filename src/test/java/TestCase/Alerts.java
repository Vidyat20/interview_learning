
package TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Demoqa.Alerts_iframes;

public class Alerts extends Alerts_iframes {

    @BeforeClass
    public void setup() {
        System.out.println("Setup started");

        launchBrowser();

        System.out.println("Driver initialized: " + (driver != null));
    }

    @Test(priority=1, groups = {"smoke"})
    public void verify_elementClick() {
    	elements_menu();
    }
    @Test(priority=2, enabled = true, groups= {"smoke"})
    public void verify_alertmenu() { 
    	Alerts_menu();
    }
    @Test(priority=3, enabled=true, groups= {"smoke", "smoke"})
    public void verify_browserWindow() {
    	Browser_windows();
    	}
    public void Click_alerts() {
    	alert();
    }
    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

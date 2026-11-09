
package TestCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import Listeners.TestListener;

import Demoqa.HomePage;
@Listeners(TestListener.class)
public class HomePage_TC001 extends HomePage {

    @BeforeClass
    public void setup() {
        launchBrowser();
        
    }
    

    @Test(priority =1)
    public void verifyFirstCard() {
    	
        clickFirstCard();
    }
    @Test(priority=2, dependsOnMethods = {"verifyFirstCard"})
    public void verify_textBox() {
    	text_box();
    }
    @Test(priority=3, dependsOnMethods = {"verify_textBox"})
   public void verifytextFields() {
    	enter_details();
    }
    @Test(priority=4, dependsOnMethods = {"verifytextFields"})
    public void verify_checkBox() {
    	checkbox();
    }
    @Test(priority=5)
    public void verify_radiobutton() {
    	RadioButton();
    }
    @Test(priority=6)
    public void verify_webtables() {
    	Web_Tables();
    }
    @Test(priority=7)
    public void verify_button() {
    	Button();
    }
    @Test(priority=8)
    public void verify_links() {
    	Links();
    }
    @Test(priority=9)
    public void verify_brokenlinks() {
    	Broken_links();
    }
    @Test(priority=10)
    public void verify_downloadUpload() {
    	download_upload();
    }
    @Test(priority=11)
    public void verify_dynamicproperties() throws Throwable {
    	Dynamic_properties();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
    
}

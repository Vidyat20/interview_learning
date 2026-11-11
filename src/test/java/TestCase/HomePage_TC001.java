
package TestCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import Demoqa.HomePage;

@Listeners(TestListener.class)
public class HomePage_TC001 extends HomePage {

    @Test(priority = 1, groups = {"regression"})
    public void verifyFirstCard() {
        clickFirstCard();
    }

    @Test(priority = 2, groups = {"regression"})
    public void verify_textBox() {
        clickFirstCard();
        text_box();
    }

    @Test(priority = 3, groups = {"regression"})
    public void verifytextFields() {
        clickFirstCard();
        text_box();
        enter_details();
    }

    @Test(priority = 4, groups = {"regression"})
    public void verify_checkBox() {
        clickFirstCard();
        checkbox();
    }

    @Test(priority = 5, groups = {"regression"})
    public void verify_radiobutton() {
        clickFirstCard();
        RadioButton();
    }

    @Test(priority = 6, groups = {"regression"})
    public void verify_webtables() {
        clickFirstCard();
        Web_Tables();
    }

    @Test(priority = 7, groups = {"regression"})
    public void verify_button() {
        clickFirstCard();
        Button();
    }

    @Test(priority = 8, groups = {"regression"})
    public void verify_links() {
        clickFirstCard();
        Links();
    }

    @Test(priority = 9, groups = {"regression"})
    public void verify_brokenlinks() {
        clickFirstCard();
        Broken_links();
    }

    @Test(priority = 10, groups = {"regression"})
    public void verify_downloadUpload() {
        clickFirstCard();
        download_upload();
    }

    @Test(priority = 11, groups = {"regression"})
    public void verify_dynamicproperties() throws Throwable {
        clickFirstCard();
        Dynamic_properties();
    }
}

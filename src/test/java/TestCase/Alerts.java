
package TestCase;

import org.testng.annotations.Test;

import Demoqa.Alerts_iframes;

public class Alerts extends Alerts_iframes {

    @Test(priority = 1, groups = {"smoke"})
    public void verify_elementClick() {

        elements_menu();
    }

    @Test(priority = 2, groups = {"smoke"})
    public void verify_alertmenu() {

        elements_menu();
        Alerts_menu();
    }

    @Test(priority = 3, groups = {"smoke"})
    public void verify_browserWindow() {

        elements_menu();
        Alerts_menu();
        Browser_windows();
    }

    @Test(priority = 4, groups = {"smoke"})
    public void Click_alerts() {

        elements_menu();
        Alerts_menu();
        alert();
    }
}

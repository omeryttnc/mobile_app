package omer.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import omer.Utilities;
import omer.pages.AccountPage;
import omer.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageButtonTest {


    @Test
    public void test01() {

        String username = "canli_satici@mailsac.com";
        String password = "3AJygjifmqYcjv5";

        HomePage homePage = new HomePage();
        AccountPage accountPage = new AccountPage();

        Driver.getAppiumDriver().findElementByAccessibilityId("Urbanicfarm").click();
        Utilities.wait(5);

        homePage.account.click();
        Utilities.wait(5);
        accountPage.email.click();
        accountPage.email.sendKeys(username);
        Utilities.wait(2);
        accountPage.password.click();
        accountPage.password.sendKeys(password);
        Utilities.wait(2);
        Driver.appiumDriver.hideKeyboard();
        accountPage.submit.click();


        //Driver.quitAppiumDriver();

//
//        //id
//        driver.findElementById("com.davemac327.gesture.tool:id/addButton");
//        //driver.findElement(By.name("com.davemac327.gesture.tool:id/addButton"));
//
//        //xpath text file
//        driver.findElementByXPath("//*[@text='Add gesture']");
//
//        //xpath index file
//        driver.findElementByXPath("(//android.widget.Button)[1]");
//
//        //xpath attribute
//        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
//
//        Thread.sleep(3000);
//        driver.findElementByXPath("//*[@class='android.widget.EditText']").sendKeys("appium");
//        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
//
//        Thread.sleep(2000);
//        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
//
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElementByXPath("(//*[@text='appium'])[1]").isDisplayed());
//
//        driver.findElementById("com.davemac327.gesture.tool:id/testButton").click();
//
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElementById("android:id/title").getText().equals("Test a gesture"));
//
//

    }


}

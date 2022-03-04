package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayse/eclipse-workspace/mobileTesting/src/apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/savsa/IdeaProjects/AppiumMobileTesting/src/apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(5000);


        //id
        driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        //driver.findElement(By.name("com.davemac327.gesture.tool:id/addButton"));

        //xpath text file
        driver.findElementByXPath("//*[@text='Add gesture']");

        //xpath index file
        driver.findElementByXPath("(//android.widget.Button)[1]");

        //xpath attribute
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();

        Thread.sleep(3000);
        driver.findElementByXPath("//*[@class='android.widget.EditText']").sendKeys("appium");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();

        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.findElementByXPath("(//*[@text='appium'])[1]").isDisplayed());

        driver.findElementById("com.davemac327.gesture.tool:id/testButton").click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.findElementById("android:id/title").getText().equals("Test a gesture"));



    }


}

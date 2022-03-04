package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Appium09UiSelector {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Tugraoppo");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayse/eclipse-workspace/mobileTesting/src/apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //In UiSelector ' is not used
        //resourceId ile
       // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        //class name ile
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();

        List<WebElement> buttons = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");

//        for (WebElement elt : buttons) {
//            if (elt.getText().equals("Add gesture")) elt.click();
//        }

        //.checkable(false)
        //.clickable(true)
        //getAttribute("checkable")


    }
}

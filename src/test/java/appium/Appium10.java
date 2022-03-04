package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium10 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Tugraoppo");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayse/eclipse-workspace/mobileTesting/src/apps/apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"API Demos\")").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        driver.findElementById("android:id/checkbox").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/edit").sendKeys("test");
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();




    }


}

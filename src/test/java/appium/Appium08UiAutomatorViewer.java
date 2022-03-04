package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.uiautomator2.server;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium08UiAutomatorViewer {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Tugraoppo");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayse/eclipse-workspace/mobileTesting/src/apps/Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(10000);

        driver.findElementByXPath("//android.widget.Button[@text='4']").click();

    }
    }

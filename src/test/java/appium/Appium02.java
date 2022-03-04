package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Appium02 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Tugraoppo");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\savsa\\IdeaProjects\\AppiumMobileTesting\\src\\apps\\apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(5000);

        List<AndroidElement> numlist = new ArrayList<>();

        for(int i = 0; i<10; i++) {

            numlist.add( driver.findElementById("com.google.android.calculator:id/digit_" + i));

        }

        AndroidElement multiply = driver.findElementByAccessibilityId("multiply");
        AndroidElement equal = driver.findElementByAccessibilityId("equals");
        AndroidElement divide = driver.findElementByAccessibilityId("divide");
        AndroidElement minus = driver.findElementByAccessibilityId("minus");
        AndroidElement plus = driver.findElementByAccessibilityId("plus");

        numlist.get(1).click();
        numlist.get(5).click();
        multiply.click();
        numlist.get(3).click();
        equal.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/result_final").getText().equals("45"));












    }
}

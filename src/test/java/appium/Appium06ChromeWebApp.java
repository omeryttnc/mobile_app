package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06ChromeWebApp {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
      //  desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desiredCapabilities);

        Thread.sleep(5000);

        //chrome://inspect/#devices
        driver.get("https://www.amazon.com");
        System.out.println("1 " + driver.getContext());

        Set contextNames = driver.getContextHandles();
        for (Object contextName: contextNames) {
            System.out.println(contextName);
            Thread.sleep(3000);
            if(contextName.toString().contains("CHROMIUM")) {
                driver.context((String) contextName);
                Thread.sleep(10000);
            }
        }
        System.out.println("2 " + driver.getContext());
        driver.findElementByXPath("//a[@id='nav-logobar-greeting']").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());

        System.out.println("3 " + driver.getContext());



    }
}

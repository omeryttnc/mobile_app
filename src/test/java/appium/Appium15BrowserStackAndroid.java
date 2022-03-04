package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium15BrowserStackAndroid {

    @Test
    public void browserStackAndroid() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "ayse_KipAWn");
        caps.setCapability("browserstack.key", "AarW8BjHNG3qV58EzByT");

        // Set URL of the application under test
        caps.setCapability("app", "bs://4ea22e767f1bbbfc26a63a130347aeef64e05c75");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here

        driver.findElementById("org.wikipedia:id/bottomOffset").click();
        driver.findElementById("org.wikipedia:id/bottomOffset").click();
        driver.findElementById("org.wikipedia:id/bottomOffset").click();
        driver.findElementById("org.wikipedia:id/bottomOffset").click();

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();



    }
}

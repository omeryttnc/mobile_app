package omer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public  class Utilities {
//    public static AndroidDriver<WebElement> setup(){
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//       // desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix X690");
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
//
//
//        URL url = null;
//        try {
//            url = new URL("http://127.0.0.1:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return driver;
//    }

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

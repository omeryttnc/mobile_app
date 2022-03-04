package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import utilities.Driver;

import java.awt.*;
import java.net.MalformedURLException;
import java.time.Duration;

public class Appium14Scroll extends AppiumBase{

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"API Demos\")").click();

        MobileElement listitem = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Views\"));"));

        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Dimension dimension = driver.manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int ent_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(PointOption.point(start_x,start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(ent_x, end_y)).perform();

    }
}

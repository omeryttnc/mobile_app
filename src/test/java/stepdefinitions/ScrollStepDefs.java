package stepdefinitions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import pages.AllPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class ScrollStepDefs {

    AllPages elements =  new AllPages();
    @Then("kullanici Switches tiklasin")
    public void kullanici_switches_tiklasin() {

        Dimension dimension = Driver.appiumDriver.manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int ent_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touchAction = new TouchAction(Driver.appiumDriver);

        for (int i=0; i < 3; i++)
        touchAction.press(PointOption.point(start_x,start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(ent_x, end_y)).perform();


        elements.viewsPage().switchesSingle.click();
    }

    @Then("kullanici UiScrolable ile Switches tiklasin")
    public void kullaniciUiScrolableIleSwitchesTiklasin() throws InterruptedException {
      /*
      UiScrollable() sadece android sisteminde calisir cunku Android SDK uzerinden calisyor.
      Yazdigimiz kodda verilen text e kadar scroll yapmasi (scrollIntoView()) ve texti bulunca durmasini istedik.
      ve buldugumuz elemente senaryomuza gore tikladik.
      **** UiScrollable() kendimiz yazmamiz gerektigi icin hata olmamasina dikkat etmeliyiz.
      Detayli bakamk icin link incelenebilir.
      https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable
       */
        MobileElement listitem = (MobileElement) Driver.appiumDriver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Switches\"));"));

        Thread.sleep(3000);


        elements.viewsPage().switchesSingle.click();


    }

    @Then("kullanici UiScrolable ile {string} tiklasin")
    public void kullanici_ui_scrolable_ile_tiklasin(String text) {
//        ((AndroidDriver<?>) Driver.getAppiumDriver()).
//                findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
//
//        elements.viewsPage().webView.click();
        //reusable method kullaniyoruz
        ReusableMethods.scrollWithUiScrollable(text);
    }

    @Then("kullanci app kapatsin")
    public void kullanciAppKapatsin() {
        Driver.appiumDriver.closeApp();

    }
}
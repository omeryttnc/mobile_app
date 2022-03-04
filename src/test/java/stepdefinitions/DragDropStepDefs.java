package stepdefinitions;

import appium.AppiumBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import pages.AllPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DragDropStepDefs {
    AllPages elements = new AllPages();


    @When("kullanici Views tiklasin")
    public void kullanici_views_tiklasin() throws MalformedURLException, InterruptedException {

        MobileElement listitem = (MobileElement) Driver.getAppiumDriver().findElement(
                MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Views\"));"));

        Thread.sleep(3000);
        elements.apiDemosPage().views.click();

    }

    @When("kullanici drag and drop tiklasin")
    public void kullanici_drag_and_drop_tiklasin() {
        elements.viewsPage().dragDrop.click();
    }

    @Then("kullanici ilk noktayi alip ucuncu noktaya tasiyacak")
    public void kullanici_ilk_noktayi_alip_ucuncu_noktaya_tasiyacak() {
        TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
        touchAction.longPress(ElementOption.element(elements.dragDropPage().dot1))
                .moveTo(ElementOption.element(elements.dragDropPage().dot3)).release().perform();
    }

    @Then("cikan yaziyi onayliyacak")
    public void cikan_yaziyi_onayliyacak() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(elements.dragDropPage().text.isDisplayed());

    }

}
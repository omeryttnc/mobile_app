package omer.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)),this);
    }

    @AndroidFindBy(xpath = "(//android.view.View)[17]")
    public MobileElement account;
     @AndroidFindBy(xpath = "(//android.view.View)[16]")
    public MobileElement favorites;
     @AndroidFindBy(xpath = "(//android.view.View)[15]")
    public MobileElement weekly;
     @AndroidFindBy(xpath = "(//android.view.View)[14]")
    public MobileElement events;
     @AndroidFindBy(xpath = "(//android.view.View)[13]")
    public MobileElement home;

}


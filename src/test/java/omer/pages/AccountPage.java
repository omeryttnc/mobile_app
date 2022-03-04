package omer.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class AccountPage {
    public AccountPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)),this);
    }

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public MobileElement password;
     @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public MobileElement email;
     @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Login\"])[2]")
    public MobileElement submit;


}


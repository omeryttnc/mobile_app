package stepdefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

public class ReadyMethodsStepDefs {

        @Then("kullanici {string} tiklasin")
        public void kullanici_tiklasin(String pageName) throws InterruptedException {
            ReusableMethods.clickOnPage1(pageName);
        }

}

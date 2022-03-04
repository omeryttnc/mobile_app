package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

public class ExpandableList {

    AllPages elements = new AllPages();


    @Then("kullanici Arnold basili tuttugunda")
    public void kullanici_arnold_basili_tuttugunda() {
        ReusableMethods.longPressOnElement(elements.expandableListsPage().arnold);

    }

    @Then("popup ciktiginda onaylasin")
    public void popup_ciktiginda_onaylasin() {
        Assert.assertTrue(elements.expandableListsPage().sampleMenu.isDisplayed());

    }

}

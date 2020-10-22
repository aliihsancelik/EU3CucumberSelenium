package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ContactsStepDefs {


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedMenuOptions) {
        Assert.assertEquals(expectedMenuOptions, BrowserUtils.getElementsText(new DashboardPage().menuOptions));
    }
}

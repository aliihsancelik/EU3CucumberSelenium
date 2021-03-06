package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedMenuOptions) {
        Assert.assertEquals(expectedMenuOptions, BrowserUtils.getElementsText(new DashboardPage().menuOptions));
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        String expectedName = userInfo.get("firstname")+" "+userInfo.get("lastname");
        String actualName = new DashboardPage().getUserName();
        Assert.assertEquals(expectedName,actualName);


    }
}

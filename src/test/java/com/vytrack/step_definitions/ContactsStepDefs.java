package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;
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

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String actualEmail) {
        BrowserUtils.waitFor(2);
        new ContactsPage().getContactEmail(actualEmail).click();
    }



    //DATABASE TESTING PART !!!
    @Then("the information for {string} should be same with database")
    public void the_information_for_should_be_same_with_database(String email) {
        BrowserUtils.waitFor(2);


        //get info from UI:
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        //get info from DATABASE:

//DBUtils.createConnection(); ==> it is in custom before in hooks(because in this test any previous step fails it won't open connection!)

        //query for retrieving first name,last name,email,phone
        String query = "select concat (first_name,' ',last_name) as fullname,oe.email,phone \n" +
                "from orocrm_contact oc join orocrm_contact_email oe\n" +
                "on oc.id = oe.owner_id\n" +
                "join orocrm_contact_phone op\n" +
                "on oc.id = op.owner_id\n" +
                "where oe.email = '"+email+"'";

        //we are getting only one row of result
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullname = (String) rowMap.get("fullname");//data type is object that's why casted
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //close connection
//DBUtils.destroy(); ==> it is in custom after in hooks(because in this test any previous step fails it won't close connection!)


        //ASSERTION, compare UI against DATABASE:
        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);
    }




}

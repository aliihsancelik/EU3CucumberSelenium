package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class VehiclesStepDefs {

    @Then("the user clicks the vehicle has {string} driver name")
    public void the_user_clicks_the_vehicle_has_driver_name(String driverName) {
        BrowserUtils.waitFor(2);
        new VehiclesPage().getVehicle(driverName).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the information for the vehicle has {string} driver name is same with the database")
    public void the_information_for_the_vehicle_has_driver_name_is_same_with_the_database(String driverName) {

        //get the infos from UI part which we wanna verify
        VehiclesPage vehiclesPage = new VehiclesPage();
        String responsible = vehiclesPage.responsible.getText();
        String activationCost = vehiclesPage.activationCost.getText();
        String odometerDetails = vehiclesPage.odometerDetails.getText();

        System.out.println("responsible = " + responsible);
        System.out.println("activationCost = " + activationCost);
        System.out.println("odometerDetails = " + odometerDetails);


        //get the infos from DATABASE part




        //ASSERTION BETWEEN UI AND DATABASE



    }
}

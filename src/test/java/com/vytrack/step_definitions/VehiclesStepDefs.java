package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class VehiclesStepDefs {


    @Then("the user clicks the vehicle contract has {string} responsible name")
    public void the_user_clicks_the_vehicle_contract_has_responsible_name(String responsible) {
        BrowserUtils.waitFor(2);
        new VehiclesPage().getVehicle(responsible).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the information for the vehicle contract has {string} responsible name is same with the database")
    public void the_information_for_the_vehicle_contract_has_responsible_name_is_same_with_the_database(String responsible) {

        //get the infos from UI part which we wanna verify
        VehiclesPage vehiclesPage = new VehiclesPage();
        String actualType = vehiclesPage.type.getText().toLowerCase();
        String actualActivationCost = vehiclesPage.activationCost.getText();
        String actualOdometerDetails = vehiclesPage.odometerDetails.getText();

        System.out.println("actualType = " + actualType);
        System.out.println("actualActivationCost = " + actualActivationCost);
        System.out.println("actualOdometerDetails = " + actualOdometerDetails);


        //get the infos from DATABASE part
        Map<String,Object> row = DBUtils.getRowMap("select ActivationCost , OdometerDetails,Type_id from oro_ext_vehiclecontract\n" +
                "where responsible='"+responsible+"'");
        String expectedType = row.get("Type_id").toString().toLowerCase();
        String expectedActivationCostWithDecimels = row.get("ActivationCost").toString();
        String expectedOdometerDetailsWithDecimels = row.get("OdometerDetails").toString();

        String expectedActivationCost = expectedActivationCostWithDecimels.substring(0,expectedActivationCostWithDecimels.indexOf('.'));
        String expectedOdometerDetails = expectedOdometerDetailsWithDecimels.substring(0,expectedOdometerDetailsWithDecimels.indexOf('.'));

        System.out.println("expectedType = " + expectedType);
        System.out.println("expectedActivationCost = " + expectedActivationCost);
        System.out.println("expectedOdometerDetails = " + expectedOdometerDetails);


        //ASSERTION BETWEEN UI AND DATABASE
        Assert.assertEquals(expectedType,actualType);
        Assert.assertEquals(expectedActivationCost,actualActivationCost);
        Assert.assertEquals(expectedOdometerDetails,actualOdometerDetails);

    }
}

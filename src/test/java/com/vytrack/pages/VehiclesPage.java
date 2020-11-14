package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{


    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement responsible;

    @FindBy(xpath = "(//div[@class='control-label'])[3]")
    public WebElement activationCost;

    @FindBy(xpath = "(//div[@class='control-label'])[6]")
    public WebElement odometerDetails;


    public WebElement getVehicle(String responsible){
        WebElement responsibleLocator = Driver.get().findElement(By.xpath("//td[contains(text(),'"+responsible+"')]"));
        return responsibleLocator;
    }
}

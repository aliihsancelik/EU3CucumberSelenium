package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage{


    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement licencePlate;

    @FindBy(xpath = "(//div[@class='control-label'])[3]")
    public WebElement driverName;

    @FindBy(xpath = "(//div[@class='control-label'])[6]")
    public WebElement modelYear;


    public WebElement getVehicle(String driverName){
        WebElement driverNameLocator = Driver.get().findElement(By.xpath("//td[contains(text(),'"+driverName+"')]"));
        return driverNameLocator;
    }
}

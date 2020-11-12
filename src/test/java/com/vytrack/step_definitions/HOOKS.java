package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class HOOKS {


    @Before(order = 0) //for all scenarios executes before, order=0 means before everything for @before
    public void setUp(){

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After(order = 0) //for all scenarios executes before, order=0 means after everything for @after OPPOSITE of before!!
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }



    @Before(value = "@database", order = 1) //custom before: the scenario you put @database before, it runs before
    public void setUpDatabase(){

        System.out.println("\tconnecting to database");
        DBUtils.createConnection();
    }
    @After(value = "@database", order = 1 ) //custom after: the scenario you put @database before, it runs after
    public void tearDownDatabase(){

        System.out.println("\tdisconnecting to database");
        DBUtils.destroy();
    }

}

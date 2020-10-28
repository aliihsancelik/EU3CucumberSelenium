package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

     plugin = {"html:target/failed-html-report"},//simple cucumber report to see which is failed,it works with regular run and maven-verify as well.
     features = "@target/rerun.txt",
     glue = "com/vytrack/step_definitions"
        //There are plugins in pom that provides to get failed ones and run again but be careful about the runner file names,
        //-because the plugin in pom is in Alphabetical order for the runners, check your pom and see!!

)

public class FailedTestRunner {

}

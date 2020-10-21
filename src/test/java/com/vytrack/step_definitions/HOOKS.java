package com.vytrack.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HOOKS {

    @Before(order = 0) //for all scenarios executes before, order=0 means before everything for @before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
    }

    @After(order = 0) //for all scenarios executes before, order=0 means after everything for @after OPPOSITE of before!!
    public void tearDown(){
        System.out.println("\tthis is coming from After");
    }


    @Before(value = "@database", order = 1) //custom before: the scenario you put @database before, it runs before
    public void setUpDatabase(){
        System.out.println("\tconnecting to database");
    }
    @After(value = "@database", order = 1 ) //custom after: the scenario you put @database before, it runs after
    public void tearDownDatabase(){
        System.out.println("\tdisconnecting to database");
    }

}

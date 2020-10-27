package com.sch.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(app.getUserHelper().isLoginButtonPresent()){
            app.getUserHelper().defaultLogin();
        }
    }
    @Test
    public void testEventCreation(){
        /*
        * tap on Plus button
        * tapOnPencil
        * fillEventCreationForm
        * TapOnAddEventButton
        * */
        app.getEventHelper().tapOnPlusButton();
        app.getEventHelper().tapOnPencil();
        app.getEventHelper().fillEventCreationForm("aaaaa", "1", 3);
        app.getEventHelper().TapOnAddEventButton();


    }
}

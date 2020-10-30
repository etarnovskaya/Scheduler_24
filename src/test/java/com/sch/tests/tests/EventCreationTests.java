package com.sch.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
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

        app.getEventHelper().fillEventCreationForm("aaaaa", "1", 3, "150");
        app.getEventHelper().TapOnAddEventButton();


    }

    @Test
    public void testEventCreationChangeDate(){
        /*
         * tap on Plus button
         * tapOnPencil
         * fillEventCreationForm
         * TapOnAddEventButton
         * */
        int before = app.getEventHelper().getEventCountByMonth("November");
        app.getEventHelper().tapOnPlusButton();
        app.getEventHelper().tapOnPencil();
        app.getEventHelper().swipeCalendarToLeft();

        app.getEventHelper().fillEventCreationForm("aaaaa", "1", 3, "50");
        app.getEventHelper().TapOnAddEventButton();

        Assert.assertTrue(app.getEventHelper().isEventPresent());
        int after = app.getEventHelper().getEventCountByMonth("November");

        Assert.assertEquals(after, before+1 );


    }
}

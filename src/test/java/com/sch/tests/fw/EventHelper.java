package com.sch.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventHelper extends HelperBase {
    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    /*tap on Plus button
     * tapOnPencil
     * fillEventCreationForm
     * TapOnAddEventButton*/

    public void tapOnPlusButton() {
        tap(By.id("fab_main"));

    }

    public void fillEventCreationForm(String title, String type, int breaks) {
//swipeLeftSelectPastDate
        //swipeRightSelectFutureDate

        type(By.id("info_title_input"), title);
        type(By.id("info_type_input"), type);
        closeKeyboard();
        if (breaks > 0) {
            for (int i = 0; i < breaks; i++) {
                tapOnAddBreakButton();
            }
        }
    }

    public void tapOnAddBreakButton() {
        tap(By.id("info_break_plus_btn"));

    }

    public void TapOnAddEventButton() {
        tap(By.id("info_save_btn"));

    }

    public void tapOnPencil() {
        tap(By.id("fab_add_event"));
    }
}

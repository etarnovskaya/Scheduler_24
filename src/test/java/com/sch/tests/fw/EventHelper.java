package com.sch.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public void fillEventCreationForm(String title, String type, int breaks, String wage) {
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
        addWage(wage);
    }

    private void addWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"), wage);
        tap(By.id("info_wage_save"));
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

    public void swipeCalendarToLeft(){
        moveElementToLeft(By.id("date_container_layout"));
    }

//    public void swipeCalendarToLeft2(){
//        moveElementToLeft2(By.id("date_root"));
//    }

    public boolean isEventPresent(){
        waitForElement(By.id("row_container_main"), 20);
        return isElementPresent(By.id("row_container_main"));
    }

    public int getEventCountByMonth(String month) {
        //getDisplayedMonth
        //if displayedmonth != month, click on arrow

        String displayedmonth = driver.findElement(By.id("nav_month_name")).getText();
        while (!displayedmonth.equals(month.toUpperCase())){
            tap(By.id("nav_next_img"));
            displayedmonth = driver.findElement(By.id("nav_month_name")).getText();
        }

        return driver.findElements(By.id("row_container_main")).size();
    }
}

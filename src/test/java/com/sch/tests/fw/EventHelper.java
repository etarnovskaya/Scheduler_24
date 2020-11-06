package com.sch.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

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

        type(By.id("info_title_inpu"), title);
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

    public void swipeCalendarToLeft() {
        moveElementToLeft(By.id("date_container_layout"));
    }

//    public void swipeCalendarToLeft2(){
//        moveElementToLeft2(By.id("date_root"));
//    }

    public boolean isEventPresent() {
        waitForElement(By.id("row_container_main"), 20);
        return isElementPresent(By.id("row_container_main"));
    }

    public int getEventCountByMonth(String month) {
        //getDisplayedMonth
        //if displayedmonth != month, click on arrow

        String displayedmonth = driver.findElement(By.id("nav_month_name")).getText();
        while (!displayedmonth.equals(month.toUpperCase())) {
            tap(By.id("nav_next_img"));
            displayedmonth = driver.findElement(By.id("nav_month_name")).getText();
        }

        return driver.findElements(By.id("row_container_main")).size();
    }

    public void selectDate(String type, String month, String dayOfMonth) {
        if (!getSelectedMonth().equals(month)) {
            if (type.equals("past")) {
               swipeDateToRightUntilNeededMonth(month);

               if(!getSelectedDayOfMonth().equals(dayOfMonth)){
                   swipeDateToRightUntillNeededDayOfMonth(dayOfMonth);
               }
//                swipeToRightUntilNeededDay(dayOfMonth);
            } else if (type.equals("future")) {
                swipeDateToLeftUntilNeededMonth(month);
                if(!getSelectedDayOfMonth().equals(dayOfMonth)){
                    swipeDateToLeftUntillNeededDayOfMonth(dayOfMonth);
                }//swipeToLeftUntilNeededDay(dayOfMonth);
            }
        } else if(!getSelectedDayOfMonth().equals(dayOfMonth)){
            if (type.equals("past")) {
                swipeDateToRightUntillNeededDayOfMonth(dayOfMonth);
            }else if (type.equals("future")) {
                swipeDateToLeftUntillNeededDayOfMonth(dayOfMonth);
            }


        }

        }


    private void swipeDateToLeftUntillNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeDateToRightUntillNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeDateToRightUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedMonth();
        }
    }

    private void moveElementToRight(By locator) {
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width* 0.2);
        int rightPoint = (int) (size.width* 0.5);

//get Element's point
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX()* 0.2);
        int rightX = (int) ((leftX + element.getSize().getWidth())* 0.8);
        int upperY = element.getLocation().getY() ;
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(leftPoint, middleY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))

                .moveTo(PointOption.point(rightPoint, middleY))
                .release()
                .perform();
    }

    private void swipeDateToLeftUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedMonth();
        }

    }

    private String getSelectedMonth() {
        WebElement selectedDate = driver.findElement(By.id("date_container_layout"));
        return selectedDate.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']"))
                .getText();
    }

    private String getSelectedDayOfMonth() {
        WebElement selectedDate = driver.findElement(By.id("date_container_layout"));
        return selectedDate.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']"))
                .getText();
    }
}

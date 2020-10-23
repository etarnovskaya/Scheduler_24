package com.sch.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchAppTest {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
/*
* {
  "platformName", "Android",
  "deviceName", "qa_24_8_0",
  "platformVersion", "8.0",
  "appPackage", "com.example.svetlana.scheduler",
  "appActivity", "presentation.splashScreen.SplashScreenActivity"
}*/
    @BeforeClass
    public void setUp() throws MalformedURLException {
      capabilities = new DesiredCapabilities();
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("deviceName", "qa_24_8_0");
      capabilities.setCapability("platformVersion", "8.0");
      capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
      capabilities.setCapability("appActivity", "presentation.splashScreen.SplashScreenActivity");
      capabilities.setCapability("automationName", "Appium");
      capabilities.setCapability("app", "C:\\Users\\Elena\\Dropbox\\Tel-ran\\Mobile\\Grisha\\SuperScheduler\\v.0.0.3.apk");

      driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testLaunchApp(){
        String version = driver.findElement(By.id("app_version_res")).getText();
        System.out.println("App version " + version + " launched");
        Assert.assertEquals(version,"0.0.3");
    }

    @AfterClass(enabled = false)
    public void tearDown(){

    }

}

package com.sch.tests.fw;

import com.sch.tests.tests.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public AppiumDriver driver;
    DesiredCapabilities capabilities;

    UserHelper userHelper;
    EventHelper eventHelper;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa_24_8_0");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", "presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Users\\Elena\\Dropbox\\Tel-ran\\Mobile\\Grisha\\SuperScheduler\\v.0.0.3.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        logger.info("device is Ready");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(driver);
        eventHelper = new EventHelper(driver);
    }

    public void stop(){
            driver.quit();
    }

    public String getAppVersion(){
        return driver.findElement(By.id("app_version_res")).getText();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public EventHelper getEventHelper() {
        return eventHelper;
    }
}

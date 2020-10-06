package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.Home;


import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    AndroidDriver<MobileElement> driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy Nexus API 30");

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        
        driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"),caps);
    }

    @Test
    public  void basicTest() throws InterruptedException {
        Home prueba = new Home(this.driver);
        prueba.clickDisplayTextButton();
        Thread.sleep(500);
        System.out.println(prueba.getTextDisplayed());
        Assert.assertTrue(prueba.getTextDisplayed().contains("Text is sometimes displayed"));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

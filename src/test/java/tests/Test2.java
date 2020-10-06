package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.Home;
import screens.RegistrationScreen;
import screens.VerifyUser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test2 {
    AndroidDriver<MobileElement> driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy Nexus API 30");

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        //caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"),caps);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public  void basicTest() throws InterruptedException {
        Home prueba = new Home(this.driver);
        prueba.clickRegistrationButton();
        Thread.sleep(1000);
        RegistrationScreen registrationScreen = new RegistrationScreen(this.driver);
        registrationScreen.enterUserName("Elia");
        registrationScreen.enterEmail("theqacorner1@gmail.com");
        registrationScreen.enterPassword("pass123");
        registrationScreen.scroll();
        Thread.sleep(2000);
        registrationScreen.enterName("EliaP");
        registrationScreen.setProgLanguage("Python");
        registrationScreen.scroll();
        Thread.sleep(2000);
        registrationScreen.clickCheckAdds();
        registrationScreen.clickRegister();
        Thread.sleep(2000);
        VerifyUser verifyUser = new VerifyUser(this.driver);
        Assert.assertTrue(verifyUser.getName().contains("EliaP"));
        verifyUser.clicRegister();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

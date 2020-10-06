package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;



public class Home {

    private AndroidDriver<MobileElement> driver;

    By chromeButton = By.id("io.selendroid.testapp:id/buttonStartWebview");
    By registrationButton = By.id("io.selendroid.testapp:id/startUserRegistration");
    By showProgBarButton = By.id("io.selendroid.testapp:id/waitingButtonTest");
    By checkAcceptAds = By.id("io.selendroid.testapp:id/input_adds_check_box");
    By displayToastButton = By.id("io.selendroid.testapp:id/showToastButton");
    By displayPopupButton = By.id("io.selendroid.testapp:id/showPopupWindowButton");

    By textDiv = By.id("io.selendroid.testapp:id/visibleTextView");
    By displayTextButton = By.id("io.selendroid.testapp:id/visibleButtonTest");

    public Home(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    public String getTextDisplayed(){
       return getText(textDiv);
    }
    public void clickRegistrationButton(){
        click(registrationButton);
    }


    public void clickDisplayTextButton(){
        click(displayTextButton);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}

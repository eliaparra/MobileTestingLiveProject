package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class VerifyUser {
    private AndroidDriver<MobileElement> driver;

    By registerButton = By.id("io.selendroid.testapp:id/buttonRegisterUser");
    By name = By.id("io.selendroid.testapp:id/label_name_data");

    public VerifyUser(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clicRegister(){
        click(registerButton);
    }
    public String getName(){
        return getText(name);
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}

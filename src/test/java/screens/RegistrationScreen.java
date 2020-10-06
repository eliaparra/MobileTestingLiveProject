package screens;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegistrationScreen {

    private AndroidDriver<MobileElement> driver;

    By userName = By.id("io.selendroid.testapp:id/inputUsername");
    By email = By.id("io.selendroid.testapp:id/inputEmail");
    By password = By.id("io.selendroid.testapp:id/inputPassword");
    By name = By.id("io.selendroid.testapp:id/inputName");
    By progLanguage = By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
    By checkAdds = By.id("io.selendroid.testapp:id/input_adds");
    By registerButton = By.id("io.selendroid.testapp:id/btnRegisterUser");

    public RegistrationScreen(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void enterUserName(String text){
        enterText(userName,text);
    }
    public void enterEmail(String text){
        enterText(email,text);
    }
    public void enterPassword(String text){
        enterText(password,text);
    }
    public void enterName(String text){
        enterText(name,text);
    }
    public void setProgLanguage(String text) throws InterruptedException {
        setSelector(progLanguage,text);
    }
    public void clickCheckAdds(){
        click(checkAdds);
    }
    public void clickRegister(){
        click(registerButton);
    }
    public void scroll() {
//The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //x position set to mid-screen horizontally
        int width = size.width / 2;

        //Starting y location set to 80% of the height (near bottom)
        int startPoint = (int) (size.getHeight() * 0.50);

        //Ending y location set to 20% of the height (near top)
        int endPoint = (int) (size.getHeight() * 0.20);

        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();




    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void setSelector(By locator, String text) throws InterruptedException {
       driver.findElement(locator).click();
       Thread.sleep(1000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[4]")).click();
    }

    private void enterText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}

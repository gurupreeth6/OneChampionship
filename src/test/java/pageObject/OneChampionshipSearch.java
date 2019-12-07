package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneChampionshipSearch {
    AndroidDriver<MobileElement> driver;
    public OneChampionshipSearch(AndroidDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uE8B6']")
    @CacheLookup
    AndroidElement searchButton;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Athletes')]")
    @CacheLookup
    AndroidElement athleteButton;

    @AndroidFindBy(xpath="//android.widget.EditText")
    @CacheLookup
    AndroidElement editText;

    public void clickOnSearchButton(){
        searchButton.click();
    }
    public void clickOnAthleteButton() {athleteButton.click();}
    public void clickOnPlayerProfile(String playerName){
        driver.findElement(By.xpath("//android.widget.ScrollView//android.view.ViewGroup/android.widget.TextView[@text='"+playerName+"']")).click();
    }
    public void inputSearchBar(String playerName){
        editText.sendKeys(playerName);
    }

}

package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneChampionshipProfile {
    AndroidDriver<MobileElement> driver;
    public OneChampionshipProfile(AndroidDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup//android.widget.TextView[@text='Angela Lee']")
    @CacheLookup
    AndroidElement playerNameInProfilePage;

    public void waitForPlayerProfileToLoad(String playerName){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup//android.widget.TextView[@text='"+playerName+"']")));
    }

    public String getNickNameOfPlayer(String playerName){
        return driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup//android.widget.TextView[@text='\uF23D']/../following-sibling::android.widget.TextView")).getText();
    }

}

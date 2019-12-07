package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneChampionshipHome {
    AndroidDriver<MobileElement> driver;
    public OneChampionshipHome(AndroidDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    @CacheLookup
    AndroidElement countryList;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    @CacheLookup
    AndroidElement nextButton;

    @AndroidFindBy(xpath = "//*[@text='FOLLOW']")
    AndroidElement followButton;

    @AndroidFindBy(xpath = "//*[@text='FOLLOW'][2]")
    AndroidElement followButton2;

    @AndroidFindBy(xpath = "//*[@text='UNFOLLOW']")
    AndroidElement unfollowButton1;

    @AndroidFindBy(xpath = "//*[@text='UNFOLLOW'][2]")
    AndroidElement unfollowButton2;

    @AndroidFindBy(xpath = "//*[@text='Finish']")
    @CacheLookup
    AndroidElement finishButton;

    public void waitForCountryListPageToLoad(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(countryList));
    }

    public void clickNext(){
        nextButton.click();
    }

    public void clickFollowButton(){
        followButton.click();
    }

    public void verifyAthleteFollowed(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(unfollowButton1));
    }

    public void clickFinish(){
        finishButton.click();
    }
}

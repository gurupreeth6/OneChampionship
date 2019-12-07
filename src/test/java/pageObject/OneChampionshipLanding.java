package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneChampionshipLanding {
    AndroidDriver<MobileElement> driver;
    public OneChampionshipLanding(AndroidDriver<MobileElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @CacheLookup
    AndroidElement firstCarouselEvent;

    @AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    @CacheLookup
    AndroidElement carouselTextNextToVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Editor's picks\"]/../following-sibling::android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView")
    AndroidElement editorPickFirstElement;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SHARE']")
    AndroidElement shareButton;




    public void waitForLandingListPageToLoad(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(firstCarouselEvent));
    }

    public String getFirstCarouselText(){
        return firstCarouselEvent.getText();
    }

    public void clickFirstCaousel() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstCarouselEvent).perform();
        firstCarouselEvent.click();
    }

    public String getCarouselTextInVideoPage(){
        return carouselTextNextToVideo.getText();

    }

    public String getSecondCarouselText(){
        return editorPickFirstElement.getText();
    }

    public void clickSecondCarousel(){
        editorPickFirstElement.click();
    }

    public void checkForShareButtonInEditorspickPage(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(shareButton));
    }


}

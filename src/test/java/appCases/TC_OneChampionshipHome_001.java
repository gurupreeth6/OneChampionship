package appCases;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.OneChampionshipHome;
import pageObject.OneChampionshipLanding;
import pageObject.OneChampionshipProfile;
import pageObject.OneChampionshipSearch;
import utils.XLUtils;

import java.io.IOException;

public class TC_OneChampionshipHome_001 extends BaseClass {
    @Test(priority = 0)
    public void ContryAndAthleteSelect() throws InterruptedException {
        //Initialise home page
        OneChampionshipHome home = new OneChampionshipHome(driver);

        //Wait for country list page to load
        home.waitForCountryListPageToLoad();

        //Click on Next button
        home.clickNext();

        //Select the two athletes
        home.clickFollowButton();
        home.clickFollowButton();

        //Check if the athlete are followed
        home.verifyAthleteFollowed();

        //Click on finish
        home.clickFinish();

    }

    @Test(priority = 1)
    public void VerifyFirstCarouselEvent() throws InterruptedException, IOException {
        //Initialise home page
        OneChampionshipLanding landing = new OneChampionshipLanding(driver);

        //Verify the landing page is opened
        landing.waitForLandingListPageToLoad();

        //Get the First carousel Heading
        String carouselText = landing.getFirstCarouselText();

        System.out.println(carouselText);

        //Click on first carousel
        landing.clickFirstCaousel();

        //Verify the text next to video
        String carouselTextNextToVideo= landing.getCarouselTextInVideoPage();
        if(carouselText.equals(carouselTextNextToVideo)){
            Assert.assertTrue(true);
        }
        else{
            captureScreenshot(driver,"Carousel text verification");
            logger.error("Carousel text verification failed");
            Assert.assertTrue(false);
        }

        //Click on back button
        driver.navigate().back();


    }

    @Test(dataProvider = "SearchData",priority = 2)
    public void VerifySearchAthlete(String playerName) throws InterruptedException {

        OneChampionshipLanding landing = new OneChampionshipLanding(driver);
        OneChampionshipSearch search = new OneChampionshipSearch(driver);
        OneChampionshipProfile profile = new OneChampionshipProfile(driver);
        //Get the text of first element of second carousel
        String firstElementSecondCarouselText = landing.getSecondCarouselText();

        //Click on first element of second carousel
        landing.clickSecondCarousel();

        //Check if the text in the header is same as first element second carousel text
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='"+firstElementSecondCarouselText+"']")));

        //Click on Search
        search.clickOnSearchButton();

        Thread.sleep(3000);
        //Search for angela lee
        search.inputSearchBar(playerName);

        Thread.sleep(3000);

        //Click on Athletes
        search.clickOnAthleteButton();

        //Click on the player
        search.clickOnPlayerProfile(playerName);

        //Check for the player profile to appear on screen
        profile.waitForPlayerProfileToLoad(playerName);

        Thread.sleep(3000);

        //Print Player's nickname
        System.out.println(profile.getNickNameOfPlayer(playerName.toUpperCase()));


    }

    @DataProvider(name="SearchData")
    Object[][] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/src/test/java/testData/SearchData.xlsx";
        int rowNumber= XLUtils.getRowCount(path,"Sheet1");
        int columnCount=XLUtils.getCellCount(path,"Sheet1",1);

        String searchData[][]=new String[rowNumber][columnCount];
        for (int i=1;i<=rowNumber;i++){
            for(int j=0;j<columnCount;j++){
                searchData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return searchData;
    }

}

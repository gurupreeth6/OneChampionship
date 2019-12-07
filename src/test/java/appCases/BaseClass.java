package appCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String appBaseUrl= readConfig.getApplicationURL();
    public String deviceName = readConfig.getDeviceName();
    public static AndroidDriver<MobileElement> driver;
    public static IOSDriver<MobileElement> iosDriver;
    public static DesiredCapabilities capabilities;
    public static Logger logger;


    @Parameters("device")
    @BeforeClass
    public void setUp(String d) throws MalformedURLException {
        if(d.equals("android")) {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
            capabilities.setCapability("autoAcceptAlerts",true);
            capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/App/app-arm64-v8a-release.apk");
            driver = new AndroidDriver<MobileElement>(new URL(appBaseUrl),capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.resetApp();
            logger = (Logger) LogManager.getLogger(this.getClass().getName());
        }
        else if(d.equals("ios")){
            capabilities=new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone XR");
            iosDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            iosDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            iosDriver.resetApp();

            logger=(Logger) LogManager.getLogger(this.getClass().getName());

        }
    }

    @AfterClass
    public void tearDown(){
        driver.closeApp();
    }

}

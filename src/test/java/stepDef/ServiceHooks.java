/**
 * This file start and stop APPIUM session
 *
 * @author  Vaibhav Khachane
 * @since   26/03/2020
 *  Update History
 * 21-09-2020 Added report builder code
 */

package stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class
ServiceHooks {

    private static String Appium_Node_Path;
    private static String Appium_JS_Path;
    private static String platformName;
    private static String deviceName;
    private static String platformVersion;
    private static String appPackage;
    private static String appActivity;
    private static String automationName;
    private static String newCommandTimeout;
    private static String autoGrantPermissions;
    private static String unicodeKeyboard;
    private static String resetKeyboard;
    private static String fastReset;
    private static String Emulatorlaunch="/Users/apple/Desktop/DeviceLaunch/avdLaunch.txt";
    static String service_url;
    private String appiumPort;
    private String serverIp;
    public static AndroidDriver<MobileElement> driver;
    public static String rootPath = System.getProperty("user.dir");
    AppiumDriverLocalService service;
    File filePath = new File(System.getProperty("user.dir"));
    File appDir = new File(filePath, "/apk/21-09-2021");
    File app = new File(appDir, "46.apk");

    @Before
    public AndroidDriver<MobileElement> start() throws MalformedURLException {

        Properties pro = new Properties();

        try {
            InputStream input = new FileInputStream(rootPath + "/src/test/java/Config/config.properties");
            pro.load(input);

            Appium_Node_Path = pro.getProperty("Appium_Node_Path");
            Appium_JS_Path = pro.getProperty("Appium_JS_Path");
            platformName = pro.getProperty("platformName");
            deviceName = pro.getProperty("deviceName");
            platformVersion = pro.getProperty("platformVersion");
            //app = pro.getProperty(rootPath + "/apk/KashNoDx.apk");
            //appPackage = pro.getProperty("appPackage");
            //appActivity = pro.getProperty("appActivity");
            automationName = pro.getProperty("automationName");
            newCommandTimeout = pro.getProperty("newCommandTimeout");
            autoGrantPermissions = pro.getProperty("autoGrantPermissions");
            //unicodeKeyboard = pro.getProperty("unicodeKeyboard");
            //resetKeyboard = pro.getProperty("resetKeyboard");
            fastReset = pro.getProperty("fastReset");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().   //Start Appium implementation 1
                usingAnyFreePort().usingDriverExecutable(new File("/usr/local/bin/node")).
                withAppiumJS(new File("/usr/local/bin/appium")));

        service.start();
        service_url = service.getUrl().toString();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("app", "/Users/apple/IdeaProjects/KASH_ANDROID_Project/apk/KashNoDx.apk");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("newCommandTimeout", newCommandTimeout);
        capabilities.setCapability("autoGrantPermissions", autoGrantPermissions);
        capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
        capabilities.setCapability("resetKeyboard", resetKeyboard);
        capabilities.setCapability("fastReset", fastReset);
        //capabilities.setCapability("deviceId", "192.168.1.201:5555"); // This is for execute test script into android device over wifi network
        //capabilities.setCapability("locale", "es_CR");
        //capabilities.setCapability("language", "es");
        //capabilities.setCapability("–session-override", true);

        //driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);  //Start appium providing static url

        String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";  //Start appium providing dynamic url
        driver = new AndroidDriver(new URL(service_url), capabilities);

        // Following code check network connectivity
        ConnectionState state = driver.setConnection(
                new ConnectionStateBuilder(driver.getConnection())
                        .withAirplaneModeDisabled()
                        .withWiFiEnabled()
                        .withDataEnabled()
                        .build());
        Assert.assertFalse(state.isAirplaneModeEnabled());
        Assert.assertTrue(state.isWiFiEnabled());
        Assert.assertTrue(state.isDataEnabled());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);


        return driver;
    }

    @After
    public void stop(Scenario scenario) throws InterruptedException, IOException {


        if (scenario.isFailed()) {

            System.out.println(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else {
            System.out.println(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }

        if (driver != null) {

            driver.resetApp();
            driver.quit();
            service.stop();

        }
    }
}



package screens;

import stepDef.ServiceHooks;
import Utilities.Screenshots;
import com.cucumber.listener.Reporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginElements {

    private final AndroidDriver<MobileElement> driver;

    @AndroidFindBy(accessibility = "ID")
    public static MobileElement changeLang;

    @AndroidFindBy(accessibility = "Terms of Use")
    public static MobileElement homeScreenValText;

    @AndroidFindBy(accessibility = "English")
    public static MobileElement english;

    @AndroidFindBy(accessibility = "Login")
    public static MobileElement loginBtnonFirstScreen;

    @AndroidFindBy(accessibility = "Email")
    public static MobileElement loginscreenValText;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[1]")
    public static MobileElement email;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[2]")
    public static MobileElement password;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    public static MobileElement LoginBtn;

    @AndroidFindBy(accessibility = "1")
    public static MobileElement one;

    @AndroidFindBy(accessibility = "2")
    public static MobileElement two;

    @AndroidFindBy(accessibility = "3")
    public static MobileElement three;

    @AndroidFindBy(accessibility = "4")
    public static MobileElement four;

    @AndroidFindBy(accessibility = "5")
    public static MobileElement five;

    @AndroidFindBy(accessibility = "6")
    public static MobileElement six;

    @AndroidFindBy(accessibility = "Confirm PIN")
    public static MobileElement confirmPINScreenValText;

    @AndroidFindBy(accessibility = "Create PIN")
    public static MobileElement createPINScreenValText;

    @AndroidFindBy(accessibility = "Skip for now")
    public static MobileElement skipNowBtn;

    @AndroidFindBy(accessibility = "Home")
    public static MobileElement homeScreenTextVal;

    @AndroidFindBy(accessibility = "Account")
    public static MobileElement accountBtn;

    @AndroidFindBy(accessibility = "Log out")
    public static MobileElement logout;

    @AndroidFindBy(accessibility = "Log out")
    public static MobileElement alertLogout;

    //@AndroidFindBy(accessibility = "Error The email/password combination is invalid")
    //public static MobileElement emailORPasswordWrongValMsg;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Error The email/password combination is invalid\"]")
    public static MobileElement emailORPasswordWrongValMsg;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.ImageView")
    public static MobileElement backBtnAftercredentialsErrorMsg;

    public LoginElements(AndroidDriver<MobileElement> driver) {
        this.driver = ServiceHooks.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifySplashScreen() throws Exception {
        try {
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_FAIL"));
        }

    }

    public void changeLanguageEnglish() throws Exception {
        try {
            WebDriverWait waitForenglish = new WebDriverWait(ServiceHooks.driver, 30);
            waitForenglish.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ID")));
            changeLang.click();
            WebDriverWait waitForchangeLang = new WebDriverWait(ServiceHooks.driver, 30);
            waitForchangeLang.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("English")));
            english.click();
            Thread.sleep(2000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ChangeLanguage_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ChangeLanguage_FAIL"));

        }

    }

    public void clickonLoginButton() throws Exception {
        try {
            WebDriverWait waitForloginscreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginscreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Terms of Use")));

            String homeScreenFirstText = homeScreenValText.getAttribute("content-desc");
            System.out.println(homeScreenFirstText);
            //Reporter.addStepLog(msg);
            Assert.assertEquals(homeScreenFirstText, "Terms of Use");

            WebDriverWait waitForloginBtnonFirstScreen = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginBtnonFirstScreen .until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login")));
            loginBtnonFirstScreen.click();

            Thread.sleep(2000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_FAIL"));

        }

    }


    public void login(String username, String pwd) throws Exception {
        try {
            WebDriverWait waitForloginscreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginscreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Email")));

            String loginScreenFirstText = loginscreenValText.getAttribute("content-desc");
            System.out.println(loginScreenFirstText);
            //Reporter.addStepLog(msg);
            Assert.assertEquals(loginScreenFirstText, "Email");

            WebDriverWait waitForemailTextBox = new WebDriverWait(ServiceHooks.driver, 30);
            waitForemailTextBox.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[1]")));
            email.click();
            email.clear();
            email.sendKeys(username);

            WebDriverWait waitForPasswordTextBox = new WebDriverWait(ServiceHooks.driver, 30);
            waitForPasswordTextBox.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[2]")));
            password.click();
            password.clear();
            password.sendKeys(pwd);

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreenUserCredentials_PASS"));

            WebDriverWait waitForSubmitBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForSubmitBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@content-desc=\"Login\"]")));
            LoginBtn.click();

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreenUserCredentials_FAIL"));
        }
    }

    public void createAndConfirmPIN() throws Exception {
        try {
            WebDriverWait waitForcreatePINScreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForcreatePINScreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create PIN")));
            String createPIN = createPINScreenValText.getAttribute("content-desc");
            Assert.assertEquals(createPIN, "Create PIN");

            one.click();
            two.click();
            three.click();
            four.click();
            five.click();
            six.click();

            WebDriverWait waitForconfirmPINScreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForconfirmPINScreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Confirm PIN")));
            String confirmPIN = confirmPINScreenValText.getAttribute("content-desc");
            Assert.assertEquals(confirmPIN, "Confirm PIN");

            one.click();
            two.click();
            three.click();
            four.click();
            five.click();
            six.click();

            skipNowBtn.click();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("PIN_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("PIN_FAIL"));

        }

    }

    public boolean verifyHomeScreen() throws Exception {
        try {
            WebDriverWait waitForHomeScreenMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForHomeScreenMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Home")));
            String homeScreenFirstText = homeScreenTextVal.getAttribute("content-desc");
            Assert.assertEquals(homeScreenFirstText, "Home");
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Home_Screen_Loading_PASS"));

            return true;
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Home_Screen_Loading_FAIL"));

        }

        return false;
    }
    public void verifyLoginScreenFieldErrorMessageForInvalidEmailOrPassword() throws Exception {
        try {
            WebDriverWait waitForemailORPasswordWrongValMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForemailORPasswordWrongValMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@content-desc=\"Error The email/password combination is invalid\"]")));
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            backBtnAftercredentialsErrorMsg.click();
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_FAIL"));
        }

    }

    public void  verifyLoginORHomeScreenTextMsgForUserCredentials() throws Exception {
        try {
            WebDriverWait waitForHomeScreenMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForHomeScreenMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Home")));
            String homeScreenFirstText = homeScreenTextVal.getAttribute("content-desc");
            Assert.assertEquals(homeScreenFirstText, "Home");
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginORHome_Screen_Loading_PASS"));

            WebDriverWait waitForaccountBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForaccountBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Account")));
            accountBtn.click();

            WebDriverWait waitForLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            logout.click();

            WebDriverWait waitForalertLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForalertLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            alertLogout.click();

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Loging_Screen_Loading_PASS"));

        } catch (Exception e) {
            e.getStackTrace();

            Thread.sleep(2000);
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Thread.sleep(5000);
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            Thread.sleep(5000);
            backBtnAftercredentialsErrorMsg.click();
        }

    }

    public void verifyLoginScreenFieldErrorMessageWhenWrongEmailOrPassword() throws Exception {
        try {
            Thread.sleep(2000);
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Thread.sleep(5000);
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            Thread.sleep(5000);
            backBtnAftercredentialsErrorMsg.click();
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_FAIL"));
        }

    }

    public void logout() throws Exception {
        try {
            WebDriverWait waitForaccountBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForaccountBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Account")));
            accountBtn.click();

            WebDriverWait waitForLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            logout.click();

            WebDriverWait waitForalertLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForalertLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            alertLogout.click();

            Thread.sleep(1000);

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Logout_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Logout_FAIL"));
        }
    }
}

package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import screens.LoginElements;

public class stepDefLogin {
    private static AndroidDriver<MobileElement> driver;

    public stepDefLogin() {

        this.driver = ServiceHooks.driver;
    }


    public LoginElements getDriver(){
        return new LoginElements(driver);
    }
    @Given("I am on Mobile Store first screen for Login Test Case Execution")
    public void iAmOnApplicationScreen() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.verifySplashScreen();
    }

    @Then("Change Application language as English")
    public void changeApplicationLanguageAsEnglish() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.changeLanguageEnglish();
    }

    @Then("Click on Login Button")
    public void clickOnLoginButton() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.clickonLoginButton();
    }

    @Then("Enter valid username \"([^\"]*)\" and valid Password \"([^\"]*)\"")
    public void enterValidUsernameAndValidPassword(String arg0, String arg1) throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.login(arg0, arg1);
    }

    @When("^Enter invalid username \"([^\"]*)\" and valid Password \"([^\"]*)\"$")
    public void enter_valid_and_valid(String arg1, String arg2) throws Throwable {
        LoginElements loginScreen = getDriver();
        loginScreen.login(arg1, arg2);
    }

    @Then("Enter valid username \"([^\"]*)\" and invalid Password \"([^\"]*)\"")
    public void enterValidUsernameAndInvalidPassword(String arg0, String arg1) throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.login(arg0, arg1);
    }

    @When("Enter Invalid username \"([^\"]*)\" and Invalid Password \"([^\"]*)\"")
    public void enterInvalidAndInvalid(String arg0, String arg1) throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.login(arg0, arg1);
    }

    @Then("I should see validation message on login screen")
    public void iShouldSeeValidationMessageOnHomescreen() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.verifyLoginScreenFieldErrorMessageForInvalidEmailOrPassword();
    }

    @And("validation message should be display on login screen")
    public void validationMessageShouldBeDisplayOnLoginscreenWhileWrongKashtag() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.verifyLoginScreenFieldErrorMessageForInvalidEmailOrPassword();
    }


    @Then("I should see Home screen or validation message on login screen")
    public void iShouldSeeHomescreenOrValidationMessageOnLoginscreen() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.verifyLoginORHomeScreenTextMsgForUserCredentials();
    }

    @And("validation message should appear on login screen while wrong password")
    public void validationMessageShouldAppearOnLoginscreenWhileWrongPassword() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.verifyLoginScreenFieldErrorMessageWhenWrongEmailOrPassword();
    }

    @Then("Create a PIN and Confirm PIN again")
    public void createAPINAndConfirmPINAgain() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.createAndConfirmPIN();
    }

    @And("I should be on Home screen")
    public void iShouldOnHomescreen() throws Exception {
        LoginElements loginScreen = getDriver();
        Assert.assertTrue(loginScreen.verifyHomeScreen());
    }

    @Then("I should be able to logout")
    public void iShouldBeAbleToLogout() throws Exception {
        LoginElements loginScreen = getDriver();
        loginScreen.logout();
    }

}


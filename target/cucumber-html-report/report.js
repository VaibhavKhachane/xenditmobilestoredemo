$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 2,
      "value": "# \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003dTest Case Details\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    },
    {
      "line": 3,
      "value": "# Author: Vaibhav Khachane"
    },
    {
      "line": 4,
      "value": "# TC Name: Login ( Happy and Negative Path )"
    },
    {
      "line": 5,
      "value": "# TC 1: Login  - Create date: 21/09/2021"
    },
    {
      "line": 6,
      "value": "# Total Scenarios"
    },
    {
      "line": 7,
      "value": "# Update History:"
    },
    {
      "line": 8,
      "value": "# \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    }
  ],
  "line": 11,
  "name": "Sign In Functionality",
  "description": "As an user of the Mobile Store\nI want to login to the Application with user credentials\nIn order to use the application features.",
  "id": "sign-in-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 10,
      "name": "@Login"
    }
  ]
});
formatter.before({
  "duration": 79953229522,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 16,
      "value": "# Steps for Launch Mobile Store App"
    }
  ],
  "line": 17,
  "name": "Launch the Mobile Store Application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 18,
  "name": "I am on Mobile Store first screen for Login Test Case Execution",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Change Application language as English",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefLogin.iAmOnApplicationScreen()"
});
formatter.result({
  "duration": 9529910383,
  "status": "passed"
});
formatter.match({
  "location": "stepDefLogin.changeApplicationLanguageAsEnglish()"
});
formatter.result({
  "duration": 21299898289,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 21,
      "value": "# Scenario to validate Login Mobile Store app with valid Username and Password"
    }
  ],
  "line": 23,
  "name": "Login Mobile Store with Valid username and Password",
  "description": "",
  "id": "sign-in-functionality;login-mobile-store-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Click on Login Button",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "Enter valid username \"andri+trial-1@xendit.co\" and valid Password \"Xendit.co!1\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Create a PIN and Confirm PIN again",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "I should be on Home screen",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I should be able to logout",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefLogin.clickOnLoginButton()"
});
formatter.result({
  "duration": 18216656439,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "andri+trial-1@xendit.co",
      "offset": 22
    },
    {
      "val": "Xendit.co!1",
      "offset": 67
    }
  ],
  "location": "stepDefLogin.enterValidUsernameAndValidPassword(String,String)"
});
formatter.result({
  "duration": 28155338943,
  "status": "passed"
});
formatter.match({
  "location": "stepDefLogin.createAPINAndConfirmPINAgain()"
});
formatter.result({
  "duration": 36610075171,
  "status": "passed"
});
formatter.match({
  "location": "stepDefLogin.iShouldOnHomescreen()"
});
formatter.result({
  "duration": 18923233075,
  "status": "passed"
});
formatter.match({
  "location": "stepDefLogin.iShouldBeAbleToLogout()"
});
formatter.result({
  "duration": 10755668254,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 14853984062,
  "status": "passed"
});
});
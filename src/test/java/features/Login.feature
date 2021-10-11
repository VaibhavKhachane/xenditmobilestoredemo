
# =====================================Test Case Details==============================================================================
# Author: Vaibhav Khachane
# TC Name: Login ( Happy and Negative Path )
# TC 1: Login  - Create date: 21/09/2021
# Total Scenarios
# Update History:
# =====================================================================================================================================

@Login
Feature: Sign In Functionality
  As an user of the Mobile Store
  I want to login to the Application with user credentials
  In order to use the application features.

  # Steps for Launch Mobile Store App
  Background: Launch the Mobile Store Application
    Given I am on Mobile Store first screen for Login Test Case Execution
    Then Change Application language as English

  # Scenario to validate Login Mobile Store app with valid Username and Password
  @test
  Scenario: Login Mobile Store with Valid username and Password
    Then Click on Login Button
    Then Enter valid username "andri+trial-1@xendit.co" and valid Password "Xendit.co!1"
    Then Create a PIN and Confirm PIN again
    And  I should be on Home screen
    Then I should be able to logout

  # Scenario to validate Login Mobile Store app with valid Username and Password
  @SanityPositive
  Scenario Outline: Login Mobile Store With Valid username And Password
    Then Click on Login Button
    When Enter valid username "<username>" and valid Password "<password>"
    Then Create a PIN and Confirm PIN again
    And  I should be on Home screen
    Then I should be able to logout

    Examples:
      | username  | password  |
      | vaibhav.khachane@xendit.co | Xendit@11235 |

  # Scenario to validate Login Mobile Store app with invalid Username and valid Password
  @Negative
  Scenario: Login Mobile Store with InValid Username and Valid Password
    Then Click on Login Button
    Then Enter invalid username "andri+trial-1@xendit.com" and valid Password "Xendit.co!1"
    And  validation message should be display on login screen

   # Scenario to validate Login Mobile Store app with valid Username and invalid Password
  @Negative
  Scenario: Login Mobile Store with Valid Username and InValid Password
    Then Click on Login Button
    Then Enter valid username "andri+trial-1@xendit.co" and invalid Password "Xendit.co!2"
    And  validation message should appear on login screen while wrong password

  # Scenario to validate Login Mobile Store app with invalid Username and invalid Password
  @Negative
  Scenario: Login Mobile Store With InValid Username And Password
    Then Click on Login Button
    When Enter Invalid username "andri+trial-1@xendit.com" and Invalid Password "Xendit.co!2"
    Then I should see validation message on login screen

  # Scenario to validate Login Mobile Store app with invalid Username and invalid Password
  @SanityNegative
  Scenario Outline: Login Mobile Store With InValid username And Password
    Then Click on Login Button
    When Enter Invalid username "<username>" and Invalid Password "<password>"
    Then I should see validation message on login screen

    Examples:
      | username   | password  |
      | andri+trial-1@xendit.com | Xendit.co!2 |

  # Scenario to validate Login Mobile Store app with valid and invalid user credentials ( Username and Password )
  @Regression
  Scenario Outline: Login Mobile Store With Valid And Invalid User Credentials ( username and Password )
    Then Click on Login Button
    When Enter Invalid username "<username>" and Invalid Password "<password>"
    Then Create a PIN and Confirm PIN again
    Then I should see Home screen or validation message on login screen

    Examples:
      | username   | password  |
      | andri+trial-1@xendit.co   | Xendit.co!1  |
      | andri+trial-1@xendit.co | Xendit.co!2 |
      | vaibhav.khachane@xendit.co | Xendit@11235 |


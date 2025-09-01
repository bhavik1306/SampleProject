Feature: Operator SignUp Functionality

  Scenario: Successful SignUp
    Given user is on Sign Up page
    When user enters valid Data
      | FirstName | LastName |
      | Shubham   | Mahalle  |
    Then Clicked on sign up button and validate the OTP Validation screen
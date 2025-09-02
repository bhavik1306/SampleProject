Feature: Operator SignUp Functionality

  Scenario: Successful SignUp for Operator
    Given user is on Sign Up page
    When user enters valid Data
      | FirstName | LastName | UserType |
      | Shubham   | Mahalle  | Operator |
    Then Clicked on sign up button and validate the OTP Validation screen


  Scenario: Successful SignUp for Agency
    Given user is on Sign Up page
    When user enters valid Data
      | FirstName | LastName | UserType | CompanyName |
      | Shubham   | Mahalle  | Agency   | TestCompany |
    Then Clicked on sign up button and validate the OTP Validation screen

  Scenario: Successful SignUp for Landlord
    Given user is on Sign Up page
    When user enters valid Data
      | FirstName | LastName | UserType | EntityType            |
      | Shubham   | Mahalle  | Landlord | Real Estate Brokerage |
    Then Clicked on sign up button and validate the OTP Validation screen
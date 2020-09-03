@BDDSTORY-FNFHW-12
Feature: Validating feature file
  Validating Features

  @BDDTEST-FNFHW-13 @BDDVER--1 @BDDCYC-35b221f1-4573-4266-8bb6-f0e7c199dcff
  Scenario: Login Feature validation
    Validate the Login Functionality

    Given I am in login page
    When login with valid credentials
    Then Home page should display

  @BDDTEST-FNFHW-14 @BDDVER--1 @BDDCYC-35b221f1-4573-4266-8bb6-f0e7c199dcff
  Scenario: Home Page Validation
    Validate Home page links

    Given I am in Home page
    When check all the links
    Then Validate all the links should working fine

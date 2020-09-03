@BDDSTORY-FNHW-14
Feature: Login Action

	@BDDTEST-FNHW-15
	@BDDVER--1
	@BDDCYC-f28f3188-d199-447b-9a67-66e79747027d
	Scenario: Successful Login with Valid Credentials
	
		Given I have open the browser
		 When I open website
		And User enters UserName and Password
		 Then Login button should exits

	@BDDTEST-FNHW-16
	@BDDVER--1
	@BDDCYC-f28f3188-d199-447b-9a67-66e79747027d
	Scenario: Successful LogOut
	
		When User LogOut from the Application
		 Then Message displayed LogOut Successfully


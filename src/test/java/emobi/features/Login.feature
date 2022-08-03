@Login
Feature: Login Functionality
  Description: The purpose of this feature is user login
  Scenario: User Should Login Successful With Valid Credentials
    Given User perform login with Valid Credential
    Then Response Status code Login valid equals 200

#  Scenario: User Should Login Unsuccessful With InValid Credentials
#    Given User perform login with InValid Credential
#    Then Response Status code Login InValid equals 400
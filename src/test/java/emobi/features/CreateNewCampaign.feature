@CreateNewCampaign
Feature: Create New Campaign Functionality
  Description: The purpose of this feature is to test the create new campaign in affiliate
  Scenario: Create new campaign for SE country successful with valid credentials
    Given User create new affiliates partner for new campaign with valid credential
    When User create new campaign for country SE with valid
    Then Response status code create new campaign for country SE valid equals 200
    Then Response body create new campaign for country SE valid has param Id is not null

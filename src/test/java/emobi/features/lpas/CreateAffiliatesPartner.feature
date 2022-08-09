@CreateAffiliatePartner
Feature: Create New Affiliate Partner Functionality
  Description: The purpose of this feature is to test the create new affiliate partner in affiliate
  Scenario: Create new affiliates partner for country SE with valid credentials
    Given User create new affiliates partner for country SE with valid
    Then Response status code create new affiliates partner for country SE valid equals 200
    Then Response body create new affiliates for country SE valid has param Id is not null
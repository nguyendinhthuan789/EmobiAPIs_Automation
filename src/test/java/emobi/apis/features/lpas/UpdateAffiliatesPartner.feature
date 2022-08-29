@UpdateAffiliatePartner
Feature: Update Affiliate Partner Functionality
  Description: The purpose of this feature is to test the update affiliate partner in affiliate
  Scenario: Update affiliates partner for country SE with valid credentials
    Given User create new affiliates partner for update affiliates partner with valid credential
    When User update name affiliates partner for country SE with valid
    And User update payout amount affiliates partner for country SE with valid
    Then Response status code update affiliates for country SE valid equals 200
    Then Response body with id of country SE
    Then Response body update name successful for country SE
    Then Response body update payout amount successful for country SE
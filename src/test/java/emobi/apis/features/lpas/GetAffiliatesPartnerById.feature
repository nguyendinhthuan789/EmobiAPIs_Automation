@GetAffiliatesPartnerById
Feature: Get Affiliates Partner By Id Functionality
  Description: The purpose of this feature is get affiliates partner by id
  Scenario: Get affiliates partner by id with valid credentials
    Given User create new affiliates partner after that get affiliates by id with valid credential
    When Get affiliates partner by id with id valid credential
    Then Response status code get affiliates partner by id valid is equals 200
@Mobwizard_PinVerify
Feature: Pin verify Mobwizard flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin verify Mobwizard flow MSISDN + PIN

  Scenario: User GET pin verify affiliates partner Mobwizard flow MSISDN + PIN of RS Country successful with valid credentials
    Given User call the API pin verify of Mobwizard flow msisdn pin with valid credential
    | campaignID  | tpClickId | pinId |  pinValue |
    | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b301065041111 |  sYhM3076631618314366  |  abc |
    Then Response successful status code is 200 after pin verify of Mobwizard flow msisdn pin
    Then Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin
    | message | status |  verify_status |
    | Success | true   |  VERIFIED      |
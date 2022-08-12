@Mobwizard_PinVerify
Feature: Pin verify Mobwizard flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin verify Mobwizard flow MSISDN + PIN

  Scenario: User GET pin verify affiliates partner Mobwizard flow MSISDN + PIN of RS Country successful with valid credentials
    Given User call the API pin verify of Mobwizard flow msisdn pin with valid credential
      | campaignID                            | tpClickId                 | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 200 after pin verify of Mobwizard flow msisdn pin
    Then Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin
      | message | status | verify_status |
      | Success | true   | VERIFIED      |

  Scenario: User GET pin verify affiliates partner Mobwizard flow MSISDN + PIN of RS Country unsuccessful with pin invalid credentials
    Given User call the API pin verify of Mobwizard flow msisdn pin with pin invalid credential
      | campaignID                            | tpClickId                 | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 | 1111     |
    Then Response successful status code is 500 after pin verify of Mobwizard flow msisdn pin with pin invalid
    Then Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin with pin invalid
      | message     | status | verify_status |
      | Pin invalid | false  | FAILED        |

  Scenario: User GET pin verify affiliates partner Mobwizard flow MSISDN + PIN of RS Country unsuccessful with pin invalid mandatory credentials
    Given User call the API pin verify of Mobwizard flow msisdn pin with pin invalid mandatory credential
      | campaignID                            | tpClickId | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 |           | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 400 after pin verify of Mobwizard flow msisdn pin with pin invalid mandatory
    Then Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin with pin invalid mandatory
      | message                  | status | verify_status |
      | Invalid mandatory fields | false  | FAILED        |
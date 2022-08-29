@Partner_API @PinVerify_RS
Feature: Pin verify flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin verify flow MSISDN + PIN

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country successful with valid credentials
    Given User call the API pin verify of flow msisdn pin with valid credential
      | campaignID                            | tpClickId                 | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 200 after pin verify of flow msisdn pin
    Then Response successful message status and verify status after pin verify of flow msisdn pin
      | message | status | verify_status |
      | Success | true   | VERIFIED      |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with pin invalid credentials
    Given User call the API pin verify of flow msisdn pin with pin invalid credential
      | campaignID                            | tpClickId                 | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 | 1111     |
    Then Response successful status code is 500 after pin verify of flow msisdn pin with pin invalid
    Then Response successful message status and verify status after pin verify of flow msisdn pin with pin invalid
      | message     | status | verify_status |
      | Pin invalid | false  | FAILED        |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with null tpClickId
    Given User call the API pin verify of flow msisdn pin with null tpClickId
      | campaignID                            | tpClickId | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 |           | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 400 after pin verify of flow msisdn pin with null tpClickId
    Then Response successful message status and verify status after pin verify of flow msisdn pin with null tpClickId
      | message                  | status |
      | Invalid mandatory fields | false  |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with invalid tpClickId
    Given User call the API pin verify of flow msisdn pin with invalid tpClickId
      | campaignID                            | tpClickId        | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | invalidtpClickId | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 400 after pin verify of flow msisdn pin with invalid tpClickId
    Then Response successful message status and verify status after pin verify of flow msisdn pin with invalid tpClickId
      | message           | status |
      | Invalid tpClickId | false  |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with invalid campaign
    Given User call the API pin verify of flow msisdn pin with invalid campaign
      | campaignID      | tpClickIdtpClickId        | pinId                | pinValue |
      | invalidCampaign | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 | 3333     |
    Then Response successful status code is 400 after pin verify of flow msisdn pin with invalid campaign
    Then Response successful message status and verify status after pin verify of flow msisdn pin with invalid campaign
      | message          | status |
      | Invalid campaign | false  |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with null pinId
    Given User call the API pin verify of flow msisdn pin with null pinId
      | campaignID                            | tpClickId                 | pinId | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 |       | 3333     |
    Then Response successful status code is 400 after pin verify of flow msisdn pin with null pinId
    Then Response successful message status and verify status after pin verify of flow msisdn pin with null pinId
      | message                  | status |
      | Invalid mandatory fields | false  |

  Scenario: User GET pin verify flow MSISDN + PIN of RS Country unsuccessful with null pinValue
    Given User call the API pin verify of flow msisdn pin with null pinValue
      | campaignID                            | tpClickId                 | pinId                | pinValue |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b3010650413dg2pg1 | sYhM3076631618314366 |          |
    Then Response successful status code is 400 after pin verify of flow msisdn pin with null pinValue
    Then Response successful message status and verify status after pin verify of flow msisdn pin with null pinValue
      | message                  | status |
      | Invalid mandatory fields | false  |
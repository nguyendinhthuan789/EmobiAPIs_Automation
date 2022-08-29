@Partner_API @PinRequest_RS
Feature: Pin request flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin request flow MSISDN + PIN

  Scenario: User GET pin request flow MSISDN + PIN of RS Country successful with valid credentials
    Given User call the API pin request of flow msisdn pin with valid credential
      | campaignID                            | tpClickId             | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b301065041111 | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html |
    Then Response successful status code is 200 after pin request of flow msisdn pin
    Then Response successful message status subscriptionStatus and pinid not null after pin request of flow msisdn pin
      | message | status | subscriptionStatus |
      | Success | true   | NEW                |

  Scenario: User GET pin request flow MSISDN + PIN of RS Country unsuccessful with invalid campaign credentials
    Given User call the API pin request of flow msisdn pin with invalid campaign credential
      | campaignID | tpClickId             | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               |
      | invalid    | 5g043028b301065041111 | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html |
    Then Response successful status code is 400 after pin request of flow msisdn pin with invalid campaign
    Then Response successful message status and data null after pin request of flow msisdn pin with invalid campaign
      | message          | status |
      | Invalid campaign | false  |

  Scenario: User GET pin request flow MSISDN + PIN of RS Country unsuccessful with null tpClickId
    Given User call the API pin request of flow msisdn pin with null tpClickId
      | campaignID                            | tpClickId | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 |           | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html |
    Then Response successful status code is 400 after pin request of flow msisdn pin with null tpClickId
    Then Response successful message status and data null after pin request of flow msisdn pin with null tpClickId
      | message                  | status |
      | Invalid mandatory fields | false  |

  Scenario: User GET pin request flow MSISDN + PIN of RS Country unsuccessful with invalid msisdn
    Given User call the API pin request of flow msisdn pin with invalid msisdn
      | campaignID                            | tpClickId             | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b301065041111 | 093388888888 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html |
    Then Response successful status code is 500 after pin request of flow msisdn pin with invalid msisdn
    Then Response successful message status and data null after pin request of flow msisdn pin with invalid msisdn
      | message                    | status | subscriptionStatus |
      | Opportunity user not found | false  | FAILED             |

  Scenario: User GET pin request flow MSISDN + PIN of RS Country unsuccessful with null userAgent
    Given User call the API pin request of flow msisdn pin with null userAgent
      | campaignID                            | tpClickId             | msisdn       | userAgent | ip            | portalDomain                               |
      | 3525c3c2d-79ba-4e5c-9b82-74861aba0a30 | 5g043028b301065041111 | 093311111111 |           | 129.20.20.100 | https://mobwizard_sample_landing_page.html |
    Then Response successful status code is 400 after pin request of flow msisdn pin with null userAgent
    Then Response successful message status and data null after pin request of flow msisdn pin with null userAgent
      | message                  | status |
      | Invalid mandatory fields | false  |
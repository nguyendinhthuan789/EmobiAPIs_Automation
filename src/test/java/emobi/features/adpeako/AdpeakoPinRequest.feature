@Adpeako_PinRequest
Feature: Pin request Adpeako flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin request Adpeako flow MSISDN + PIN

  Scenario: User GET pin request affiliates partner Adpeako flow MSISDN + PIN of CA Country successful with valid credentials
    Given User call the API pin request of Adpeako flow msisdn pin with valid credential
      | campaignID                           | tpClickId | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               | lang |
      | 98e95c3f-d391-46c0-a872-14f596470f21 |           | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html | FR   |
    Then Response successful status code is 200 after pin request of Adpeako flow msisdn pin
    Then Response successful message status subscriptionStatus and pinid not null after pin request of Adpeako flow msisdn pin
      | message | status | subscriptionStatus |
      | Success | true   | NEW                |

  Scenario: User GET pin request affiliates partner Adpeako flow MSISDN + PIN of CA Country unsuccessful with invalid campaign credentials
    Given User call the API pin request of Adpeako flow msisdn pin with invalid campaign credential
      | campaignID | tpClickId | msisdn       | userAgent                                                                                                                                                     | ip            | portalDomain                               | lang |
      | invalid    |           | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html | EN   |
    Then Response successful status code is 400 after pin request of Adpeako flow msisdn pin with invalid campaign
    Then Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid campaign
      | message          | status |
      | Invalid campaign | false  |

  Scenario: User GET pin request affiliates partner Mobwizard flow MSISDN + PIN of CA Country unsuccessful with invalid mandatory credentials
    Given User call the API pin request of Adpeako flow msisdn pin with invalid mandatory credential
      | campaignID                           | tpClickId | msisdn | userAgent                                                                                                                                                     | ip            | portalDomain                               | lang |
      | 98e95c3f-d391-46c0-a872-14f596470f21 |           |        | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://mobwizard_sample_landing_page.html | FR   |
    Then Response successful status code is 400 after pin request of Adpeako flow msisdn pin with invalid mandatory
    Then Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid mandatory
      | message                  | status |
      | Invalid mandatory fields | false  |
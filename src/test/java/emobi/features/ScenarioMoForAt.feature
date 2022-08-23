@Mo_AT
Feature: Tracking request flow type MSISDN + MO Functionality
  Description: The purpose of this feature is tracking request flow MSISDN + MO

  Scenario: User GET tracking request flow MSISDN + MO of AT country successful with valid credentials
    Given User call the API tracking request of flow msisdn mo with valid credential
      | campaignID                           | tpClickId | msisdn          | userAgent                                                                                                                                                         | ip            | portalDomain                              |
      | a9aa85be-965f-4b09-937b-caf13ea51e49 |           | 004361111111111 | Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://moviplus_sample_landing_page.html |
    Then Response successful status code is 200 after tracking request of flow msisdn mo
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of flow msisdn mo
      | message | status | subscriptionStatus | keyword | shortcode |
      | Success | true   | NEW                | OK      | 145451    |

  Scenario: User GET tracking request flow MSISDN + MO of AT country successful with invalid mandatory credentials
    Given User call the API tracking request of flow msisdn mo with invalid mandatory credentials
      | campaignID                           | tpClickId | msisdn | userAgent                                                                                                                                                         | ip            | portalDomain                              |
      | a9aa85be-965f-4b09-937b-caf13ea51e49 |           |        | Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://moviplus_sample_landing_page.html |
    Then Response successful status code is 400 after tracking request of flow msisdn mo invalid mandatory credentials
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of flow msisdn mo invalid mandatory credentials
      | message                  | status |
      | Invalid mandatory fields | false  |
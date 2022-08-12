@Adpeako_Msisdn_Mo
Feature: Tracking request Adpeako flow type MSISDN + MO Functionality
  Description: The purpose of this feature is tracking request Adpeako flow MSISDN + MO

  Scenario: User GET tracking request affiliates partner Adpeako flow MSISDN + MO of BA country successful with valid credentials
    Given User call the API tracking request of Adpeako flow msisdn mo with valid credential
      | campaignID                           | tpClickId | msisdn       | userAgent                                                                                                                                                         | ip            | portalDomain                              | operator  |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           | 093311111111 | Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://moviplus_sample_landing_page.html | bhtelecom |
    Then Response successful status code is 200 after tracking request of Adpeako flow msisdn mo
    Then Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo
      | message | status | subscriptionStatus | keyword | shortcode |
      | Success | true   | NEW                | DA      | 06202020  |

  Scenario: User GET tracking request affiliates partner Adpeako flow MSISDN + MO of BA country unsuccessful with invalid mandatory credentials
    Given User call the API tracking request of Adpeako flow msisdn mo with invalid mandatory
      | campaignID                           | tpClickId | msisdn | userAgent                                                                                                                                                         | ip            | portalDomain                              | operator  |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           |        | Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://moviplus_sample_landing_page.html | bhtelecom |
    Then Response successful status code is 400 after tracking request of Adpeako flow msisdn mo with invalid mandatory
    Then Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo with invalid mandatory
      | message                  | status |
      | Invalid mandatory fields | false  |
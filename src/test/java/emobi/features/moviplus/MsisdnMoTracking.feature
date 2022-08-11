@Moviplus_Msisdn_Mo
Feature: Tracking request Moviplus flow type MSISDN + MO Functionality
  Description: The purpose of this feature is tracking request Moviplus flow MSISDN + MO

  Scenario: User GET tracking request affiliates partner Moviplus flow MSISDN + MO of AT country successful with valid credentials
    Given User call the API tracking request of Moviplus flow msisdn mo with valid credential
    | campaignID  | tpClickId | msisdn |  userAgent | ip | portalDomain |
    | 32c3d2d1-7a89-4b91-83cc-89f123493889 |  | 004312345678910 |  Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | https://moviplus_sample_landing_page.html |
    Then Response successful status code is 100 after tracking request of Moviplus flow msisdn mo
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow msisdn mo
    | resultCode | resultText |
    | Success |   OK          |
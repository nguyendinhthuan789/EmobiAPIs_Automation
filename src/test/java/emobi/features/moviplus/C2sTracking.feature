@Moviplus_C2s
Feature: Tracking request Moviplus flow type C2S Functionality
  Description: The purpose of this feature is tracking request Moviplus flow C2S

  Scenario: User GET tracking request affiliates partner Moviplus flow C2S of BG-Playzone successful with valid credentials
    Given User call the API tracking request of Moviplus flow C2S with valid credential
    | campaignID  | tp_click_id | userAgent |
    | 32c3d2d1-7a89-4b91-83cc-89f123493889 | 5g043028b3ze1 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 |
    Then Response successful status code is 200 after tracking request of Moviplus flow C2S
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow C2S
    | message | status |  keyword | shortcode |
    | Success | true   |  OK      | 063770100 |
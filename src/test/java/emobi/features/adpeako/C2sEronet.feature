@Adpeako_C2sEronet
Feature: Tracking request Adpeako flow type C2S Functionality
  Description: The purpose of this feature is tracking request Adpeako flow C2S

  Scenario: User GET tracking request Adpeako flow C2S Eronet successful with valid credentials
    Given User call the API tracking request Eronet of Adpeako flow C2S with valid credential
    | campaignID  | tpClickId | userAgent | operator  |
    | 7e5cffca-c60c-48e8-bf8c-aca1fab5e42a | 112wwbbb2 | Mozilla%2F5.0%20(Macin tosh%3B%20Intel%20Ma c%20OS%20X%2010_15_7)%20AppleWebKit%2F 537.36%20(KHTML%2C%20like%20Gecko)%20C hrome%2F91.0.4472.101%20Safari%2F537.36 | eronet |
#    Then Response successful status code is 200 after tracking request Eronet of Adpeako flow C2S
#    Then Response successful message is <message> status is <status> keyword is <keyword> shortcode is <shortcode> after tracking request Eronet of Adpeako flow C2S
    | message | status |  keyword | shortcode |
    | success | true   |  OK      | 063770100 |
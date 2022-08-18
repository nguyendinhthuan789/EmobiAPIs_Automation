@Moviplus_PinRequest
Feature: Pin request Moviplus flow type MSISDN + PIN Functionality
  Description: The purpose of this feature is pin request Moviplus flow MSISDN + PIN

  Scenario: User GET pin request affiliates partner Moviplus flow MSISDN + PIN of AE Country successful with valid credentials
    Given User call the API pin request of Moviplus flow msisdn pin with valid credential
      | campaignID                           | tpClickId | msisdn       | userAgent                                                                                                                                                     | ipAddress     | operator |
      | 98e95c3f-d391-46c0-a872-14f596470f21 |           | 093311111111 | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | 129.20.20.100 | ooredoo  |
    Then Response successful status code is 200 after pin request of Moviplus flow msisdn pin
    Then Response successful message status subscriptionStatus and pinid not null after pin request of Moviplus flow msisdn pin
      | message | status |
      | Success | true   |
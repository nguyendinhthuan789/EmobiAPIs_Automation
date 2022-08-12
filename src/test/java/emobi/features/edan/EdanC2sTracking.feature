@Edgar_Zakaryan_C2s
Feature: Tracking request Edgar Zakaryan flow type C2S Functionality
  Description: The purpose of this feature is tracking request Edgar Zakaryan flow C2S

  Scenario: User GET tracking request affiliates partner Edgar Zakaryan flow C2S of BA - Eronet successful with valid credentials
    Given User call the API tracking request of Edgar Zakaryan flow C2S ba eronet with valid credential
      | campaignID                           | tp_click_id | userAgent                                                                                                                                                     | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |             | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | eronet   |
    Then Response successful status code is 200 after tracking request of Edgar Zakaryan flow C2S ba eronet
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of Edgar Zakaryan flow C2S ba eronet
      | message | status | keyword | shortcode |
      | Success | true   | OK      | 063770100 |

  Scenario: User GET tracking request affiliates partner Edgar Zakaryan flow C2S of BA - Mtel successful with valid credentials
    Given User call the API tracking request of Edgar Zakaryan flow C2S ba mtel with valid credential
      | campaignID                           | tp_click_id | userAgent                                                                                                                                                     | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |             | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | mtel     |
    Then Response successful status code is 200 after tracking request of Edgar Zakaryan flow C2S ba mtel
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of Edgar Zakaryan flow C2S ba mtel
      | message | status | keyword | shortcode |
      | Success | true   | OK      | 0651388   |
@Partner_API @C2s_BA
Feature: Tracking request flow type C2S Functionality
  Description: The purpose of this feature is tracking request flow C2S

  Scenario: User GET tracking request flow C2S of BA - Eronet successful with valid credentials
    Given User call the API tracking request of flow C2S ba eronet with valid credential
      | campaignID                           | tpClickId | userAgent                                                                                                                                                     | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | eronet   |
    Then Response successful status code is 200 after tracking request of flow C2S ba eronet
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba eronet
      | message | status | keyword | shortcode |
      | Success | true   | OK      | 063770100 |

  Scenario: User GET tracking request affiliates flow C2S of BA - Mtel successful with valid credentials
    Given User call the API tracking request of flow C2S ba mtel with valid credential
      | campaignID                           | tpClickId | userAgent                                                                                                                                                     | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | mtel     |
    Then Response successful status code is 200 after tracking request of flow C2S ba mtel
    Then Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba mtel
      | message | status | keyword | shortcode |
      | Success | true   | OK      | 0651388   |

  Scenario: User GET tracking request affiliates flow C2S unsuccessful with null tpClickId
    Given User call the API tracking request of flow C2S with null tpClickId
      | campaignID                           | tpClickId | userAgent                                                                                                                                                     | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | mtel     |
    Then Response successful status code is 400 after tracking request of flow C2S with null tpClickId
    Then Response message successful after tracking request of flow with null tpClickId
      | message                  | status |
      | Invalid mandatory fields | false  |

  Scenario: User GET tracking request affiliates flow C2S unsuccessful with null userAgent
    Given User call the API tracking request of flow C2S with null userAgent
      | campaignID                           | tpClickId | userAgent | operator |
      | df8c1c50-1806-4b82-8701-aaa2175df3c0 |           |           | eronet   |
    Then Response successful status code is 400 after tracking request of flow C2S with null userAgent
    Then Response message successful after tracking request of flow with null userAgent
      | message                              | status |
      | Invalid mandatory fields [userAgent] | false  |

  Scenario: User GET tracking request affiliates flow C2S unsuccessful with invalid campaign
    Given User call the API tracking request of flow C2S with invalid campaign
      | campaignID      | tpClickId | userAgent                                                                                                                                                     | operator |
      | invalidCampaign |           | Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36 | mtel     |
    Then Response successful status code is 400 after tracking request of flow C2S with invalid campaign
    Then Response message successful after tracking request of flow with invalid campaign
      | message          | status |
      | Invalid campaign | false  |
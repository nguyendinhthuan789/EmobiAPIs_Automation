package emobi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/features"},
        plugin = {"pretty", "html:target/report/cucumber.html", "emobi.steps.Hooks", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
//        tags = "@C2s_BA",
        tags = "@C2s_BA or @Mo_AT or @PinRequest_RS or @PinVerify_RS",
//        tags = "@CreateAffiliatePartner or @CreateNewCampaign or @GetAffiliatesPartnerById or @UpdateAffiliatePartner",
        monochrome = true
)
public class CucumberTests {
}
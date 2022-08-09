package emobi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/features"},
        plugin = {"pretty", "html:target/report/cucumber.html"},
        //tags = "@Mobwizard_PinVerify",
        //tags = "@CreateAffiliatePartner or @CreateNewCampaign or @GetAffiliatesPartnerById or @UpdateAffiliatePartner or @Mobwizard_C2s or @Mobwizard_PinRequest or @Mobwizard_PinVerify or @Moviplus_C2s",
        glue = {"emobi.steps"},
        monochrome = true
)
public class CucumberTests {
}
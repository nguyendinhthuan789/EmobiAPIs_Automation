package emobi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/features"},
        plugin = {"pretty", "html:target/report/cucumber.html","emobi.steps.CucumberHooks"},
        tags = "@Mobwizard_C2s",
        //tags = "@CreateAffiliatePartner or @CreateNewCampaign or @GetAffiliatesPartnerById or @UpdateAffiliatePartner",
        //tags = "@Mobwizard_C2s or @Mobwizard_PinRequest or @Mobwizard_PinVerify or @Moviplus_C2s or @Edgar_Zakaryan_C2s or @Adpeako_C2s ",
        glue = {"emobi.steps"},
        monochrome = true
)
public class CucumberTests {
}
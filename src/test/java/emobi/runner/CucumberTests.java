package emobi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/features"},
        plugin = {"pretty", "html:target/report/cucumber.html"},
        tags = "@Login or @CreateAffiliatePartner or @CreateNewCampaign or @GetAffiliatesPartnerById",
        glue = {"emobi.steps"},
        monochrome = true
)
public class CucumberTests {
}
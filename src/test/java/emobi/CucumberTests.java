package emobi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/features"},
        plugin = {"pretty", "html:target/report/cucumber.html", "emobi.steps.Hooks", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
//        tags = "@Mobwizard_C2s",
//        tags = "@CreateAffiliatePartner or @CreateNewCampaign or @GetAffiliatesPartnerById or @UpdateAffiliatePartner",
        tags = "@Mobwizard_C2s or @Mobwizard_PinRequest or @Mobwizard_PinVerify or @Moviplus_C2s or @Moviplus_Msisdn_Mo or @Edgar_Zakaryan_C2s or @Adpeako_C2s or @Adpeako_PinRequest or @Adpeako_PinVerify or @Adpeako_Msisdn_Mo",
        glue = {"emobi.steps"},
        monochrome = true
)
public class CucumberTests {
}
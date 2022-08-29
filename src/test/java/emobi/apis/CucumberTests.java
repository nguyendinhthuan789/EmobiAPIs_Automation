package emobi.apis;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/emobi/apis/features"},
        plugin = {"pretty", "html:target/report/cucumber.html", "emobi.apis.steps.Hooks", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        //tags = "@C2s_BA or @Mo_AT or @PinRequest_RS or @PinVerify_RS",
        tags = "@Partner_API",
        monochrome = true
)
public class CucumberTests {
}
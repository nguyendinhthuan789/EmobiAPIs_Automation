package emobi.steps;

import emobi.constants.Constants;
import emobi.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static emobi.rest.RestRequest.curl;

public class Hooks implements ConcurrentEventListener {
    private static Logger log = LoggerFactory.getLogger(Hooks.class);
    private final Utils utils = new Utils();
    private final String allurePath = System.getProperty(Constants.USER_DIR_PROPERTY) + "/target/allure-results";
    private final String enviromentPropertiesPath = allurePath + "/environment.properties";

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        eventPublisher.registerHandlerFor(TestRunFinished.class, afterAll);
        eventPublisher.registerHandlerFor(TestStepStarted.class, beforeStep);
        eventPublisher.registerHandlerFor(TestStepFinished.class, afterStep);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, beforeTestcase);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, afterTestcase);
    }

    private EventHandler<TestRunStarted> beforeAll = event -> {
        log.info("------------START TESTING-------------");
        utils.deleteFolder(allurePath);
    };

    private EventHandler<TestRunFinished> afterAll = event -> {
        Utils.createEnvironmentProperties(enviromentPropertiesPath);
        log.info("------------END TESTING-------------");
    };

    private EventHandler<TestStepStarted> beforeStep = event -> {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            final PickleStepTestStep ev = (PickleStepTestStep) event.getTestStep();
            String testDescription = ev.getStep().getText();
            log.info("\nSTEP: " + testDescription);
        }
    };

    private EventHandler<TestStepFinished> afterStep = event -> {
        //log.info("------------END TESTING-------------");
    };

    private EventHandler<TestCaseStarted> beforeTestcase = event -> {
        log.info("------------Start Scenario-------------");
        log.info("\nSCENARIO NAME: " + event.getTestCase().getName());
    };

    private EventHandler<TestCaseFinished> afterTestcase = event -> {
        log.info("------------End Scenario-------------");
    };

    @Before
    public void setBeforeTestcase(){
        log.info("------------Start Suite-------------");
    }

    @After
    public void setAfterTestcase(){
        log.info("------------After Suite-------------");
        Allure.addAttachment("Curl command: ", curl);
    }
}
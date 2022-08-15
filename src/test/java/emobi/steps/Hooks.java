package emobi.steps;

import emobi.constants.ConstCommon;
import emobi.utilities.Utils;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks implements ConcurrentEventListener {
    Logger log = LoggerFactory.getLogger(Hooks.class);
    private Utils utils=new Utils();
    private String allurePath = System.getProperty(ConstCommon.USER_DIR_PROPERTY) + "/target/allure-results";

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        eventPublisher.registerHandlerFor(TestRunFinished.class, afterAll);
        eventPublisher.registerHandlerFor(TestStepStarted.class, beforeStep);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, beforeTestcase);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, afterTestcase);
    }

    private EventHandler<TestRunStarted> beforeAll = event -> {
        log.info("------------START TESTING-------------");
        utils.deleteFolder(allurePath);
    };

    private EventHandler<TestRunFinished> afterAll = event -> {
        log.info("------------END TESTING-------------");
    };

    private EventHandler<TestStepStarted> beforeStep = event -> {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            final PickleStepTestStep ev = (PickleStepTestStep) event.getTestStep();
            String testDescription = ev.getStep().getText();
            log.info("\nSTEP: " + testDescription);
        }
    };

    private EventHandler<TestCaseStarted> beforeTestcase = event -> {
        log.info("------------Start Scenario-------------");
        log.info("\nSCENARIO NAME: " + event.getTestCase().getName());
    };

    private EventHandler<TestCaseFinished> afterTestcase = event -> {
        log.info("------------End Scenario-------------");
    };
}
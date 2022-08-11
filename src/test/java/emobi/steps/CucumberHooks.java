package emobi.steps;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberHooks implements ConcurrentEventListener {
    Scenario scenario;
    Logger log = LoggerFactory.getLogger(CucumberHooks.class);

    public CucumberHooks() {
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, beforeAll);
        eventPublisher.registerHandlerFor(TestRunFinished.class, afterAll);
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::handleTestScenarioStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, afterTestcase);
    }

    private EventHandler<TestRunStarted> beforeAll = event -> {
        log.info("------------BEGINNING-------------");
    };

    private EventHandler<TestRunFinished> afterAll = event -> {
        //System.out.println("22222222222222222222");

    };

    private EventHandler<TestStepStarted> beforeStep = event -> {
        //System.out.println("33333333333333333");
    };

    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            final PickleStepTestStep ev = (PickleStepTestStep) event.getTestStep();
            String testDescription = ev.getStep().getText();
            log.info("\nSTEP: " + testDescription);
        }
    }

    private EventHandler<TestCaseStarted> beforeTestcase = event -> {
        log.info("------------Start Scenario-------------");
        //log.info("------------Start Scenario-------------");
    };

    private void handleTestScenarioStarted(TestCaseStarted scenario) {
        log.info("------------Start Scenario-------------");
    }

    private EventHandler<TestCaseFinished> afterTestcase = event -> {
        //log.info("------------End Scenario: " + scenario.getName() + " -------------");
        log.info("------------End Scenario-------------");
//        PrintWriter myWriter = null;
//        try {
//            FileOutputStream write = new FileOutputStream(System.getProperty("user.dir") + config.getDataFile(), false);
//            myWriter = new PrintWriter(write);
//            myWriter.write(saveRest);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        } finally {
//            myWriter.flush();
//            myWriter.close();
//        }
    };
}
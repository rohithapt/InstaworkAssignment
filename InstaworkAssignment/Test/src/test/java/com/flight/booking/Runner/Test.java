package com.flight.booking.Runner;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features="Features",
        glue={"src.test.java.com.flight.booking.StepDef"},
        format={"pretty","html:reports/test-report"},
        tags= "@FlightTest"
)
public class Test {

}

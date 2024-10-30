package co.incubyte.assessment;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void handleEmptyString() {
        assert calculator.add("") == 0;
    }

    @Test
    public void handleCommaSeparatedNumbers() {
        assert calculator.add("2, 3, 5,     10") == 20;
    }
}

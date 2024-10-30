package co.incubyte.assessment;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void emptyString() {
        assert calculator.add("") == 0;
    }
}

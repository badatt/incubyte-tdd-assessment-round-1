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

    @Test
    public void handleCommaAndNewlineSeparatedNumbers() {
        assert calculator.add("2, 3, 5,     10\n6    \n 7  \n 3, 4\n2,  8\n    9,1") == 60;
    }
}

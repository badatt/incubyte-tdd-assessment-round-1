package co.incubyte.assessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void handleEmptyString() throws Exception {
        assert calculator.add("") == 0;
    }

    @Test
    public void handleCommaSeparatedNumbers() throws Exception {
        assert calculator.add("2, 3, 5,     10") == 20;
    }

    @Test
    public void handleCommaAndNewlineSeparatedNumbers() throws Exception {
        assert calculator.add("2, 3, 5,     10\n6    \n 7  \n 3, 4\n2,  8\n    9,1") == 60;
    }

    @Test
    public void handleCustomDelimiterAndNewlineSeparatedNumbers() throws Exception {
        String input = "\\\\;\n2; 3; 5;     10\n6    \n 7  \n 3; 4\n2;  8\n    9;1";
        assert calculator.add(input) == 60;
    }

    @Test
    public void handleCustomDelimiterAndNewlineSeparatedNumbersWithNegativeNumbers() {
        Exception ex = Assertions.assertThrows(Exception.class, () -> calculator.add("\\\\;\n2; 3; 5;     10\n6    \n -7  \n -3; 4\n-2;  -8\n    -9;1"));
        assert Objects.equals(ex.getMessage(), "negative numbers not allowed -7,-3,-2,-8,-9");
    }

    @Test
    public void handleCommaAndNewlineSeparatedNumbersWithNegativeNumbers() {
        Exception ex = Assertions.assertThrows(Exception.class, () -> calculator.add("2, 3, 5,     -10\n6    \n 7  \n -3, 4\n2,  8\n    9,1"));
        assert Objects.equals(ex.getMessage(), "negative numbers not allowed -10,-3");
    }
}

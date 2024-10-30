package co.incubyte.assessment;

import java.util.Arrays;
import java.util.Optional;

public class Calculator {

    public int add(String numbers) {
        if(numbers.isEmpty() || numbers.isBlank()) {
            return 0;
        }
        Optional<Integer> sum = Arrays.stream(numbers.split("[\\n,]"))
                .map(s -> Integer.parseInt(s.trim()))
                .reduce(Integer::sum);
        return sum.orElse(0);
    }
}

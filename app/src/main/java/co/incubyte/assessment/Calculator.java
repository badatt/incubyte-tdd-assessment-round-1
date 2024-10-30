package co.incubyte.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private final String pattern = "^\\\\\\\\(\\S)\n";

    public int add(String numbers) throws Exception {
        if(numbers.isEmpty() || numbers.isBlank()) {
            return 0;
        }
        return calculateSum(sanitizeInput(numbers), findDelimiterIfExists(numbers));
    }

    private String findDelimiterIfExists(String numbers) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(numbers);
        if(m.find())
            return m.group(1);
        return ",";
    }

    private String sanitizeInput(String numbers) {
        return numbers.replaceAll(pattern, "");
    }

    private int calculateSum(String numbers, String delimiter) throws Exception {
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        Arrays.stream(numbers.split("[\\n" + delimiter + "]"))
                .map(String::trim)
                .forEach(s -> {
                    Integer n = Integer.parseInt(s);
                    if(n > 0)
                        positiveNumbers.add(n);
                    else
                        negativeNumbers.add(n);
                });
        if(!negativeNumbers.isEmpty())
            throw new Exception("negative numbers not allowed " + negativeNumbers.stream().map(Object::toString).collect(Collectors.joining(",")));
        Optional<Integer> sum = positiveNumbers.stream().reduce(Integer::sum);
        return sum.orElse(0);
    }
}

package org.dojo.calculator;

public class StringCalculator {


    public int add(String s) {
        if("".equals(s)){
            return 0;
        }
        String[] numbers = s.split(",|\n");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}

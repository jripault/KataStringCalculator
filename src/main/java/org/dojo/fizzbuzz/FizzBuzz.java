package org.dojo.fizzbuzz;

/**
 * User: Samil
 * Date: 04/01/2016
 */
public class FizzBuzz {
    public String write(Integer i) {
        String number = "";
        if(i == 0){
            return "0";
        }
        if(i % 3 == 0 || i.toString().contains("3")) {
            number += "Fizz";
        }
        if(i % 5 == 0 || i.toString().contains("5")) {
            number += " Buzz";
        }

        if("".equals(number)){
            number = i.toString();
        }
        return number.trim();
    }
}

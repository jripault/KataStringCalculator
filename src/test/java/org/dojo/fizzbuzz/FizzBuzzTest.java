package org.dojo.fizzbuzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * User: Samil
 * Date: 04/01/2016
 */
public class FizzBuzzTest {
    @Test
    public void shouldReturnFizz() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(3);

        // Then
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void shouldNotReturnFizz() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(1);

        // Then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void shouldReturnZero() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(0);

        // Then
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void shouldReturnBuzz() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(5);

        // Then
        assertThat(result).isEqualTo("Buzz");
    }
    @Test
    public void shouldReturnFizzBecauseThreeInIt() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(32);

        // Then
        assertThat(result).isEqualTo("Fizz");
    }
    @Test
    public void shouldReturnFizzBecauseFiveInIt() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(52);

        // Then
        assertThat(result).isEqualTo("Buzz");
    }
    @Test
    public void shouldReturnFizzBuzz() throws Exception {

        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        String result = fizzBuzz.write(15);

        // Then
        assertThat(result).isEqualTo("Fizz Buzz");
    }


    @Test
    public void shouldWorkFor36FirstNumbers() throws Exception {
        // Given
        List<String> results = new LinkedList<String>();
        FizzBuzz fizzBuzz = new FizzBuzz();
        // When
        for (int i = 1; i < 37; i++) {
             results.add(fizzBuzz.write(i));
        }

        // Then
        assertThat(results).containsExactly("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,Fizz,14,Fizz Buzz,16,17,Fizz,19,Buzz,Fizz,22,Fizz,Fizz,Buzz,26,Fizz,28,29,Fizz Buzz,Fizz,Fizz,Fizz,Fizz,Fizz Buzz,Fizz".split(","));
    }
}
package org.dojo.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenEmpty() throws Exception {

        // Given
        StringCalculator calculator = new StringCalculator();
        // When
        int result = calculator.add("");
        // Then
        assertThat(result).isEqualTo(0);
    }
    @Test
    public void shouldReturnOne() throws Exception {

        // Given
        StringCalculator calculator = new StringCalculator();
        // When
        int result = calculator.add("1");
        // Then
        assertThat(result).isEqualTo(1);
    }
    @Test
    public void shouldReturnThree() throws Exception {

        // Given
        StringCalculator calculator = new StringCalculator();
        // When
        int result = calculator.add("1,2");
        // Then
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void shouldSumMultipleNumbers() throws Exception {

        // Given
        StringCalculator calculator = new StringCalculator();
        // When
        int result = calculator.add("1,2,4,1");
        // Then
        assertThat(result).isEqualTo(8);
    }
    @Test
    public void shouldHandleLineBreaks() throws Exception {

        // Given
        StringCalculator calculator = new StringCalculator();
        // When
        int result = calculator.add("1\n2,3");
        // Then
        assertThat(result).isEqualTo(6);
    }
}

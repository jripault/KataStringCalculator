package org.dojo.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.failBecauseExceptionWasNotThrown;

public class StringCalculatorTest {

    public StringCalculator sc;

    @Before
    public void setUp() {
        sc = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertThat(sc.add("")).isEqualTo(0);
        assertThat(sc.add("\n")).isEqualTo(0);
    }

    @Test
    public void shouldReturnSameNumberForSingleEntry() {
        assertThat(sc.add("2")).isEqualTo(2);
        assertThat(sc.add("\n2")).isEqualTo(2);
        assertThat(sc.add("2\n")).isEqualTo(2);
        assertThat(sc.add("\n2\n")).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSendExceptionIfInputSingleIsNAN() {
        sc.add("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSendExceptionIfFirstInputIsNAN() {
        sc.add("a,1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSendExceptionIfSecondInputIsNAN() {
        sc.add("2,z");
    }

    @Test
    public void shouldReturnSumOfTwoParam() {
        assertThat(sc.add("2,3")).isEqualTo(5);
    }

    @Test
    public void shouldReturnSumOfTreeParam() {
        assertThat(sc.add("2,3,10")).isEqualTo(15);
    }


    @Test
    public void shouldHandleNewLinesBetweenNumbers() {
        assertThat(sc.add("3,2")).isEqualTo(5);
        assertThat(sc.add("3\n,2")).isEqualTo(5);
        assertThat(sc.add("\n3\n,\n2\n")).isEqualTo(5);
    }

    @Test
    public void shouldHandleNewLinesInsteadOfComma() {
        assertThat(sc.add("3\n2")).isEqualTo(5);
        assertThat(sc.add("\n3,\n2\n")).isEqualTo(5);
        assertThat(sc.add("3\n,2")).isEqualTo(5);
        assertThat(sc.add("/;\n6\n;\n2;\n10\n")).isEqualTo(18);
    }

    @Test
    public void shouldAcceptCustomDelimiter() {
        assertThat(sc.add("/;1;2;10")).isEqualTo(13);
        assertThat(sc.add("/;\n9;2")).isEqualTo(11);
        assertThat(sc.add("/;\n9;2;10")).isEqualTo(21);
    }

    @Test
    public void shouldSendExceptionIfNegativeInput() {
        try {
            sc.add("/;\n9;-2;10");
            failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Negative numbers not allowed : -2");

        }
    }

    @Test
    public void shouldSendExceptionIfMultipleNegativeInput() {
        try {
            sc.add("/;\n9;-2;-4;10");
            failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Negative numbers not allowed : -2, -4");
        }
    }
}

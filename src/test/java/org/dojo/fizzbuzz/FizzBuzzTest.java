package org.dojo.fizzbuzz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void shouldDoSomething() {
        //Given
        int i = 0;

        //When
        i++;

        //Then
        assertThat(i).isEqualTo(1);
    }
}
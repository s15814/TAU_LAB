package com.pjwstk.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {
    @Test
    public void Should_ParseNumbers() {
        //Given
        String[] numberStrings = {"1", "2", "3"};

        //When
        int[] result = NumberUtils.parseNumbers(numberStrings);

        //Then
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
    }

    @Test
    public void Should_ThrowException_When_NumberFormatIsNotCorrect() {
        //Given
        String[] numberStrings = {"A", "B", "C"};

        //When
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberUtils.parseNumbers(numberStrings);
        });

        //Then
    }

    @Test
    public void Should_ThrowException_When_NumberIsNegative() {
        //Given
        String[] numberStrings = {"1", "2", "-3"};

        //When
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberUtils.parseNumbers(numberStrings);
        });

        //Then
    }

    @Test
    public void Should_ThrowException_When_NumberIsZero() {
        //Given
        String[] numberStrings = {"1", "2", "0"};

        //When
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberUtils.parseNumbers(numberStrings);
        });

        //Then
    }
}
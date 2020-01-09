package com.pjwstk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureValidatorTest {
    private FigureValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new FigureValidator();
    }

    @Test
    public void Should_ReturnFalse_When_InputIsEmpty() {
        //Given

        //When
        boolean result = validator.verify(new String[0]);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnFalse_When_ThereAreToLittleInputArguments() {
        //Given
        String[] input = {"1", "2"};

        //When
        boolean result = validator.verify(input);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnTrue_When_InputAllowsBuildingFigure() {
        //Given
        String[] input = {"2", "2", "2"};

        //When
        boolean result = validator.verify(input);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnFalse_When_InputDoesNotAllowBuildingFigure() {
        //Given
        String[] input = {"2", "5", "2"};

        //When
        boolean result = validator.verify(input);

        //Then
        assertFalse(result);
    }
}
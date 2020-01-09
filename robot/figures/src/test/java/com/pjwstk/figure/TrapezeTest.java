package com.pjwstk.figure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrapezeTest {
    private Figure trapeze;

    @BeforeEach
    public void setUp() {
        trapeze = new Trapeze();
    }

    @Test
    public void Should_ReturnFalse_When_AllSidesAreEqual() {
        //Given

        //When
        boolean result = trapeze.isBuildingFigurePossible(2, 2, 2, 2);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnTrue_When_OnlyOneSideIsLonger() {
        //Given

        //When
        boolean result = trapeze.isBuildingFigurePossible(2, 4, 2, 2);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnTrue_When_OnlyOneSideIsShorter() {
        //Given

        //When
        boolean result = trapeze.isBuildingFigurePossible(4, 4, 2, 4);

        //Then
        assertTrue(result);
    }

    @Test
    public void Should_ReturnFalse_When_TwoSidesAreEqual() {
        //Given

        //When
        boolean result = trapeze.isBuildingFigurePossible(3, 3, 2, 2);

        //Then
        assertFalse(result);
    }

    @Test
    public void Should_ReturnFalse_When_OneSideIsVeryLong() {
        //Given

        //When
        boolean result = trapeze.isBuildingFigurePossible(3, 3, 2, 100);

        //Then
        assertFalse(result);
    }
}
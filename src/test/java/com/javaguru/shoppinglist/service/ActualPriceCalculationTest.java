package com.javaguru.shoppinglist.service;

import org.junit.Test;
import org.mockito.Spy;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class ActualPriceCalculationTest {

    @Spy
    ActualPriceCalculation victim = new ActualPriceCalculation();

    @Test
    public void shouldCalculateActualPrice() {
        BigDecimal expected = new BigDecimal(50);
        BigDecimal actual = victim.calculateActualPrice(new BigDecimal(100), new BigDecimal(50));

        assertEquals(expected, actual);
    }
}
package com.duandian;

import static org.junit.Assert.*;

/**
 * Created by Caily on 6/23/2017.
 * v1.0
 * Test Module
 */
public class SpecailNumberDealTest {

    private SpecailNumberDeal test = new SpecailNumberDeal();

    @org.junit.Test
    public void inputCheck() throws Exception {

        // Failure test for empty.
        assertEquals(false, test.inputCheck(null));

        // Failure test for length.
        assertEquals(false, test.inputCheck(new int[1]));

        // Failure test for range.
        assertEquals(false, test.inputCheck(new int[]{0, 1, 2}));

        // Failure test for multi.
        assertEquals(false, test.inputCheck(new int[]{3, 5, 5}));

        // Simple success test.
        assertEquals(true, test.inputCheck(new int[]{3, 5, 7}));
    }

}
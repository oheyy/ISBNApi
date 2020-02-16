package com.daniel.isbntool;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateISBNTest {
    @Test
    public void test_10_digit_check_digit_is_2_for_030640615(){
        ValidateISBN validateISBN = new ValidateISBN();
        boolean checkDigit = validateISBN.checkDigit("0-306-40615-2");
        assertEquals(true, checkDigit);
    }

    @Test
    public void test_13_digit_check_digit_is_7_9780306406157(){
        ValidateISBN validateISBN = new ValidateISBN();
        boolean checkDigit = validateISBN.checkDigit("978-0-306-40615-7");
        assertEquals(true, checkDigit);
    }


}
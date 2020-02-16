package com.daniel.isbntool;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ValidateISBNTest {

    private ValidateISBN validateISBN;

    @Before
    public void setup(){
        validateISBN = new ValidateISBN();
    }
    @Test
    public void test_10_digit_check_digit_is_2_for_030640615_success(){
        boolean checkDigit = validateISBN.checkDigit("0-306-40615-2");
        assertEquals(true, checkDigit);
    }

    @Test
    public void test_10_digit_check_digit_is_2_for_030640615_fail(){
        boolean checkDigit = validateISBN.checkDigit("0-306-40615-1");
        assertEquals(false, checkDigit);
    }
    @Test
    public void test_size_9_fail(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            validateISBN.checkDigit("0-306-40615");
        });
        String expectedMessage = "Invalid ISBN, should be 10 or 13 digits";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_size_14_fail(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            validateISBN.checkDigit("978-0-306-40615-75");
        });
        String expectedMessage = "Invalid ISBN, should be 10 or 13 digits";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void test_13_digit_check_digit_is_7_9780306406157_success(){
        boolean checkDigit = validateISBN.checkDigit("978-0-306-40615-7");
        assertEquals(true, checkDigit);
    }

    @Test
    public void test_13_digit_check_digit_is_7_9780306406157_fail(){
        boolean checkDigit = validateISBN.checkDigit("978-0-306-40615-6");
        assertEquals(false, checkDigit);
    }

    @Test
    public void test_value_all_letters(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            validateISBN.checkDigit("helloWorld");
        });
        String expectedMessage = "Invalid ISBN, should contain only numerical values";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test_value_alphanumeric_values(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            validateISBN.checkDigit("978-0-306-40615-L");
        });
        String expectedMessage = "Invalid ISBN, should contain only numerical values";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }



}
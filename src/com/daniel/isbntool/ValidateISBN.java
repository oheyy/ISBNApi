package com.daniel.isbntool;

import org.apache.commons.lang3.StringUtils;

public class ValidateISBN {
    public boolean checkDigit(String isbn) {
        String isbnNumbersOnly = isbn.replaceAll("-", "");
        int checkDigit = 0;
        if(!StringUtils.isNumeric(isbnNumbersOnly)){
            throw new NumberFormatException("Invalid ISBN, should contain only numerical values");
        }
        if(isbnNumbersOnly.length() == 10){
            checkDigit = calculateISBN10CheckDigit(isbnNumbersOnly);
        }
        else if(isbnNumbersOnly.length() == 13){
            checkDigit = calculateISBN13CheckDigit(isbnNumbersOnly);
        }else{
            throw new NumberFormatException("Invalid ISBN, should be 10 or 13 digits");
        }


        return checkDigit == Integer.parseInt(String.valueOf(isbnNumbersOnly.charAt(isbnNumbersOnly.length()-1))) ? true:false;
    }
    private int calculateISBN10CheckDigit(String isbnNumbersOnly){
        int j = isbnNumbersOnly.length();
        int i = 0;
        int checkDigit = 0;
        while (i<isbnNumbersOnly.length()-1 && j>1){
            checkDigit += Integer.parseInt(String.valueOf(isbnNumbersOnly.charAt(i))) * (j);
            j -= 1;
            i += 1;
        }
        return 11 - (checkDigit%11) % 11;
    }

    private int calculateISBN13CheckDigit(String isbnNumbersOnly){
        int checkDigit = 0;
        for(int i=1; i<isbnNumbersOnly.length(); i++){
            if(i%2==0 && i != 0){
                checkDigit += Integer.parseInt(String.valueOf(isbnNumbersOnly.charAt(i-1))) * 3;
            }else{
                checkDigit += Integer.parseInt(String.valueOf(isbnNumbersOnly.charAt(i-1)));
            }
        }
        return  10 - (checkDigit%10);
    }
}

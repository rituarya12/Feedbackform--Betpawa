package com.luv2code.springboot.s4dx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finder {
    String[] sampleValues;

    Finder(String[] inputStringArray) {
        sampleValues = inputStringArray;
    }


    public String[] find(String intputString) {

        /*Assuming we are comparing Strings who have exact same characters and count of each letter is same
        If we want to compare Strings only based on characters irrespective of count then we can use Set instead of List.
         */
        List<String> listOfmatchingStrings = new ArrayList<>();
        char[] charactersOfInputString = intputString.toCharArray();

        Arrays.sort(charactersOfInputString);

        for (int i = 0; i < sampleValues.length; i++) {
            char[] charactersOfSampleString = sampleValues[i].toCharArray();
            Arrays.sort(charactersOfSampleString);
            if (Arrays.equals(charactersOfInputString, charactersOfSampleString)) {
                listOfmatchingStrings.add(sampleValues[i]);
            }
        }

        String[] result = new String[listOfmatchingStrings.size()];
        for (int i = 0; i < listOfmatchingStrings.size(); i++) {
            result[i] = listOfmatchingStrings.get(i);
        }
        return result;

    }
}

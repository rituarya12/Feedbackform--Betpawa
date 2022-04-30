package com.luv2code.springboot.s4dx;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "das";

        Finder finder = new Finder(thisIsAStringArray);

        String[] answer = finder.find("sad");

        System.out.println("Output Array is :- " +Arrays.toString(answer));

    }
}

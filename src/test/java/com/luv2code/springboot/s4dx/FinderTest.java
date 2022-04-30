package com.luv2code.springboot.s4dx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@ActiveProfiles("test")
class FinderTest {

    private Finder finder;

    @BeforeEach
    public void init() {
        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "das";
        finder = new Finder(thisIsAStringArray);
    }


    @Test
    void find() {
        String[] output = {"asd", "das"};

        Assertions.assertArrayEquals(output, finder.find("sad"));

    }
}
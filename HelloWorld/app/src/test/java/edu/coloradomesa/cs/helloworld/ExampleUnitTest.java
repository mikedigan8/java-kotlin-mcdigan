package edu.coloradomesa.cs.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void booleanTests() {
        boolean p = true;
        boolean q = false;

        if(p && !q) { //very similar to C/C++ and JavaScript
            // okay
        } else {
            fail();
        }

        if(p || q) {
            // okay
        } else {
            fail();
        }

        int x = 0;
        if(x != 0) {
            fail();
        } else {
            // okay
        }
    }

    @Test
    public void intTests() {
        int x = 73;

        int billion = 1_000_000_000;

        long trillion = 1_000_000_000_000L;

        // cast notation
        int trillionRem37 = (int) (1_000_000_000_000L % 37L);

        int y = Integer.parseInt("42");

        assertEquals(42, y);

        int color = 0xc3a9_ffff; // hexadecimal 0x
        int flags = 0b1110_1010__1011_0101; // binary 0b
    }

    @Test
    public void stringFacts() {
        // string is an Immutable object.
        String word = "Word.";

        System.out.println(word.contains("or"));
        assertEquals(true, word.contains("or"));
        String wordToo = word + " " + "too!";

        // bad idea -- lots of garage & slow (n^2 approach)
        String stars = "";
        for (int i = 0; i < 100; ++i) {
            stars += "*";
        }

        // good idea -- almost no garbage
        StringBuilder sb = new StringBuilder(100);
        for(int i = 0; i < 100; ++i) {
            sb.append("*"); // no mutex -- faster & correct
        }
        String betterStars = sb.toString();

        // old code uses StringBuffer instead.

        StringBuffer sbuf = new StringBuffer(100);
        for(int i = 0; i < 100; ++i) {
            sbuf.append("*"); // creates mutex locks
        }
        String betterStars2 = sbuf.toString();
    }
}
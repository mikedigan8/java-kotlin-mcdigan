package edu.coloradomesa.cs.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlBackTest {

    @Test
    public void testConstructors() {
        BowlBack mando1 = new BowlBack();
        assertEquals(10, mando1.getStringMax());
        assertEquals('O', mando1.getHoleType());

        int strings = 12;
        BowlBack mando2 = new BowlBack(strings);
        assertEquals(strings, mando2.getStringMax());

        char hole = 'F';
        BowlBack mando3 = new BowlBack(strings, hole);
        assertEquals(hole, mando3.getHoleType());

        hole = 'O';
        BowlBack mando4 = new BowlBack(strings, hole);
        assertEquals(hole, mando4.getHoleType());

        hole = 'M';
        try {
            BowlBack mando5 = new BowlBack(strings, hole);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }
    }

    @Test
    public void testVolume() {
        BowlBack mando1 = new BowlBack();
        double vol = 5.5;

        try {
            mando1.setVolume(vol);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

        mando1.startPlaying(1);
        vol = 15.0;
        mando1.setVolume(vol);
        assertEquals(vol, mando1.getVolume(), 0.0);

        vol = 16;
        try {
            mando1.setVolume(vol);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

        BowlBack mando2 = new BowlBack(10, 'O');
        mando2.startPlaying(1);

        try {
            mando2.setVolume(vol);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

        vol = 12;
        mando2.setVolume(vol);
        assertEquals(vol, mando2.getVolume(), 0.0);
    }

    @Test
    public void testHours() {
        BowlBack mando = new BowlBack();
        double hours = 15;
        mando.startPlaying(hours);
        assertEquals(15, mando.getPlayedHours(), 0.0);

        try {
            mando.startPlaying(hours);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

        mando.setInTune(false);
        try {
            mando.startPlaying(1);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

        mando.setInTune(true);
        try {
            mando.startPlaying(-1);
            fail();
        } catch(IllegalArgumentException er) {
            assertTrue(true);
        }

    }
}
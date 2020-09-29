package edu.coloradomesa.cs.objects;

import androidx.annotation.VisibleForTesting;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlatBackTest {

    @Test
    public void testConstructors() {
        FlatBack mando1 = new FlatBack();
        assertEquals(8, mando1.getStringMax());
        assertFalse(mando1.isElectric());
        assertFalse(mando1.isPluggedIn());

        int strings = 10;
        FlatBack mando2 = new FlatBack(strings);
        assertEquals(strings, mando2.getStringMax());

        FlatBack mando3 = new FlatBack(strings, true);
        assertTrue(mando3.isElectric());
    }

    @Test
    public void testPluggedIn() {
        FlatBack mando1 = new FlatBack(8, true);
        double vol = 5.5;
        mando1.startPlaying(1);

        mando1.setVolume(vol);
        assertEquals(vol, mando1.getVolume(), 0.0);
        vol = 10.0;

        try {
            mando1.setVolume(vol);
            fail();
        }
        catch (IllegalArgumentException er) {
            assertTrue(true);
        }
        mando1.setPluggedIn(true);
        vol = 15;
        mando1.setVolume(vol);
        assertEquals(vol, mando1.getVolume(),0.0);

        mando1.setPluggedIn(false);
        assertEquals(vol / 2, mando1.getVolume(), 0.0);


        FlatBack mando2 = new FlatBack();
        try {
            mando2.setPluggedIn(true);
        }
        catch (IllegalArgumentException er){
            assertTrue(true);
        }

        vol = 5.5;
        try {
            mando2.setVolume(vol);
            fail();
        }
        catch(IllegalArgumentException er) {
            assertTrue(true);
        }
    }
}
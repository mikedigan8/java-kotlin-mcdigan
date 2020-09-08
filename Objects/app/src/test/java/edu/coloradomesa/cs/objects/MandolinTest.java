package edu.coloradomesa.cs.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class MandolinTest {

    @Test
    public void getStrings() {
        // constructor with valid string count
        int strings = 8;
        Mandolin inst = new Mandolin(strings);
        assertEquals(strings,inst.getStrings());

        // constructor with invalid string count
        strings = 11;
        try {
            Mandolin inst2 = new Mandolin(strings);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }
    }

    @Test
    public void setStrings() {
        int strings = 12;
        Mandolin inst = new Mandolin(strings);

        // works with valid string count
        strings = 8;
        inst.setStrings(strings);
        assertEquals(strings, inst.getStrings());

        // doesn't work with invalid string count
        strings = 13;
        try {
            inst.setStrings(strings);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }
    }

    @Test
    public void getStringMax() {
        int maxString = 10;
        Mandolin inst = new Mandolin(maxString);
        assertEquals(maxString, inst.getStringMax());
    }

    @Test
    public void getInTune() {
        int maxString = 10;
        Mandolin inst = new Mandolin(maxString);
        assertTrue(inst.getInTune());

        int newStrings = 8;
        inst.setStrings(newStrings);
        assertFalse(inst.getInTune());
    }

    @Test
    public void setInTune() {
        int maxString = 10;
        Mandolin inst = new Mandolin(maxString);

        int newStrings = 8;
        inst.setStrings(newStrings);
        inst.setInTune();
        assertTrue(inst.getInTune());
    }

    @Test
    public void getPlaying() {
        int maxString = 10;
        Mandolin inst = new Mandolin(maxString);

        assertFalse(inst.getPlaying());
    }

    @Test
    public void startPlaying() {
        int maxString = 10;
        Mandolin inst = new Mandolin(maxString);

        // playing for 5 hours is okay because the instrument
        // stays in tune
        inst.startPlaying(5);
        assertTrue(inst.getPlaying());

        // playing for 15 hours is not okay because the instrument
        // gets out of tune
        try {
            inst.startPlaying(15);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }

        // can only play when the instrument is in tune
        inst.setStrings(10);
        try {
            inst.startPlaying(1);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }

        // can only play for a positive number of hours
        inst.setInTune();
        try {
            inst.startPlaying(-1);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }

    }

    @Test
    public void stopPlaying() {
        Mandolin inst = new Mandolin(8);
        inst.startPlaying(3);
        assertTrue(inst.getPlaying());
        inst.stopPlaying();
        assertFalse(inst.getPlaying());
    }

    @Test
    public void getPlayedHours() {
        Mandolin inst = new Mandolin(8);

        // when only playing for 3 hours
        int hoursPlayed = 3;
        inst.startPlaying(hoursPlayed);
        assertEquals(hoursPlayed, inst.getPlayedHours(), 0.0);

        // playing for 3 more hours
        inst.startPlaying(hoursPlayed);
        assertEquals(hoursPlayed * 2, inst.getPlayedHours(), 0.0);

        // after changing strings played hours returns to 0.0
        inst.setStrings(8);
        assertEquals(0, inst.getPlayedHours(), 0.0);

        // can't play for more than 10 hours without changing strings
        try {
            inst.startPlaying(15);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }
    }

    @Test
    public void getVolume() {
        Mandolin inst = new Mandolin(10);

        // default volume is 5
        inst.startPlaying(3);
        assertEquals(5,inst.getVolume(), 0.0);
    }

    @Test
    public void setVolume() {
        Mandolin inst = new Mandolin(8);

        // can't set a volume if not playing
        try {
            inst.setVolume(5.5);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1, 1);
        }

        // can set volume when playing
        inst.startPlaying(3);
        assertEquals(5,inst.getVolume(), 0.0);

        // can set a new volume to play louder or quieter
        double newVol = 6.8;
        inst.setVolume(newVol);
        assertEquals(newVol, inst.getVolume(),0.0);

        // can't set a volume above 10 or below 0
        try {
            inst.setVolume(-1);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er){
            assertEquals(1,1);
        }

        try {
            inst.setVolume(15);
            assertEquals(0,1);
        }
        catch (IllegalArgumentException er) {
            assertEquals(1,1);
        }
    }
}
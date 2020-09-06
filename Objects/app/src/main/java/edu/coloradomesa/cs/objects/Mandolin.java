package edu.coloradomesa.cs.objects;

public class Mandolin {

    // the current number of strings on the instrument
    private int strings;

    // the total number of tuning pegs on the instrument
    private int stringMax;

    // assuming a new mandolin is in tune
    private boolean inTune = true;

    // assumes you are not yet playing your new mandolin
    // must first be in tune to be played
    private boolean playing = false;

    // the number of hours you've played your mandolin
    // after playing for 10 hours your instrument will be out of tune
    // must be re-tuned before it can be played again
    private double playedHours = 0;

    // the volume of the mandolin is set to 0 when not being played
    // ranges from 0.1 to 10.0 when being played
    private double volume = 0.0;
    
    public int getStrings() {
        return strings;
    }

    // allows the user to change the strings
    // changing strings makes the mandolin out of tune
    public void setStrings(int strings) {
        if (strings < 0 || this.stringMax < strings) {
            String message = "String count must be between 0 and " + this.stringMax + ". " +
                strings + " does not fall in this range.";
            throw new UnsupportedOperationException(message);
        } else {
            this.strings = strings;
            this.inTune = false;
            this.playedHours = 0.0;
        }
    }

    public int getStringMax() {
        return stringMax;
    }

    public boolean getinTune() {
        return inTune;
    }

    public void setInTune() {
        inTune = true;
        // resetting the number of hours you can play while in tune
        playedHours = 0.0;
    }

    public boolean getPlaying() {
        return playing;
    }

    public void startPlaying(double hours) {
        if(inTune) {
            if(hours > 0.0) {
                if (playedHours + hours < 10) {
                    playing = true;
                    playedHours += hours;
                    volume = 5;
                } else {
                    inTune = false;
                    playedHours = 10;
                    String message = "You can only play for " + (10 - playedHours) + " more hours before going out of tune. " +
                            "You must re-tune your mandolin before playing for the remaining " + (hours - (10 - playedHours)) +
                            " hours.";
                    throw new UnsupportedOperationException(message);
                }
            }
            else {
                throw new UnsupportedOperationException("You must play for a positive number of hours.");
            }
        }
        else {
            throw new UnsupportedOperationException("You must be in tune before you start playing.");
        }
    }

    public void stopPlaying() {
        playing = false;
    }

    public double getPlayedHours() {
        return playedHours;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if(playing) {
            if(volume > 0.0 && volume < 10.0) {
                this.volume = volume;
            }
            else {
                String message = "The volume must be between 0.0 and 10.0. " + volume +
                        " does not meet this requirement.";
                throw new UnsupportedOperationException(message);
            }
        }
        else {
            String message = "You must be playing before you can set the volume.";
            throw new UnsupportedOperationException(message);
        }
    }

    public Mandolin(int strings) {
        // a new mandolin will have the correct number of strings (either 8, 10, or 12)
        if (strings < 8 || strings > 12 || strings % 2 != 0) {
            String message = "Mandolins have and even number of strings between 8 and 12 (inclusive). " + strings +
                    " is not an acceptable number of strings.";
            throw new UnsupportedOperationException(message);
        } else {
            this.strings = strings;
            this.stringMax = strings;
        }
    }
}
package edu.coloradomesa.cs.objects;

public class BowlBack extends Mandolin {

    // Bowl back mandolins hold their tune better than other kinds of mandolins
    // they can play for twice as long before going out of tune
    private int outOfTuneHours = 20;

    // Bowl back mandolins can have either an F-hole or a
    // round hole in their body
    private char holeType;

    // Depending on the type of the hole the volume will be different
    private double oVolume = 15.0;
    private double fVolume = 12.5;
    private double maxVolume;
    private double volume;

    // Traditionally bowl back mandolins have 10 strings
    BowlBack() {
        super(10);
        holeType = 'O';
        maxVolume = oVolume;
    }

    // Bowl back mandolins are primarily have O holes
    BowlBack(int strings) {
        super(strings);
        holeType = 'O';
        maxVolume = oVolume;
    }

    BowlBack(int strings, char holeType) {
        super(strings);
        if(holeType == 'o' || holeType == 'O') {
            this.holeType = 'O';
            maxVolume = oVolume;
        }
        else if(holeType == 'f' || holeType == 'F') {
            this.holeType = 'F';
            maxVolume = fVolume;
        }
        else {
            String message = "Bowl back mandolins can have either an F hole or an O hole. " +
                            holeType + " is not an acceptable hole type.";
            throw new IllegalArgumentException(message);
        }
    }

    public char getHoleType() {
        return holeType;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public void setVolume(double volume) {
        if(super.getPlaying()) {
            if(volume >= 0.0 && volume <= maxVolume) {
                this.volume = volume;
            }
            else {
                String message = "The volume must be between 0.0 and " + maxVolume + ", " + volume +
                        " does not meet this requirement.";
                throw new IllegalArgumentException(message);
            }
        }
        else {
            String message = "You must be playing before you can set the volume.";
            throw new IllegalArgumentException(message);
        }
    }
}

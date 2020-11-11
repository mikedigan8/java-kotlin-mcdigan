package edu.coloradomesa.cs.collections;

public class FlatBack extends Mandolin{

    // Flack back mandolins are not as loud as other types
    // they can only play at a maximum volume of 7.5
    private double setVolume = 7.5;
    private double maxVolume = setVolume;
    private double volume;

    // Flat back mandolins can also be electric,
    // if they are, the maximum volume is twice
    // as loud when it is plugged in
    private boolean electric;
    private boolean pluggedIn = false;

    // If the mandolin is electric and plugged in the
    // volume is twice as loud
    public void setPluggedIn(boolean pluggedIn) {
        if (electric) {
            this.pluggedIn = pluggedIn;
            if(pluggedIn && maxVolume != setVolume * 2) {
                maxVolume = setVolume * 2;
                volume *= 2;
            }
            else if(!pluggedIn && maxVolume != setVolume) {
                maxVolume = setVolume;
                volume /= 2;
            }
        }
        else {
            String message = "Your mandolin must be an electric mandolin in order to plug it in.";
            throw new IllegalArgumentException(message);
        }
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public boolean isElectric() {
        return electric;
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


    // Traditionally flat back mandolins have 8 strings
    FlatBack(String manNum) {
        super(8, manNum);
        electric = false;
    }

    // They are also primarily not electric
    FlatBack(int strings, String manNum) {
        super(strings, manNum);
        electric = false;
    }

    // Specifying if the mandolin is electric
    FlatBack(int strings, boolean electric, String manNum) {
        super(strings, manNum);
        this.electric = electric;
    }
}
package edu.coloradomesa.cs.objects;

public class FlatBack extends Mandolin{

    // Flack back mandolins are not as loud as other types
    // they can only play at a maximum volume of 7.5
    private double setVolume = 7.5;
    private double maxVolume = setVolume;

    // Flat back mandolins can also be electric,
    // if they are, the maximum volume is twice
    // as loud when it is plugged in
    private boolean electric;
    private boolean pluggedIn = false;

    // If the mandolin is electric and plugged in the maximum
    // volume is twice as loud
    public void setPluggedIn(boolean pluggedIn) {
        if (electric) {
            this.pluggedIn = pluggedIn;
            if(pluggedIn && maxVolume != setVolume * 2) maxVolume = setVolume * 2;
            else if(!pluggedIn && maxVolume != setVolume) maxVolume = setVolume;
        }
        else {
            String message = "Your mandolin must be an electric mandolin in order to plug it in.";
            throw new IllegalArgumentException(message);
        }
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    // Traditionally flat back mandolins have 8 strings
    FlatBack() {
        super(8);
        electric = false;
    }

    // They are also primarily not electric
    FlatBack(int strings) {
        super(strings);
        electric = false;
    }

    // Specifying if the mandolin is electric
    FlatBack(int strings, boolean electric) {
        super(strings);
        this.electric = electric;
    }
}

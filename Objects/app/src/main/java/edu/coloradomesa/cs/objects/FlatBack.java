package edu.coloradomesa.cs.objects;

public class FlatBack extends Mandolin{

    // Flack back mandolins are not as loud as other types
    // they can only play at a maximum volume of 7.5
    private double maxVolume = 7.5;

    // Flat back mandolins can also be electric
    // if they are the maximum volume is 20.0
    // when it is plugged in
    private boolean electric;

    // traditionally flat back mandolins have 8 strings
    FlatBack() {
        super(8);
        electric = false;
    }

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

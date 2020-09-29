package edu.coloradomesa.cs.objects;

public class BowlBack extends Mandolin {

    // Bowl back mandolins hold their tune better than other kinds of mandolins
    // they can play for twice as long before going out of tune
    private int outOfTuneHours = 20;

    // traditionally bowl back mandolins have 10 strings
    BowlBack() {
        super(10);
    }

    BowlBack(int strings) {
        super(strings);
    }

}

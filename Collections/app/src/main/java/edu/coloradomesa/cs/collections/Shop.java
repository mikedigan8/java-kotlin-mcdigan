package edu.coloradomesa.cs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Shop {
    Hashtable<Integer, Mandolin> Mandolins = new Hashtable<Integer, Mandolin>();

    public void sort(ArrayList<Mandolin> m) {
        Collections.sort(m);
    }

    public void AddMandolin(Mandolin mandolin) {
        Mandolins.put(mandolin.getManufactureNumber().hashCode(),mandolin);
    }

    public void DeleteMandolin(String manNum) {
        Mandolins.remove(manNum);
    }
}

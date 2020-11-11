package edu.coloradomesa.cs.collections;

import java.util.ArrayList;

public class Shop {
    ArrayList<Mandolin> Mandolins = new ArrayList<Mandolin>();

    public void sortem() {
        Mandolin temp;
        for(int i = 0; i < Mandolins.size(); i++) {
            for(int j = i; j < Mandolins.size() - 1; j++) {
                if(Mandolins.get(j).getManufactureNumber().hashCode() > Mandolins.get(j + 1).getManufactureNumber().hashCode()) {
                    temp = Mandolins.get(j);
                    Mandolins.set(j, Mandolins.get(j + 1));
                    Mandolins.set(j + 1, temp);
                }
            }
        }
    }

    public void AddMandolin(Mandolin mandolin) {
        Mandolins.add(mandolin);
    }

    public void DeleteMandolin(String manNum) {
        for(int i = 0; i < Mandolins.size(); i++) {
            if(Mandolins.get(i).getManufactureNumber() == manNum) {
                Mandolins.remove(i);
            }
        }
    }
}

package edu.coloradomesa.cs.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void sort() {
        Hashtable<Integer, Mandolin> test = new Hashtable<Integer, Mandolin>();
        String manNum = "MK944h";
        String manNum1 = "MD1995";
        String manNum2 = "HQ8412";

        Mandolin mandolin = new Mandolin(8, manNum);
        Mandolin mandolin1 = new Mandolin(10, manNum1);
        Mandolin mandolin2 = new Mandolin(12, manNum2);

        test.put(manNum.hashCode(), mandolin);
        test.put(manNum1.hashCode(), mandolin1);
        test.put(manNum2.hashCode(), mandolin2);

        Shop shop = new Shop();
        shop.AddMandolin(mandolin);
        shop.AddMandolin(mandolin1);
        shop.AddMandolin(mandolin2);


    }

    @Test
    public void addDeleteMandolin() {
        Hashtable<Integer, Mandolin> test = new Hashtable<Integer, Mandolin>();
        String manNum = "MK944h";
        String manNum1 = "MD1995";
        String manNum2 = "HQ8412";

        Mandolin mandolin = new Mandolin(8, manNum);
        Mandolin mandolin1 = new Mandolin(10, manNum1);
        Mandolin mandolin2 = new Mandolin(12, manNum2);

        test.put(manNum.hashCode(), mandolin);
        test.put(manNum1.hashCode(), mandolin1);
        test.put(manNum2.hashCode(), mandolin2);

        Shop shop = new Shop();
        shop.AddMandolin(mandolin);
        shop.AddMandolin(mandolin1);
        shop.AddMandolin(mandolin2);

        assertEquals(test, shop.Mandolins);

        shop.DeleteMandolin(manNum);
        test.remove(manNum);

        assertEquals(test, shop.Mandolins);
    }
}
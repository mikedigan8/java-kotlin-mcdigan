package edu.coloradomesa.cs.collections;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void sort() {
        ArrayList<Mandolin> test = new ArrayList<Mandolin>();
        String manNum = "MK944h";
        String manNum1 = "MD1995";
        String manNum2 = "HQ8412";

        Mandolin mandolin = new Mandolin(8, manNum);
        Mandolin mandolin1 = new Mandolin(10, manNum1);
        Mandolin mandolin2 = new Mandolin(12, manNum2);

        test.add(mandolin1);
        test.add(mandolin);
        test.add(mandolin2);

        Shop shop = new Shop();
        shop.AddMandolin(mandolin);
        shop.AddMandolin(mandolin1);
        shop.AddMandolin(mandolin2);

        shop.sortem();

        assertEquals(test, shop.Mandolins);
    }

    @Test
    public void addDeleteMandolin() {
        ArrayList<Mandolin> test = new ArrayList<Mandolin>();
        String manNum = "MK944h";
        String manNum1 = "MD1995";
        String manNum2 = "HQ8412";

        Mandolin mandolin = new Mandolin(8, manNum);
        Mandolin mandolin1 = new Mandolin(10, manNum1);
        Mandolin mandolin2 = new Mandolin(12, manNum2);

        test.add(mandolin);
        test.add(mandolin1);
        test.add(mandolin2);

        Shop shop = new Shop();
        shop.AddMandolin(mandolin);
        shop.AddMandolin(mandolin1);
        shop.AddMandolin(mandolin2);

        assertEquals(test, shop.Mandolins);

        shop.DeleteMandolin(manNum);
        test.remove(0);

        assertEquals(test, shop.Mandolins);
    }
}
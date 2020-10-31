package edu.coloradomesa.cs.kattisproblems

import org.junit.Test

import org.junit.Assert.*

class DragonTest {

    @Test
    fun doWork1() {
        val dragon = Dragon()
        val numsList = ArrayList<String>()
        numsList.add("7")
        numsList.add("-3")
        numsList.add("undo")
        numsList.add("1")
        numsList.add("4")
        numsList.add("3")
        numsList.add("-9")
        numsList.add("5")
        numsList.add("undo")
        numsList.add("2")
        numsList.add("undo")
        numsList.add("1")
        numsList.add("6")
        val ans = 2
        val numStu = "5"
        assertEquals(ans, dragon.doWork(numsList, numStu))
    }

    @Test
    fun doWork2() {
        val dragon = Dragon()
        val numsList = ArrayList<String>()
        numsList.add("8")
        numsList.add("-2")
        numsList.add("3")
        numsList.add("undo")
        numsList.add("2")
        val ans = 3
        val numStu = "5"
        assertEquals(ans, dragon.doWork(numsList, numStu))
    }
}
package edu.coloradomesa.cs.kattisproblems

import java.util.*

class Dragon {
    fun doWork(arry: ArrayList<String>, numStu: String): Int {
        var child = 0
        var stack = ArrayList<Int>()
        for(i in 0 until arry.size) {
            if(arry.get(i) == "undo") {
                for(j in 0 until arry.get(i+1).toInt()){
                    child += -1 * stack.removeAt(stack.size - 1)
                }
            }
            else if(i > 0 && arry.get(i - 1) == "undo")
            else {
                child += arry.get(i).toInt()
                stack.add(arry.get(i).toInt())
            }
        }
        while(child < 0) child += numStu.toInt()
        child = child % numStu.toInt()
        return child
    }

    fun readData(commandArry: ArrayList<String>, throws: String) {
        var throwsInt = throws.toInt()
        val commands = readLine()!!
        for(i in 0 until commands.length) if(commands.get(i) == 'u') throwsInt++
        for(i in 0 until throwsInt) commandArry.add(commands.split(' ')[i])
    }

    fun main() {
        var commandArry = ArrayList<String>()
        val(numStu, throws) = readLine()!!.split(' ')
        readData(commandArry, throws)
        if(throws.toInt() < 1 || numStu.toInt() < 1) println(0)
        else {
            println(doWork(commandArry, numStu))
        }
    }
}
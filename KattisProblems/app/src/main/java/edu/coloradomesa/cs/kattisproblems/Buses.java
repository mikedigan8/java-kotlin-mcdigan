package edu.coloradomesa.cs.kattisproblems;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Buses {
    public static String arrSizeStr;
    public static Scanner sc = new Scanner(System.in);
    public static String nums = "";
    public static String[] numsList;
    public static ArrayList<Integer> busNums = new ArrayList<>();
    private static int i = 0;
    private static int consec = 0;
    private static int begin = 0;
    private static boolean firstNumInStr = true;
    private static boolean firstPrint = true;
    private static String ans = "";

    public static void readIn() {
        arrSizeStr = sc.nextLine();
        nums = sc.nextLine();
        numsList = nums.split(" ");
        for(i = 0; i < numsList.length; i++) {
            busNums.add(Integer.parseInt(numsList[i]));
        }
    }

    public static String printBusNums() {
        Collections.sort(busNums);
        for(i = 0; i < busNums.size()-1; i++) {
            if(busNums.get(i) + 1 == busNums.get(i + 1)) {
                consec++;
                if(firstNumInStr) {
                    begin = i;
                    firstNumInStr = false;
                }
            }
            else if(consec > 1) {
                if(!firstPrint) ans += " ";
                ans += busNums.get(begin) + "-" + busNums.get(i);
                consec = 0;
                firstPrint = false;
                firstNumInStr = true;
            }
            else if(consec == 1) {
                if(!firstPrint) ans += " ";
                ans += busNums.get(begin) + " " + busNums.get(i);
                consec = 0;
                firstPrint = false;
                firstNumInStr = true;
            }
            else {
                if(!firstPrint) ans += " ";
                ans += busNums.get(i);
                consec = 0;
                firstPrint = false;
                firstNumInStr = true;
            }
        }
        if(consec > 1) {
            if(!firstPrint) ans += " ";
            ans += busNums.get(begin) + "-" + busNums.get(i);
            consec = 0;
            firstPrint = false;
            firstNumInStr = true;
        }
        else if(consec == 1) {
            if(!firstPrint) ans += " ";
            ans += busNums.get(begin) + " " + busNums.get(i);
            consec = 0;
            firstPrint = false;
            firstNumInStr = true;
        }
        else {
            if(!firstPrint) ans += " ";
            ans += busNums.get(i);
            consec = 0;
            firstPrint = false;
            firstNumInStr = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        readIn();
        System.out.println(printBusNums());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuldeep.thoughtworkschallange.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Test {

    public static void main(String args[]) {

        Integer[] numbers = {60, 45, 30, 45, 45, 5, 60, 45, 30, 30, 45, 60, 60, 45, 30, 30, 60, 30, 30};
        int target = 480;
        sum_up(new ArrayList(Arrays.asList(numbers)), target);

    }

    static void sum_up(ArrayList<Integer> numbers, int target) {
        sumUp(numbers, target, new ArrayList<Integer>());
    }

    static boolean sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x : partial) {
            s += x;
        }
        if (s == target) {
            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
            return true;
        }
        if (s >= target) {
            return false;
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                remaining.add(numbers.get(j));
            }
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            if (sum_up_recursive(remaining, target, partial_rec)) {
                return true;
            }
        }

        return false;
    }

    public static Map<String, Integer> processConf(Map<String, Integer> confs) {

        List<Integer> confDurations = new ArrayList(confs.values());

        sumUp(confDurations, 180, new ArrayList());

        for (Integer a : usedNumbersMain) {

            confs.values().remove(a);

        }
        return confs;

//        Iterator<Map.Entry<String, Integer>> iter = confs.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<String, Integer> entry = iter.next();
//            
//          
//        }
    }

    public static boolean sumUp(List<Integer> numbers, int target, ArrayList<Integer> partial) {
        
        int s = 0;
        for (int x : partial) {
            s += x;
        }
        if (s == target) {
            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
            return true;
        }else if(s > 0 && s > greatestLowerSum && s < target){
            greatestLowerSum = s;
            setLowestRemaimingList(partial);
        }
        if (s >= target) {
            return false;
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                remaining.add(numbers.get(j));
            }
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            if (sumUp(remaining, target, partial_rec)) {
                setUsedNumbers(partial_rec);
                return true;
            }
        }

        return false;

    }

    private static int greatestLowerSum = 0;
    private static boolean isSet = false;
    static List<Integer> remainingNumbersMain = new ArrayList();
    static List<Integer> usedNumbersMain = new ArrayList();

    public static void setRemaimingList(List<Integer> remainingNumbers) {

        if (!isSet) {
            System.out.println("Remaining Numbers " + remainingNumbers.toString());
            remainingNumbersMain.addAll(remainingNumbers);
            isSet = true;
        }
    }
    
    public static void setLowestRemaimingList(List<Integer> remainingNumbers) {

            System.out.println("Lowest Remaining Numbers " + remainingNumbers.toString());
            remainingNumbersMain.addAll(remainingNumbers);           

    }

    public static void setUsedNumbers(List<Integer> usedNumbers) {
if (!isSet) {
        usedNumbersMain.addAll(usedNumbers);
        System.out.println("Used Numbers " + usedNumbers.toString());
        
            isSet = true;
        }

    }
  

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuldeep.thoughtworkschallenge.processingEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class ProcessConfs {

    private static int greatestLowerSum = 0;
    private static boolean isSet = false;
    private static List<Integer> remainingNumbersMain = new ArrayList();
    private static List<Integer> usedNumbersMain = new ArrayList();

    public static Map<String, Integer> processConf(Map<String, Integer> confs, Integer target) {

        isSet = false;
        remainingNumbersMain = new ArrayList();
        usedNumbersMain = new ArrayList();
        greatestLowerSum = 0;

        List<Integer> confDurations = new ArrayList(confs.values());

        sumUp(confDurations, target, new ArrayList());

        Map<String, Integer> confsNew = new LinkedHashMap();

        for (Integer a : usedNumbersMain) {

            Iterator<Map.Entry<String, Integer>> iter = confs.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = iter.next();
                if (a.compareTo(entry.getValue()) == 0) {
                    confsNew.put(entry.getKey(), entry.getValue());
                    iter.remove();
                    break;
                }
            }

        }

        if (usedNumbersMain.isEmpty()) {

            for (Integer a : remainingNumbersMain) {

                Iterator<Map.Entry<String, Integer>> iter = confs.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Integer> entry = iter.next();
                    if (a.compareTo(entry.getValue()) == 0) {
                        confsNew.put(entry.getKey(), entry.getValue());
                        iter.remove();
                        break;
                    }
                }

            }

        }

        return confsNew;
    }

    public static boolean sumUp(List<Integer> numbers, int target, ArrayList<Integer> partial) {

        int s = 0;
        for (int x : partial) {
            s += x;
        }
        if (s == target) {
            //System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
            return true;
        } else if (s > 0 && s > greatestLowerSum && s < target) {
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

    public static void setRemaimingList(List<Integer> remainingNumbers) {

        if (!isSet) {
            // System.out.println("Remaining Numbers " + remainingNumbers.toString());
            remainingNumbersMain.addAll(remainingNumbers);
            isSet = true;
        }
    }

    public static void setLowestRemaimingList(List<Integer> remainingNumbers) {

        // System.out.println("Lowest Remaining Numbers " + remainingNumbers.toString());
        remainingNumbersMain.addAll(remainingNumbers);

    }

    public static void setUsedNumbers(List<Integer> usedNumbers) {
        if (!isSet) {
            usedNumbersMain.addAll(usedNumbers);
            // System.out.println("Used Numbers " + usedNumbers.toString());

            isSet = true;
        }

    }

}

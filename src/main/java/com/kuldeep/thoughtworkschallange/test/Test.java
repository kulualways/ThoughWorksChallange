/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuldeep.thoughtworkschallange.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Test {

    public static void main(String args[]) {

        Integer[] numbers = {60, 45, 30, 45, 45, 5, 60, 45, 30, 30, 45, 60, 60, 45, 30, 30, 60, 30, 30};
        int target = 480;
        sumUp(new ArrayList(Arrays.asList(numbers)), target, new ArrayList<Integer>());
    }
//    
//      static void sum_up(ArrayList<Integer> numbers, int target) {
//        sum_up_recursive(numbers,target,new ArrayList<Integer>());
//    }
//    
//     static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
//       int s = 0;
//       for (int x: partial) s += x;
//       if (s == target)
//            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
//       if (s >= target)
//            return;
//       for(int i=0;i<numbers.size();i++) {
//             ArrayList<Integer> remaining = new ArrayList<Integer>();
//             int n = numbers.get(i);
//             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
//             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
//             partial_rec.add(n);
//             sum_up_recursive(remaining,target,partial_rec);
//       }
//    }

    public static boolean sumUp(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
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

            if (sumUp(remaining, target, partial_rec)) {
                return true;
            }
        }

        return false;

    }

}

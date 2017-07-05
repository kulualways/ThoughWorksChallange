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
    
    public static void main(String args[]){
        
         Integer[] numbers = {60,45,30,45,45,5,60,45,30,30,45,60,60,45,30,30,60,30,30};
        int target = 480;
        sum_up(new ArrayList(Arrays.asList(numbers)),target);
    }
    
      static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    
     static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
     
      public static void sumUp(List<Integer> numbers, int target) {
          
          
          
          
          

        int sum = 0;

        List<Integer> remainingNumbers = new ArrayList(numbers);
        List<Integer> usedNumbers = new ArrayList();

        for (int i : numbers) {

            sum += i;

            if (i == 180) {

                sum += 60;
            }

            if (sum == target) {
                usedNumbers.add(i);
                remainingNumbers.remove((Integer) i);
                break;
            } else if(sum < target){
                usedNumbers.add(i);
                remainingNumbers.remove((Integer) i);              
                
            } else{
                
                return;
            }

        }

        System.out.println("usedNumbers "  + usedNumbers.toString());
        System.out.println("remainingNumbers " + remainingNumbers.toString());
        
       // sumUp(remainingNumbers,target);

    }
    
}

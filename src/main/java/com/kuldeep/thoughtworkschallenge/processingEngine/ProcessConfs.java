package com.kuldeep.thoughtworkschallenge.processingEngine;

import com.kuldeep.thoughtworkschallenge.Conference;
import com.kuldeep.thoughtworkschallenge.Proposal;
import com.kuldeep.thoughtworkschallenge.Tracks;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kuldeep.Chauhan 
 * This class is used for computation of the combinations for the timing
 */
public class ProcessConfs {

    private static Calendar cal = Calendar.getInstance();
    private static String NETWORKING_EVENT_LABEL = "Netwoking Event";
    private static int greatestLowerSum = 0;
    private static boolean isSet = false;
    private static List<Integer> remainingNumbersMain = new ArrayList();
    private static List<Integer> usedNumbersMain = new ArrayList();   

    public static void buidConferences(List<String> conferences, Map<String, Integer> unquieConferences) {

        for (String conf : conferences) {

            int duration = 0;
            String confTitle = conf.substring(0, conf.lastIndexOf(" "));
            String lastWord = conf.substring(conf.lastIndexOf(" ") + 1, conf.length());
            //   System.out.println("Title " + confTitle + " Last Word " + lastWord);

            if (lastWord.equalsIgnoreCase("lightning")) {
                duration = 5;
            } else {
                duration = Integer.valueOf(lastWord.substring(duration, lastWord.length() - 3));
            }

            unquieConferences.put(confTitle, duration);

        }
    }

    public static Conference scheduleConference(Map<String, Integer> unquieConferences) {

        Conference conference = new Conference();

        List<Tracks> tracks = new ArrayList();

        while (!unquieConferences.isEmpty()) {

            /**
             * Start time is 9am
             */
            cal.clear();
            cal.set(Calendar.HOUR_OF_DAY, 9);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);

            /**
             * Process things for Morning session, Must finish before 12 noon
             * Set target duration to 3 hours i.e 180mins
             */
            Tracks track = new Tracks();
            List<Proposal> proposals = new ArrayList();
            Map<String, Integer> morningConferences = ProcessConfs.generateCombinationOfTiming(unquieConferences, 180);

            if (!morningConferences.isEmpty()) {

                for (Map.Entry<String, Integer> entry : morningConferences.entrySet()) {

                    proposals.add(new Proposal(entry.getKey(), entry.getValue(), cal.getTime()));
                    cal.add(Calendar.MINUTE, entry.getValue());

                }

                //Remove the morning session proposals as already scheduled
                unquieConferences.entrySet().removeAll(morningConferences.entrySet());

                /**
                 * Add Lunch duration which is of 60mins
                 */
                proposals.add(new Proposal("Lunch", 60, cal.getTime()));
                cal.add(Calendar.MINUTE, 60);
      

                 /**
             * Process things for Evening session, Must finish before 5 pm
             * Set target duration to 4 hours i.e 240mins
             */
                 
                Map<String, Integer> eveningConferences = ProcessConfs.generateCombinationOfTiming(unquieConferences, 240);

                //Remove the evevning session proposals as already scheduled
                unquieConferences.entrySet().removeAll(eveningConferences.entrySet());

                for (Map.Entry<String, Integer> entry : eveningConferences.entrySet()) {

                    proposals.add(new Proposal(entry.getKey(), entry.getValue(), cal.getTime()));
                    cal.add(Calendar.MINUTE, entry.getValue());
                    //System.out.println(entry.getKey() + " " + entry.getValue().toString());
                }

                /*Finally Add networkingEvent*/
                cal.clear();
                cal.set(Calendar.HOUR_OF_DAY, 17);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                proposals.add(new Proposal(NETWORKING_EVENT_LABEL, 0, cal.getTime()));
                track.setProposals(proposals);
                tracks.add(track);

            }

        }

        conference.setTracks(tracks);

        return conference;

    }
    
     public static Map<String, Integer> generateCombinationOfTiming(Map<String, Integer> confs, Integer target) {

        isSet = false;
        remainingNumbersMain = new ArrayList();
        usedNumbersMain = new ArrayList();
        greatestLowerSum = 0;

        List<Integer> confDurations = new ArrayList(confs.values());

        sumUp(confDurations, target, new ArrayList());

        Map<String, Integer> confsNew = new LinkedHashMap();

        // If the exact sum of the target timespan is found
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

        // The maximum sum lower then the target timespan is found
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

    /**
     * This method runs into recursive loop to find the exact sum of combination
     * of time duration or the maximum sum of combination lower then the target
     */
    public static boolean sumUp(List<Integer> numbers, int target, ArrayList<Integer> usedNumbers) {

        int s = 0;
        for (int x : usedNumbers) {
            s += x;
        }
        if (s == target) {
            //If target sum using combination of time duration is found return from recursive loop
            return true;
        } else if ((s > 0) && (s > greatestLowerSum) && (s < target)) {
            greatestLowerSum = s;
            setLowestRemaimingList(usedNumbers);
        }
        if (s >= target) {
            return false;
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                remaining.add(numbers.get(j));
            }
            ArrayList<Integer> partial_rec = new ArrayList(usedNumbers);
            partial_rec.add(n);
            if (sumUp(remaining, target, partial_rec)) {
                //If target sum using combination of time duration is found return from recursive loop               
                setUsedNumbers(partial_rec);
                return true;
            }
        }

        return false;

    }

    public static void setLowestRemaimingList(List<Integer> remainingNumbers) {

        remainingNumbersMain.clear();
        remainingNumbersMain.addAll(remainingNumbers);
        // System.out.println("Lowest Remaining Numbers " + remainingNumbers.toString());

    }

    // Add only the first combination found where target sum is achieved
    public static void setUsedNumbers(List<Integer> usedNumbers) {
        if (!isSet) {
            usedNumbersMain.addAll(usedNumbers);
            // System.out.println("Used Numbers " + usedNumbers.toString());

            isSet = true;
        }

    }

}

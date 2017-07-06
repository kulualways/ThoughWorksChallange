package com.kuldeep.thoughtworkschallenge;

import com.kuldeep.thoughtworkschallenge.processingEngine.ProcessConfs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class ManageConference {

    /**
     *
     * @param args Assumed that the data would be received in this format
     * "Writing Fast Tests Against Enterprise Rails 60min", "Overdoing it in
     * Python 45min"....
     */
    public static void main(String args[]) {

        List<String> conferences = new ArrayList();

        // Uncomment the below line to get the data via String args[]
        // conferences = Arrays.asList(args);    
        
        
        
        //Comment these conferences addtions if using String args[]
        conferences.add("Writing Fast Tests Against Enterprise Rails 60min");
        conferences.add("Overdoing it in Python 45min");
        conferences.add("Lua for the Masses 30min");
        conferences.add("Ruby Errors from Mismatched Gem Versions 45min");
        conferences.add("Common Ruby Errors 45min");
        conferences.add("Rails for Python Developers lightning");
        conferences.add("Communicating Over Distance 60min");
        conferences.add("Accounting-Driven Development 45min");
        conferences.add("Woah 30min");
        conferences.add("Sit Down and Write 30min");
        conferences.add("Pair Programming vs Noise 45min");
        conferences.add("Rails Magic 60min");
        conferences.add("Ruby on Rails: Why We Should Move On 60min");
        conferences.add("Clojure Ate Scala (on my project) 45min");
        conferences.add("Programming in the Boondocks of Seattle 30min");
        conferences.add("Ruby vs. Clojure for Back-End Development 30min");
        conferences.add("Ruby on Rails Legacy App Maintenance 60min");
        conferences.add("A World Without HackerNews 30min");
        conferences.add("User Interface CSS in Rails Apps 30min");

        Map<String, Integer> unquieConferences = new LinkedHashMap();

        ProcessConfs.buidConferences(conferences, unquieConferences);

        // System.out.println("Before Processing unquieConferences " + unquieConferences.toString());
        Conference conference = ProcessConfs.scheduleConference(unquieConferences);

        System.out.println(conference);

    }

}

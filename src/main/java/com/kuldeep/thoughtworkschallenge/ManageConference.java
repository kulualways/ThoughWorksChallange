package com.kuldeep.thoughtworkschallenge;

import com.kuldeep.thoughtworkschallange.test.Test;
import com.kuldeep.thoughtworkschallenge.processingEngine.ProcessConfs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class ManageConference {

    public static void main(String args[]) {

        List<String> conferences = new ArrayList();
        Map<String, Integer> unquieConferences = new LinkedHashMap();

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

       // System.out.println("Before Processing unquieConferences " + unquieConferences.toString());
       
       Conference conference = new Conference();
       
       List<Tracks> tracks = new ArrayList();
       
       while(!unquieConferences.isEmpty()){
       
       /**Process things for Morning session, Must finish before 12 noon
        * Set target duration to 3 hours i.e 180mins
        */
       Tracks track = new Tracks();
       List<Proposal> proposals = new ArrayList();
        Map<String, Integer> morningConferences = ProcessConfs.processConf(unquieConferences,180);
        
        if(!morningConferences.isEmpty()){
          
            
            for(Map.Entry<String, Integer> entry : morningConferences.entrySet()){     
                proposals.add(new Proposal(entry.getKey(),entry.getValue()));
                //System.out.println(entry.getKey() + " " + entry.getValue().toString());
            }
            
             unquieConferences.entrySet().removeAll(morningConferences.entrySet());   
            
             /**
              * Add Lunch duration
              */     
     
             proposals.add(new Proposal("Lunch",60));
             //System.out.println("Lunch 12PM");
             
             Map<String, Integer> eveningConferences = ProcessConfs.processConf(unquieConferences,240);
             
             unquieConferences.entrySet().removeAll(eveningConferences.entrySet()); 
                      
            for(Map.Entry<String, Integer> entry : eveningConferences.entrySet()){     
                proposals.add(new Proposal(entry.getKey(),entry.getValue()));
                //System.out.println(entry.getKey() + " " + entry.getValue().toString());
            }          
          
            track.setProposals(proposals);
            tracks.add(track);
            System.out.println("Track Finished");
            
        }
        
       
       }
 
       conference.setTracks(tracks);
       
       System.out.println(conference);
       
    }

}

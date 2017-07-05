package com.kuldeep.thoughtworkschallange;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class ManageConference {
    
    
    public static void main (String args[]){   
        
        List<String> conferences = new ArrayList();
        
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

     
        processConferences(conferences);
        
    }
    
    public static Conference processConferences(List<String> conferences){
        
        return new Conference();
        
    }
    
    
}

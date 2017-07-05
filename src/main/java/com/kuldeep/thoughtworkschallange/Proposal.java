package com.kuldeep.thoughtworkschallange;

import java.time.Duration;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Proposal {
    
    public Proposal(String title, long duration){  
        
        this.title = title;
        
        if(duration > 59){
           this.duration = Duration.ofMinutes(59);  
        }else{
           this.duration = Duration.ofMinutes(duration);  
        }        
    }
    
    private final String title;
    
    private final Duration duration; 

    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }     
    
}

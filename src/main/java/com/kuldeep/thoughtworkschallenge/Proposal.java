package com.kuldeep.thoughtworkschallenge;

import java.util.Date;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Proposal {

    public Proposal(String title, int duration, Date time) {

        this.title = title;

        this.duration = duration;

        this.time = time;

    }

    private final String title;

    private final int duration;

    private Date time;

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
    
    public Date getTime(){
        
        return time;
    }

}

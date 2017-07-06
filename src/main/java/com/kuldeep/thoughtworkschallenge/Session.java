package com.kuldeep.thoughtworkschallenge;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Session {
    
    public Date startTime;
    public Date endTime;    
    private static Calendar cal = Calendar.getInstance();
    
      public Session(int startTime, int endTime) {
        
        setStartTime(startTime);
        setEndTime(endTime);
        

    }


    private void setStartTime(int time) {

        startTime = getTime(time);

    }

    private void setEndTime(int time) {

        endTime = getTime(time);

    }

    private Date getTime(int time) {

        cal.set(Calendar.HOUR_OF_DAY, time);

        return cal.getTime();
    }
    

}

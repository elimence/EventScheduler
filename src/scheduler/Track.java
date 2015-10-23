/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Each track represents a morning and an afternoon session
 * 
 * @author sam
 */
public class Track {
    
    // Class members
    private final String trackName;
    private final int MORNING_SESSION_CAPACITY          = 180;
    private final int AFTERNOON_SESSION_MIN_CAPACITY    = 180;
    private final int AFTERNOON_SESSION_EXTRA_CAPACITY  = 60;
    
    Calendar am = Calendar.getInstance();
    Calendar pm = Calendar.getInstance();
    
    private final List<Event> morningSession   = new ArrayList<>();
    private final List<Event> afternoonSession = new ArrayList<>();
    
    private List<Event> eventClone;
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
    
    /**
     * Create a new track with a given name
     * @param trackName name of track
     */
    public Track(String trackName) {
        this.trackName = trackName;
        
        am.set(Calendar.HOUR_OF_DAY, 9);
        am.set(Calendar.MINUTE, 0);
        
        pm.set(Calendar.HOUR_OF_DAY, 13);
        pm.set(Calendar.MINUTE, 0);
        
    }
    
    /**
     * Selects that can fit into a given track and adds to event list for the track
     * @param eventList list of events to schedule
     * @return list of events that didn't fit into schedule
     */
    public List<Event> fillTrack(List<Event> eventList) {
        // Schedule afternoon sessions
        eventList = addForSession(AFTERNOON_SESSION_MIN_CAPACITY, afternoonSession, eventList, pm);
        
        // Schedule morning sessions
        eventList = addForSession(MORNING_SESSION_CAPACITY, morningSession, eventList, am);
        
        // Add any extra events to afternoon session
        eventList = addForSession(AFTERNOON_SESSION_EXTRA_CAPACITY, afternoonSession, eventList, pm);
        
        return eventList;
    }
    
    /**
     * Utility Function to add events to a given sessions event list
     * 
     * @param capacity capacity of session is minutes
     * @param sessionSet List to hold events for current session
     * @param eventList List of events to schedule
     * @param cal Calendar instance to keep track of sessions timing
     * @return List of events that do not fit in current session
     */
    private List<Event> addForSession(int capacity, List<Event> sessionSet, List<Event> eventList, Calendar cal) {
        eventClone = new ArrayList<>();
        for (Event _event : eventList) {
            if (_event.getDuration() <= capacity) {
                _event.setStart(cal.getTime());
                cal.add(Calendar.MINUTE, _event.getDuration());
                _event.setEnd(cal.getTime());
                sessionSet.add(_event);
                capacity -= _event.getDuration();
            } else {
                eventClone.add(_event);
            }
        }
        return new ArrayList<>(eventClone);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Track Name - ").append(trackName).append(System.lineSeparator());
            
        for (Event event : morningSession) {
            builder
                .append(sdf.format(event.getStart())).append(" ")
                .append(event.getTitle()).append(" ")
                .append(event.getDuration()).append("min").append(System.lineSeparator())
            ;
        }
        
        builder.append("12:00 PM GMT ").append("Lunch").append(System.lineSeparator());
        
        for (Event event : afternoonSession) {
            builder
                .append(sdf.format(event.getStart())).append(" ")
                .append(event.getTitle()).append(" ")
                .append(event.getDuration()).append("min").append(System.lineSeparator())
            ;
        }
        
        builder.append(sdf.format(pm.getTime())).append(" Networking").append(System.lineSeparator());
        
        return builder.append(System.lineSeparator()).toString();
    }
    
}
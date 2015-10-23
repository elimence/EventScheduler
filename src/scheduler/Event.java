
package scheduler;

import java.util.Date;

/**
 * 
 * @author sam
 */
public class Event implements Comparable<Event>{
    
    private int duration;
    private String title;
    private Date start;
    private Date end;
    
    /**
     * 
     * @param duration
     * @param title 
     */
    public Event(int duration, String title) {
        this.duration = duration;
        this.title = title;
    }
    
    /**
     * 
     * @param duration
     * @param title
     * @param start
     * @param end 
     */
    public Event(int duration, String title, Date start, Date end) {
        this.duration = duration;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the duration of the event
     * @return duration in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the event
     * @param duration given in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the title of the event
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set's the tile of the event
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the start date and time for the event
     * @return the start date and time
     */
    public Date getStart() {
        return start;
    }

    /**
     * Sets the start date for the event
     * @param start the start date
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Returns the end date and time for the event
     * @return the end date and time
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Set's the end date and time of the event
     * @param end the end date
     */
    public void setEnd(Date end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder
            .append("Title    : ").append(title).append(System.lineSeparator())
            .append("Duration : ").append(duration).append(" minutes").append(System.lineSeparator())
            .append("Start    : ").append(start).append(System.lineSeparator())
            .append("End      : ").append(end)
        ;
        
        return builder.toString();
    }

    @Override
    public int compareTo(Event o) {
        return o.getDuration() - duration;
    }
}

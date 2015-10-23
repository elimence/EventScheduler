
package scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import util.Utils;

/**
 *
 * @author sam
 */
public class Scheduler {
    
    // Class vars
    public List<Event> events;
    private List<Track> tracks;
    
    /**
     * Empty Constructor
     */
    public Scheduler() {
        events = new ArrayList<>();
        tracks = new ArrayList<>();
    }
    
    /**
     * 
     * @param file 
     */
    public Scheduler(String file) {
        this();
        String[] items;
        
        // Read and parse input file
        try { items = Utils.readFile(file).split(System.lineSeparator());
        } catch (IOException ex) {
            System.out.println("exception caugth: " + ex.getMessage());
            return;
        }
        
        // Temp vars
        int _eventTime = 0;
        String[] _itemList;
        String _timeString;
        String _eventTitle = "";

        for (String item : items) {
            _itemList = item.split(" ");

            try {  // iterate over input file and create instances of class Event
                _timeString = _itemList[_itemList.length - 1];
                _eventTitle = Utils.<String>join(Arrays.copyOfRange(_itemList, 0, _itemList.length - 1), " ");

                // just in case lightning is misspelled :)
                if (_timeString.equalsIgnoreCase("lightning") || _timeString.equalsIgnoreCase("lightening")) {
                    _eventTime = 5;
                } else {
                    _eventTime = Integer.parseInt(_timeString.replaceAll("[^0-9]", ""));
                }
            } catch (Exception ex) {
                System.out.println("Error parsing event: " + item + " :: " + ex.toString());
            }
            
            events.add(new Event(_eventTime, _eventTitle));
        }
        Collections.sort(events);
    }
    
    /**
     * Create event tracks recursively until all events have been scheduled
     * 
     * @param trackNumber number to identify track
     * @param set list of events from which to create track
     */
    public void createTrack(int trackNumber, List<Event> set) {
        if(set == null || set.size() <= 0) {
            return;
        }
        
        Track track = new Track("Track #" + trackNumber++);
        List<Event> remaining = track.fillTrack(set);
        tracks.add(track);
        if(remaining.size() > 0) {
            createTrack(trackNumber, remaining);
        }
    }
    
    /**
     * Display list of all events (unscheduled)
     */
    public void showEvents() {
        int count = 1;
        
        for(Event event : events) {
            System.out.println("Item #" + count++);
            System.out.println(event);
            System.out.println();
        }
    }
    
    /**
     * Display a list of all events (scheduled)
     */
    public void showTracks() {
        for(Track track : tracks) {
            System.out.println(track);
            System.out.println();
        }
    }
   
}

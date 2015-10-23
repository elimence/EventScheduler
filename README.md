# EventScheduler
Tiny program that reads a text file of events and durations, and creates an event schedule.

## Description
Given a text file of events, the program schedules these events into multiple tracts,
each track representing a day's worth of events.
Each track has the following
  1. A morning session  - `9 00 AM till 12 00 PM`
  2. Lunch break        - `12 00 PM till 1 00 PM`
  3. Afternoon session  - `1 00 PM till 4 00 PM or 5 00 PM`
  4. Networking session - starts at `4 00 PM or 5 00 PM`


## Assumptions/Constraints
  1. Morning sessions
    a. Starts at `9 00 PM`
    b. Must end by `12 00 PM`
    c. Can end before `12 00 PM`
    
  2. Afternoon sessions
    a. Starts at `1 00 PM`
    b. Must end earliest by `4 00 PM`
    c. Must end latest by `5 00 PM`
    
  3. Input Data
    a. Each line is in the format: <Event_Title Duration>
    b. Title is a string without numbers
    c. Duration is of the form <Number>mins


  ## Design
  Here's the structure of the project

      .
      ├── build
      │   └── classes
      │       ├── main
      │       │   └── Main.class
      │       ├── scheduler
      │       │   ├── Event.class
      │       │   ├── Scheduler.class
      │       │   └── Track.class
      │       └── util
      │           └── Utils.class
      ├── build.xml
      ├── manifest.mf
      ├── nbproject
      │   ├── build-impl.xml
      │   ├── genfiles.properties
      │   ├── private
      │   │   ├── private.properties
      │   │   └── private.xml
      │   ├── project.properties
      │   └── project.xml
      ├── src
      │   ├── main
      │   │   └── Main.java
      │   ├── scheduler
      │   │   ├── Event.java
      │   │   ├── Scheduler.java
      │   │   └── Track.java
      │   └── util
      │       └── Utils.java
      └── test
          ├── scheduler
          │   ├── EventIT.java
          │   ├── SchedulerIT.java
          │   └── TrackIT.java
          └── util
              └── UtilsIT.java

  The Main class in the entry point. It displays a menu and drives the execution sequence of the program.
  The Scheduler class parses the input file and creates a list of events, which are then organized into tracks.
  The track class is responsible for assigning events to tracks.
  Since the afternoon session has more constraints, it starts out by filling the afternoon session
  to the min acceptable capacity `(4 PM)`. It then fills the morning session after which any remain event's are
  added to the free period between `4 and 5 PM`
  When this is done, any remaining events are returned to be added to a new track.
  
  The way event's are scheduled into tracks is really simple.The approach used here is what I'd call a naive solution,
  as opposed to a solution that searches exhuastively for the most optimal solution.
  This chosen approach is the simplest that meets the contraints of the problem.
  
  ### How it works
    1. An array of events is created and then sorted in descending order of durations
    2. For the afternoon session, time period `1-4 PM` is filled by iterating through the event list and adding till
    theres no event that can fit in the remaining slot.
    3. All events that are successfully scheduled are removed from the event list
    4. The same is repeated for the morning session for time period `9-12 PM`
    5. The remaining events are then fitted into the period from `4-5 PM`
    6. Finally all remaining events are passed over to be scheduled in another track

  
  
  ## Running
  Project was built with netbeans and hence, using netbeans would be the easiest way to run this project.
  
    ### Running with Netbeans
      1. Import project into netbeans and then build and run.
      2. Supply path to input file when prompted
      3. Follow menu prompts to view events and schedule
      
    ### Running from command line
      1. From the terminal navigate into the project folder
      2. Change directory into the src folder
      3. Build the project using: `javac -cp . javac -cp . main/*.java scheduler/*.java util/*.java`
      4. Run the project using: `java -cp . main.Main`
      
  **NB** Theres a `data.txt` in the root folder containing sample data.


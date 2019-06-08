
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import scheduler.Scheduler;

/**
 *
 * @author  sam
 * @name    Main
 */
public class Main {
    
    private static BufferedReader reader;
    private static Scheduler schedule;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        schedule = new Scheduler();
        reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
    }

    /**
     * Nothing interesting, just a mundane method to display options
     */
    private static void menu() {
        p("\n\n Select an option \n ");
        p(" 1. Create schedule ");
        p(" 2. View Events ");
        p(" 3. View Schedule ");
        p(" 4. Get Me Out Of Here \n");
        
        pn("Option: ");
        try {
            int option = Integer.parseInt(reader.readLine());
            switch(option) {
                case 1:
                    pn("File Path: ");
                    String filePath = reader.readLine();
                    schedule = new Scheduler(filePath);
                    schedule.createTrack(1, schedule.events);
                    menu();
                    break;
                case 2:
                    if(schedule == null) p("Create Schedule First");
                    else schedule.showEvents();
                    menu();
                    break;
                case 3:
                    if(schedule == null) p("Create Schedule First");
                    else schedule.showTracks();
                    menu();
                case 4:
                    System.exit(0);
                    break;
                default:
                    p("Enter a valid option from the menu");
                    menu();
            }
        } catch(IOException ex){
            p("exception caugth " + ex.toString());
        }
    }
    // adding a small harmless comment from Chris Dare
    
    /**
     * Proxy functions to print so I don't have to type too much :)
     * @param s string to print to standard output
     */
    private static void pn(String s) { System.out.print(s);   }
    private static void p (String s) { System.out.println(s); }
}

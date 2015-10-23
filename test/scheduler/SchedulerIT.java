/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sam
 */
public class SchedulerIT {
    
    public SchedulerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTrack method, of class Scheduler.
     */
    @Test
    public void testCreateTrack() {
        System.out.println("createTrack");
        int trackNumber = 0;
        List<Event> set = null;
        Scheduler instance = new Scheduler();
        instance.createTrack(trackNumber, set);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showEvents method, of class Scheduler.
     */
    @Test
    public void testShowEvents() {
        System.out.println("showEvents");
        Scheduler instance = new Scheduler();
        instance.showEvents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTracks method, of class Scheduler.
     */
    @Test
    public void testShowTracks() {
        System.out.println("showTracks");
        Scheduler instance = new Scheduler();
        instance.showTracks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

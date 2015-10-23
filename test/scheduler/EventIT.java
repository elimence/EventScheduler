/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.util.Date;
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
public class EventIT {
    
    public EventIT() {
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

    /**
     * Test of getDuration method, of class Event.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Event instance = null;
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class Event.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int duration = 0;
        Event instance = null;
        instance.setDuration(duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Event.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Event instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class Event.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Event instance = null;
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class Event.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        Event instance = null;
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class Event.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Event instance = null;
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class Event.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        Event instance = null;
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Event instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Event o = null;
        Event instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

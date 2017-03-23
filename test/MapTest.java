/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithms.KPMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import algorithms.KPMapInterface;

/**
 *
 * @author Kasper
 */
public class MapTest {
    
    public MapTest() {
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
    public void putAndGetTest(){
        KPMapInterface mi = new KPMap(3);
        
        mi.put(5, "hej5");
        mi.put(2, "hej2");
        mi.put(17, "hej17");
        
        assertEquals("hej5", mi.get(5));
        assertEquals("hej2", mi.get(2));
        assertEquals("hej17", mi.get(17));
        
    }
    
    @Test
    public void sizeTest(){
        KPMapInterface mi = new KPMap(3);
        
        mi.put(5, "hej5");
        mi.put(2, "hej2");
        mi.put(17, "hej17");
        
        assertEquals(3, mi.size());
    }
}

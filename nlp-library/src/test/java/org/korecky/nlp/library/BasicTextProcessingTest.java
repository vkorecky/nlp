/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.korecky.nlp.library;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vkorecky
 */
public class BasicTextProcessingTest {

    public BasicTextProcessingTest() {
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
     * Test of normalizeText method, of class BasicTextProcessing.
     */
    @Test
    public void testNormalizeText() throws IOException {
        System.out.println("normalizeText");
        URL url = Resources.getResource("krakatit.txt");
        String input = Resources.toString(url, Charsets.UTF_8);
        URL urlExpResult = Resources.getResource("krakatit.txt");
        String expResult = Resources.toString(urlExpResult, Charsets.UTF_8);
        BasicTextProcessing instance = new BasicTextProcessing();
        String result = instance.normalizeText(input, true);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of wordSegmentation method, of class BasicTextProcessing.
     */
    @Test
    public void testWordSegmentation() throws IOException {
        System.out.println("countTheWords");
        URL url = Resources.getResource("krakatit.txt");
        String input = Resources.toString(url, Charsets.UTF_8);
        URL urlExpResult = Resources.getResource("krakatit.txt");
        String expResult = Resources.toString(urlExpResult, Charsets.UTF_8);
        BasicTextProcessing instance = new BasicTextProcessing();
        TreeMap<String, Long> result = instance.wordSegmentation(input, true, false);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}

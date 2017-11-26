/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */ 
package org.openide.actions; 
 
import junit.framework.Test; 
import junit.framework.TestSuite; 
import org.netbeans.junit.NbTestCase; 
import org.openide.util.HelpCtx; 
 
/** 
 * A JUnit test for CloseViewAction. 
 * 
 * @author Manfred Riem 
 * @version $Revision$ 
 */ 
public class CloseViewActionTest extends NbTestCase { 
    /** 
     * Stores our single instance. 
     */ 
    private static CloseViewAction instance = new CloseViewAction(); 
         
    /** 
     * Constructor. 
     * 
     * @param testName the name of the test. 
     */ 
    public CloseViewActionTest(String testName) { 
        super(testName); 
    } 
 
    /** 
     * Setup for testing. 
     */ 
    protected void setUp() throws Exception { 
    } 
 
    /** 
     * Cleanup after testing. 
     */ 
    protected void tearDown() throws Exception { 
    } 
 
    public static Test suite() { 
        TestSuite suite = new TestSuite(CloseViewActionTest.class); 
         
        return suite; 
    } 
 
    /** 
     * Test getActionMapKey method. 
     */ 
    public void testGetActionMapKey() { 
        Object expected = "closeWindow"; 
        Object result   = instance.getActionMapKey(); 
         
        assertEquals(expected, result); 
    } 
 
    /** 
     * Test getHelpCtx method. 
     */ 
    public void testGetHelpCtx() { 
        HelpCtx expected = new HelpCtx(CloseViewAction.class);; 
        HelpCtx result   = instance.getHelpCtx(); 
         
        assertEquals(expected, result); 
    } 
 
    /** 
     * Test getName method. 
     */ 
    public void testGetName() { 
        String expected = "Close"; 
        String result   = instance.getName(); 
         
        assertEquals(expected, result); 
    } 
 
    /** 
     * Test asynchronous method. 
     */ 
    public void testAsynchronous() { 
        boolean expected = false; 
        boolean result   = instance.asynchronous(); 
         
        assertEquals(expected, result); 
    }     
} 

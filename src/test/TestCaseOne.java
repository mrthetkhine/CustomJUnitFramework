/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import annotation.MyTestCase;
import annotation.Test;
import static ourassert.Assert.*;
/**
 *
 * @author Mr T.Khine
 */
@MyTestCase

public class TestCaseOne {
    
    @Test
    public void testMethod()
    {
        System.out.println("This is test method");
    }
    @Test
    public void testMethod2()
    {
        System.out.println("This is test method2");
        String str = "";
        assertNull("String must be null",str);
    }
 
    @Test
    public void normalMethod()
    {
        System.out.println("This is normal method");
        //assertEqual("Two object must be same", "Hello", "Hello1");
        assertEqual("1+1 must be 2 ", 1+1, 3);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import annotation.MyTestCase;
import annotation.Test;

/**
 *
 * @author Mr T.Khine
 */
@MyTestCase
public class TestCaseTwo {
    @Test
    public void testMethod()
    {
        System.out.println("This is test method of test case2");
    }
    @Test
    public void testMethod2()
    {
        System.out.println("This is test method2 of test case 2");
    }
    public void method()
    {
        System.out.println("Normal Method of Test Case Two");
    }
    
}

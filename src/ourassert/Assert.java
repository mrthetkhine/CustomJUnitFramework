/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourassert;

/**
 *
 * @author Mr T.Khine
 */
public class Assert {
    
    public static void fail(String message)
    {
        throw new AssertionError(message);
    }
    public static void assertEqual(String message,Object exp,Object result)
    {
        //System.out.println("AssertEqual");
        if(exp != result)
        {
            //System.out.println("Assetion Error");
            fail(message);
        }
    }
    public static void assertNull(String message,Object exp)
    {
        if(exp != null)
        {
            fail(message);
        }
    }
    public static void assertTrue(String message,boolean exp)
    {
        if(exp != true)
        {
            fail(message);
        }
    }
    public static void aseertEqual(String message,int exp,int result)
    {
        if(exp != result)
        {
            fail(message);
        }
    }
}


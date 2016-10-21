/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourjunit;
import annotation.MyTestCase;
import annotation.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import test.ListAllClass;
/**
 *
 * @author Mr T.Khine
 */
public class TestFramework {
    
    

    private ArrayList<Class<?>> getClassWithTestAnnoation(String packageName) {
        List<Class<?>> allClass = ListAllClass.find(packageName);
        
        ArrayList<Class<?>> classesWithTestAnnotation =new ArrayList<Class<?>>();
        
        for (Class<?> myClass : allClass) {
            Annotation[] classAnno = myClass.getAnnotations();
            
            for (Annotation ann : classAnno) {
                if(ann instanceof MyTestCase)
                {
                    classesWithTestAnnotation.add(myClass);
                }
            }
        }
        return classesWithTestAnnotation;
    }
    public void runTest(String packageName)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
       ArrayList<Class<?>> testClasses = getClassWithTestAnnoation(packageName);
       
       ArrayList<AssertionError> errors = new ArrayList<AssertionError>();
       int methodErrorCount = 0;
        for (Class<?> testClass : testClasses ) {
            
            
            Method method[] = testClass.getDeclaredMethods();
            
            
            for (Method meth : method) {
                Annotation annot[] = meth.getAnnotations();
                
                for (Annotation ann : annot) {
                    if(ann instanceof Test)
                    {
                        //System.out.println("Test class "+testClass+"Test Method name " + meth.getName());
                        try
                        {
                            Object testObject = testClass.newInstance();
                            meth.invoke(testObject, null);
                        }
                        catch(AssertionError ae)
                        {
                            System.out.println("Assertion Error");
                            methodErrorCount++;
                            errors.add(ae);
                        }
                        catch(java.lang.reflect.InvocationTargetException e)
                        {
                            methodErrorCount++;
                            errors.add(new AssertionError(e.getCause()));
                        }
                        
                    }
                }//End of method anno
            }//end of method
        }//end of class
        
        System.out.println("Total Error "+ methodErrorCount);
        for (AssertionError ae : errors) {
            System.err.println(ae.getMessage());
        }
    }
    public static void main(String[] args)  {
        
        TestFramework tdd = new TestFramework();
        try
        {
            tdd.runTest("test");
        }
        catch(Exception e)
        {
        }
        
    }
}

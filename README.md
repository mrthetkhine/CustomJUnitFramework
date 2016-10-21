# CustomJUnitFramework
How to build JUnit like framework with Java
First create Assert function like assertEqual etc
They are in ourassert package.

Second Create annotation to be used as Test class and method
They are in package annotation.

Third read a class reader which traverse the current class package with File utilities and load the class with Class.forName
For each loaded class, we will find class with annoation and invoke test method using Reflection API.
These are in package ourjunit.

Fourth create class for unit testing with our annotation.
In package test,

Now run, ourjunit.TestFramework main by giving paramter to test package as follows.
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

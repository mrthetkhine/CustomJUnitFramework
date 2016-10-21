/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author Mr T.Khine
 */
public class TestAnnoation {
    public static void main(String[] args) {
        Class testClass  = TestCaseOne.class;
        Annotation[] annos = testClass.getAnnotations();
        for (Annotation an : annos) {
            System.out.println(an);
        }
        
        Method methods[] = testClass.getDeclaredMethods();
        for (Method method : methods) {
            Annotation methodAnno[] = method.getAnnotations();
            System.out.println("Method name "+ method.getName()  );
            for (Annotation ann : methodAnno) {
                System.out.println("Ann of method "+ann.toString());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Mr T.Khine
 */
public class ListAllClass {
     private static final char DOT = '.';

    private static final char SLASH = '/';

    private static final String CLASS_SUFFIX = ".class";
    
     public static List<Class<?>> find(String scannedPackage) {
         
        String scannedPath = scannedPackage.replace(DOT, SLASH);
       
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
     
        if (scannedUrl == null) 
        {
            throw new IllegalArgumentException(String.format("Unable to get class", scannedPath, scannedPackage));
        }
        File scannedDir = new File(scannedUrl.getFile());
        
        List<Class<?>> classesInPackage = new ArrayList<Class<?>>();
        
        File packageRoot = new File(scannedDir.getAbsolutePath().replaceAll("%20", " "));
        for (File file : packageRoot.listFiles()) 
        {
            classesInPackage.addAll(find(file, scannedPackage));
        }
        return classesInPackage;
    }
   

    private static List<Class<?>> find(File file, String scannedPackage) {
        
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + DOT + file.getName();
        if (file.isDirectory()) 
        {
            for (File child : file.listFiles()) 
            {
                classes.addAll(find(child, resource));
            }
        } 
        else if (resource.endsWith(CLASS_SUFFIX)) 
        {
            int endIndex = resource.length() - CLASS_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try 
            {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) 
            {
            }
        }
        return classes;
    }
    public static void main(String[] args) {
        List<Class<?>> allClass = find("annotation");
        for (Class<?> clazz : allClass) {
            System.out.println(clazz.getName());
        }
    }
}

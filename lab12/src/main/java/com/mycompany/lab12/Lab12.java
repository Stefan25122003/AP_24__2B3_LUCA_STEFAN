package com.mycompany.lab12;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import org.junit.Test;

public class Lab12 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Lab12 <class-name>");
            return;
        }

        String className = args[0];
        try {
            Class<?> clazz = loadClass(className);
            extractClassInformation(clazz);
            invokeTestMethods(clazz);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Class<?> loadClass(String className) throws ClassNotFoundException {
        URL classURL = Lab12.class.getProtectionDomain().getCodeSource().getLocation();
        URL[] urls = { classURL };
        try (URLClassLoader urlClassLoader = new URLClassLoader(urls)) {
            return Class.forName(className, true, urlClassLoader);
        } catch (Exception e) {
            throw new ClassNotFoundException("Unable to load class: " + className, e);
        }
    }

    private static void extractClassInformation(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName() + 
                               ", Return type: " + method.getReturnType() + 
                               ", Modifiers: " + Modifier.toString(method.getModifiers()));
        }
    }

    private static void invokeTestMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && 
                Modifier.isStatic(method.getModifiers()) && 
                method.getParameterCount() == 0) {
                try {
                    method.setAccessible(true);  
                    method.invoke(null);
                    System.out.println("Invoked @Test Method: " + method.getName());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.err.println("Failed to invoke method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}


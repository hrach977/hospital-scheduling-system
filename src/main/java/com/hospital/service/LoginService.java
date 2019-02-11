package com.hospital.service;

import com.hospital.entities.Patient;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginService {

    public static <T> void login(String username, String password, Class<T> clazz) {
       // String interfaceName = clazz.getSimpleName() + "Repository";
        String interfaceName = clazz.getName().replaceFirst("entities", "dal") + "Repository";
        System.out.println(interfaceName);

        Method method = null;

        try {
            method = Class.forName(interfaceName).getMethod("findByUsername", String.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }

         Constructor constructor = null;
         String className = interfaceName.substring(0, interfaceName.lastIndexOf(".")+1) + "impl." + clazz.getSimpleName() + "RepositoryImpl";
         System.out.println(className);
         try {
            constructor = Class.forName(className).getConstructor();
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object object = null;
        try {
             object = constructor.newInstance(new Object[] {});
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        T entity = null;
        try {
           entity = (T) method.invoke(object, username);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(entity);

        String storedPassword = null;
        try {
             Field enField =  entity.getClass().getDeclaredField("password");
             enField.setAccessible(true);
             storedPassword = (String) enField.get(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(storedPassword);

        if (password.equals(storedPassword)) { //check after encryption
            System.out.println("Logged in successfully");
        }
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        login(username, password, Patient.class);
    }
}

package com.mitsuha;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @className TestGenerics
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/6/23 10:41
 **/
public class TestGenerics<T, E> {
    T t;
    E e;

    public <T> void testMethod(T t){

    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(23);
        try {
            Method method = ls.getClass().getDeclaredMethod("add",Object.class);
            method.invoke(ls,"test");
            method.invoke(ls,42.9f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for ( Object o: ls){
            System.out.println(o);
        }
    }

    public class Erasure <T extends String>{
        //	public class Erasure <T>{
        T object;

        public Erasure(T object) {
            this.object = object;
        }
    }


}

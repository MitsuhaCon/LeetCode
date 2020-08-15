package com.mitsuha.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Person
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/6/24 11:18
 **/
@Person(role = "CEO")
@Person(role = "husband")
public class Man {
    private String name;

    private int age;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            list.add(i);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
        Man man = new Man();
        System.out.println(man.age);
    }

    public int getAge() {
        return age;
    }

    @IntegerAnnotation(value = 10)
    public void setAge(int age) {
        this.age = age;
    }
}

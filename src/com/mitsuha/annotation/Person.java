package com.mitsuha.annotation;

import java.lang.annotation.*;

/**
 * @author MitsuhaCon
 */
@Repeatable(Persons.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String role() default "";
}

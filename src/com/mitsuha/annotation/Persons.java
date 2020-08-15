package com.mitsuha.annotation;

import java.lang.annotation.*;

/**
 * @author MitsuhaCon
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Persons {
    Person[] value();
}

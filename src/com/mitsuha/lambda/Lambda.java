package com.mitsuha.lambda;

import java.util.function.Function;

/**
 * @ClassName Lambda
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/6/24 15:46
 **/
public class Lambda {
    public static void main(String[] args) {
        TestLambda testLambda = new TestLambda() {
            @Override
            public int test() {
                return 0;
            }
        };
        TestLambda t = () -> {
            return 0;
        };
        Test test = (final int a, final int b) -> {return a + b;};
        System.out.println(test.add(10, 20));
    }
}

interface Test{
    int add(final int a, final int b);
}
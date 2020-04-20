package com.cz.demo.test;

/**
 * Created 2019-09-19.
 *
 * @author changzheng
 */
public class NiMing {
    interface Test{
        void say();
    }

    public static void main(String[] args) {
        Test test =new Test() {
            @Override
            public void say() {
                System.out.println("匿名内部类");
            }
        };test.say();

        new Test(){

            @Override
            public void say() {
                System.out.println("匿名内部类.访问");
            }
        }.say();

        Test test1 = () -> System.out.println("lambda");
        test1.say();
    }
}

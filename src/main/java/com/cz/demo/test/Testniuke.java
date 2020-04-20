package com.cz.demo.test;

import java.util.Scanner;

/**
 * Created 2020/4/13. 5:05 下午
 *
 * @author changzheng
 */
public class Testniuke {
    public static void main(String[] args) {
        int n;
        int max=0;
        int array[] = new int[0];
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n = in.nextInt();
            array = new int[n];
            for(int i=0;i<n;i++){
                array[i]=in.nextInt();
                max = max>array[i] ? max:array[i];
            }
        }

        System.out.println(get(max,array));
    }
    public static String get(int max,int[] array){
        if(array.length==0){
            return "YES";
        }

        for(int j=0;j<array.length;j++){
            if(array[j]<max){
                int temp = array[j];
                while(temp*2<max){
                    temp=temp*2;
                }
                if(temp!=max){
                    return "NO";
                }
            }
        }
        return "YES";


    }
}

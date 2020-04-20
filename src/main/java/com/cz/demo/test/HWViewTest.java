package com.cz.demo.test;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created 2020/4/2. 4:41 下午
 *
 * @author changzheng
 */
public class HWViewTest {

    public static void main(String[] args) {
        test1(new int[]{1, 3, 2, 1, 4, 5}, 5);
        System.out.println(getResult(24));
    }

    public static void test1(int[] s, int k) {
        if (s == null || s.length == 0) {
            return;
        }
        quickSort(s, 0, s.length - 1);
        Set<Integer> set = Sets.newHashSet();
        for (int i = 0; i < s.length; i++) {
            if (set.contains(k-s[i])){
                System.out.println(s[i]+","+(k-s[i]));
            }else {
                set.add(s[i]);
            }
        }
    }

    public static void quickSort(int[] s, int low, int high) {
        int i = low, j = high;
        if (i > j) {
            return;
        }
        int temp = s[low];
        while (i < j) {
            while (i < j && s[j] >= temp) {
                j--;
            }
            s[i] = s[j];
            while (i < j && s[i] <= temp) {
                i++;
            }
            s[j] = s[i];
        }
        s[i] = temp;
        quickSort(s, low, j - 1);
        quickSort(s, j + 1, high);
    }

    public static String getResult(int n){
        StringBuilder stringBuilder = new StringBuilder();
        int temp=n;
        for (int i =2;i<=temp;i++){
            while (temp%i ==0){
                stringBuilder.append(i+"*");
                temp=temp/i;
            }
        }
        if (stringBuilder.length()!=0){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append("="+n);
        }
        return stringBuilder.toString();
    }
}

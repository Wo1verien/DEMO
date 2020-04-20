package com.cz.demo.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 2019/10/9.
 *
 * @author changzheng
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<String> filtered = strings.stream().map(j->j+j).collect(Collectors.toList());
        strings.sort(Comparator.comparingInt(String::length));
        System.out.println(strings);
        System.out.println(filtered);
    }
}

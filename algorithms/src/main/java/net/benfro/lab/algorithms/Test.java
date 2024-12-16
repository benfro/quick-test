package net.benfro.lab.algorithms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Stream.of(1, 2, 3).collect(Collectors.toList());
    }
}

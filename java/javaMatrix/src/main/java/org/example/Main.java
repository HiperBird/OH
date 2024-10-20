package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {8, 64, 256, 512, 1024, 2048};
        MatrixTest test = new MatrixTest(sizes, 3);
        test.runTests();
        System.out.print(test);
        System.out.print("\nSizes: ");
        System.out.print(Arrays.toString(sizes));
        System.out.print("\nTimes: ");
        System.out.print(Arrays.deepToString(test.times));
        System.out.print("\nMemory usage: ");
        System.out.print(Arrays.deepToString(test.memory));
    }

}


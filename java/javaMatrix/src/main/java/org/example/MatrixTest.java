package org.example;
import java.util.stream.*;
import java.util.Arrays;

public class MatrixTest{

    static long[][] times;
    static long[][] memory;
    static int[] sizes;
    private static int repetitions;
    Matrix mat;


    public MatrixTest(int[] size, int reps){
        repetitions = reps;
        sizes = size;
        times = new long[size.length][reps];
        memory = new long[size.length][reps];


    }
    public void test(int size, int index){
        System.gc();
        mat.randomize();
        long tempTime  = System.currentTimeMillis();
        long tempMemory = Runtime.getRuntime().freeMemory();
        mat.matmult();
        times[size][index]  = System.currentTimeMillis() - tempTime;
        memory[size][index] =  Runtime.getRuntime().freeMemory() - tempMemory;
        System.gc();
    }
    public void runTests(){
        for (int size = 0; size < sizes.length; size++) {
            mat = new Matrix(sizes[size]);
            for (int index = 0; index < repetitions; index++) {
                 test(size, index);
            }
        }
    }

    public static long getTotalTime(int size) {
        long average = 0;
        for (int index=0; index<repetitions; index++){
            average += times[size][index];
        }
        return average;
    }
    public static long getTotalMemory(int size) {
        long average = 0;
        for (int index=0; index<repetitions; index++){
            average +=  memory[size][index];
        }
        return average/repetitions;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Tests ran: \n");
        for (int size = 0; size<sizes.length; size++){
            result.append("Ran ")
                    .append(String.valueOf(repetitions))
                    .append(" tests of matrices of size ")
                    .append(String.valueOf(sizes[size]));
            String time = String.valueOf((double)getTotalTime(size) / 1000 / repetitions);
            String timeperEntry = String.valueOf((double)getTotalTime(size)*1000 / sizes[size]/sizes[size] / repetitions);
            String memory = String.valueOf((double)getTotalMemory(size) / (2 ^ 20) / repetitions);
            result.append(" with an average time of ")
                    .append(time)
                    .append(" an an average use of memory of ")
                    .append(memory)
                    .append(" And a time per 1000 entrys" +
                            ".02+  of ")
                    .append(timeperEntry)
                    .append("\n");
        }
        return result.toString();
    }
}


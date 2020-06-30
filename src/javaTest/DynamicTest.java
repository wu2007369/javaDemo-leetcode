package javaTest;

import java.math.BigDecimal;

public class DynamicTest {
    public static void main(String[] args) {
        printArray(fibonaci(100));
        //354224848179261915075
    }

    private static void printArray(BigDecimal[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
            if (i % 10 == 0)
                System.out.println();

        }

    }
    private static BigDecimal[] fibonaci(int n) {
        BigDecimal[] array = new BigDecimal[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i > 1) {
                array[i] = new BigDecimal(array[i-1].toBigInteger().add(array[i-2].toBigInteger())) ;
            } else {
                array[i] = new BigDecimal(i);
            }
        }

        return array;

    }


}
